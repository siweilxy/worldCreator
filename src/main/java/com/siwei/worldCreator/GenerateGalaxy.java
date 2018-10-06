package com.siwei.worldCreator;

import java.awt.CheckboxMenuItem;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Random;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class GenerateGalaxy extends Thread {
	SqlSession session;
	GalaxyMapper galaxyMapper;
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
	}

	private Boolean CheckItem(Galaxy galaxy) {
		Galaxy galaxy2 = galaxyMapper.selectById(galaxy.getId());
		if (galaxy2 != null) {
			System.out.println("id " + galaxy2.getId() + " is already exist");
			return false;
		}

		Galaxy galaxy3 = galaxyMapper.selectByXY(galaxy.getX(), galaxy.getY());
		if (galaxy3 != null) {
			System.out.println("X:" + galaxy.getX() + " Y:" + galaxy.getY() + " is already exist, new id is "
					+ galaxy.getId() + " old id is " + galaxy3.getId());
			return false;
		}
		return true;
	}

	@Override
	public void run() {
		this.setName("GenerateGalaxy");
		ItemFactory itemFactory = new ItemFactory();
		while (true) {
			try {
				Galaxy galaxy = (Galaxy) itemFactory.productItem(Galaxy.class);
				session = sessionFactory.openSession();
				if (!CheckItem(galaxy)) {
					continue;
				}
				galaxyMapper.insertGalaxy(galaxy);
				session.commit();
				Thread.sleep(3600000);
			} catch (InterruptedException e) {
				session.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
	}
}
