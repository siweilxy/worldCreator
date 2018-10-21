package com.siwei.worldCreator;

import java.io.IOException;
import java.io.Reader;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class GenerateGalaxy extends Thread {
	SqlSession session;
	GalaxyMapper galaxyMapper;
	PlanetMapper planetMapper;
	SpaceMapper spaceMapper;
	SourceMapper sourceMapper;
	SqlSessionFactory sessionFactory;
	Log log;

	public GenerateGalaxy() {
		log = LogFactory.getLog(GenerateGalaxy.class);
		log.debug("GenerateGalaxy.GenerateGalaxy()");
		Reader reader;
		try {
			reader = Resources.getResourceAsReader("mybatis-config.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sessionFactory.openSession();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		galaxyMapper = session.getMapper(GalaxyMapper.class);
		planetMapper = session.getMapper(PlanetMapper.class);
		spaceMapper = session.getMapper(SpaceMapper.class);
		sourceMapper = session.getMapper(SourceMapper.class);

	}

	private Boolean CheckItem(Galaxy galaxy) {
		Galaxy galaxy3 = galaxyMapper.selectByXY(galaxy.getX(), galaxy.getY());
		if (galaxy3 != null) {
			log.warn("X:" + galaxy.getX() + " Y:" + galaxy.getY() + " is already exist, new id is " + galaxy.getId()
					+ " old id is " + galaxy3.getId());
			return false;
		}
		return true;
	}

	private Boolean CheckItem(Planet planet) {
		Planet planet3 = planetMapper.selectByXY(planet.getX(), planet.getY());
		if (planet3 != null) {
			log.warn("X:" + planet.getX() + " Y:" + planet.getY() + " is already exist, new id is " + planet.getId()
					+ " old id is " + planet3.getId());
			return false;
		}
		return true;
	}

	private Boolean CheckItem(Space space) {
		Space space3 = spaceMapper.selectByXY(space.getX(), space.getY());
		if (space3 != null) {
			log.warn("space X:" + space.getX() + " Y:" + space.getY() + " is already exist " + " old id is "
					+ space3.getId());
			return false;
		}
		return true;
	}

	private Galaxy GenG(ItemFactory itemFactory) {
		Galaxy galaxy = (Galaxy) itemFactory.productItem(Galaxy.class);
		if (!CheckItem(galaxy)) {
			return null;
		}
		galaxyMapper.insertGalaxy(galaxy);
		return galaxy;
	}

	private boolean GenP(ItemFactory itemFactory, Galaxy galaxy) {
		for (int i = 0; i < galaxy.getProduct(); i++) {
			Planet planet = (Planet) itemFactory.productItem(Planet.class);
			if (!CheckItem(planet)) {
				continue;
			}
			planet.setUp(String.valueOf(galaxy.getId()));
			planetMapper.insertPlanet(planet);
			GenSpace(itemFactory, planet);
		}
		return true;
	}

	private boolean GenSpace(ItemFactory itemFactory, Planet planet) {
		log.debug("planet " + planet.getId() + " has " + planet.getProduct() + " products");
		for (int i = 0; i < planet.getProduct(); i++) {
			Space space = (Space) itemFactory.productItem(Space.class);
			if (!CheckItem(space)) {
				return false;
			}
			space.setHeight();
			space.setUp(String.valueOf(planet.getId()));
			space.setProduct(space.getProduct()%50);
			spaceMapper.insertSpace(space);
			GenerateSources(space);
		}
		return true;
	}

	private boolean GenerateSources(Space space) {
		Sources sources = new Sources();
		sources.setId(space.getId());
		sources.generateSourcesByRand(space.getProduct());
		sourceMapper.insertSources(sources);
		return true;
	}

	@Override
	public void run() {
		this.setName("GenerateGalaxy");
		ItemFactory itemFactory = new ItemFactory();
		while (true) {
			try {
				Galaxy galaxy = GenG(itemFactory);
				if (galaxy == null) {
					continue;
				}

				if (!GenP(itemFactory, galaxy)) {
					continue;
				}

				session.commit();
				log.warn("generate a galaxy,has " + galaxy.getProduct() + " planets");
				// Thread.sleep(1000);
				Thread.sleep(3600000);
			} catch (InterruptedException e) {
				session.rollback();
				e.printStackTrace();
			} /*
				 * finally { session.close(); }
				 */
		}
	}
}
