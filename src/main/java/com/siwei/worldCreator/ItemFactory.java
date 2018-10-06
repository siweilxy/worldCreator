package com.siwei.worldCreator;

import java.lang.reflect.InvocationTargetException;

public class ItemFactory {
	private int galaxyId;
	private int planetId;

	public ItemFactory() {
		galaxyId = 0;
		planetId = 0;
	}

	public Item productItem(Class<? extends Item> classname) {
		Item item = null;
		try {
			Class<Item> mClass = (Class<Item>) Class.forName(classname.getName());
			System.out.println(classname.getName());
			item = mClass.getDeclaredConstructor().newInstance();
			switch (classname.getName()) {
			case "com.siwei.worldCreator.Galaxy":
				item.setItem(galaxyId++);
				break;
			case "com.siwei.worldCreator.Planet":
				item.setItem(planetId++);
				break;
			default:
				break;
			}
			item.setItem(galaxyId++);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return item;
	}
}
