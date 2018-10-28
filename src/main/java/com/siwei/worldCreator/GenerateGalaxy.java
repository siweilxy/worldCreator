package com.siwei.worldCreator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class GenerateGalaxy extends Thread {
	GalaxyMapper galaxyMapper;
	PlanetMapper planetMapper;
	SpaceMapper spaceMapper;
	SourceMapper sourceMapper;
	SessionSql session;
	Log log;

	public GenerateGalaxy() {
		log = LogFactory.getLog(GenerateGalaxy.class);
		session = new SessionSql();
		galaxyMapper = session.getSession().getMapper(GalaxyMapper.class);
		planetMapper = session.getSession().getMapper(PlanetMapper.class);
		spaceMapper = session.getSession().getMapper(SpaceMapper.class);
		sourceMapper = session.getSession().getMapper(SourceMapper.class);

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
			log.warn("checkGalaxy failed");
			return null;
		}
		log.warn("galaxy is x: " + galaxy.getX() + " y: " + galaxy.getY()+" product is "+galaxy.getProduct());
		galaxyMapper.insertGalaxy(galaxy);
		return galaxy;
	}

	private boolean GenP(ItemFactory itemFactory, Galaxy galaxy) {
		for (int i = 0; i < galaxy.getProduct(); i++) {
			Planet planet = (Planet) itemFactory.productItem(Planet.class);
			if (!CheckItem(planet)) {
				log.warn("check planet failed");
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
			space.setProduct(space.getProduct() % 50);
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
					log.warn("galaxy is null");
					continue;
				}

				if (!GenP(itemFactory, galaxy)) {
					log.warn("GenP failed");
					continue;
				}

				session.getSession().commit();
				log.warn("generate a galaxy,has " + galaxy.getProduct() + " planets");
				Thread.sleep(1000*60*60*24);
			} catch (InterruptedException e) {
				session.getSession().rollback();
				e.printStackTrace();
			} /*
				 * finally { session.close(); }
				 */
		}
	}
}
