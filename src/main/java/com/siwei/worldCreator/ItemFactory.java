package com.siwei.worldCreator;

import java.lang.reflect.InvocationTargetException;

public class ItemFactory {
	private int galaxyId;
	private int planetId;
	

	public Item productItem(Class<?extends Item> classname) {
		Item item = null;
		try {
			Class<Item> mClass = (Class<Item>) Class.forName(classname.getName());
			item = mClass.getDeclaredConstructor().newInstance();
			item.setItem(galaxyId++);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return item;
	}
}
