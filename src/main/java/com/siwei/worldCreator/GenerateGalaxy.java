package com.siwei.worldCreator;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class GenerateGalaxy extends Thread {
	SqlSession session;
	GalaxyMapper galaxyMapper;
	PlanetMapper planetMapper;
	SqlSessionFactory sessionFactory;

	public GenerateGalaxy() {
		System.out.println("GenerateGalaxy.GenerateGalaxy()");
		Reader reader;
		try {
			reader = Resources.getResourceAsReader("mybatis-config.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sessionFactory.openSession();
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		galaxyMapper = session.getMapper(GalaxyMapper.class);
		planetMapper = session.getMapper(PlanetMapper.class);

	}

	private Boolean CheckItem(Galaxy galaxy) {
		Galaxy galaxy3 = galaxyMapper.selectByXY(galaxy.getX(), galaxy.getY());
		if (galaxy3 != null) {
			System.out.println("X:" + galaxy.getX() + " Y:" + galaxy.getY() + " is already exist, new id is "
					+ galaxy.getId() + " old id is " + galaxy3.getId());
			return false;
		}
		return true;
	}

	private Boolean CheckItem(Planet planet) {
		Planet planet3 = planetMapper.selectByXY(planet.getX(), planet.getY());
		if (planet3 != null) {
			System.out.println("X:" + planet.getX() + " Y:" + planet.getY() + " is already exist, new id is "
					+ planet.getId() + " old id is " + planet3.getId());
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
		}
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
				System.out.println("generate a galaxy,has " + galaxy.getProduct() + " planets");
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
