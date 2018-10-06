package com.siwei.worldCreator;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Random;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class GenerateGalaxy extends Thread {
	private int id;
	SqlSession session;

	public GenerateGalaxy() {
		System.out.println("GenerateGalaxy.GenerateGalaxy()");
		id = 0;
		Reader reader;
		try {
			reader = Resources.getResourceAsReader("mybatis-config.xml");
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sessionFactory.openSession();
			List<Item> cList = session.selectList("selectAllSources");
			for (Item item : cList) {
				System.out.println(item.getId());
			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Galaxy productGalaxy() {
		Galaxy galaxy = new Galaxy();
		Random random = new Random();
		galaxy.setId(id++);
		galaxy.setX(random.nextInt(1000000) + 1);
		galaxy.setY(random.nextInt(1000000) + 1);
		galaxy.setUp("");
		galaxy.setDown("");
		return galaxy;
	}

	@Override
	public void run() {
		this.setName("GenerateGalaxy");
		GalaxyMapper galaxyMapper = session.getMapper(GalaxyMapper.class);
		ItemFactory itemFactory = new ItemFactory();
		while (true) {
			try {
				Galaxy galaxy = (Galaxy) itemFactory.productItem(Galaxy.class);
				Galaxy galaxy2 = galaxyMapper.selectById(galaxy.getId());
				if (galaxy2 != null) {
					System.out.println("id " + galaxy2.getId() + " is already exist");
					continue;
				}
				galaxyMapper.insertGalaxy(galaxy);
				session.commit();
				Thread.sleep(3600000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
