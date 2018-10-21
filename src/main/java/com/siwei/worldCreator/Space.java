package com.siwei.worldCreator;

import java.util.Map;
import java.util.Random;

public class Space extends Item {
	private int height;
	Map<Integer, Integer> sources;
	public int getHeight() {
		return height;
	}
	public void setHeight() {
		Random random = new Random();
		height = random.nextInt(100) + 1;
	}
	public Map<Integer, Integer> getSources() {
		return sources;
	}
	public void setSources(Map<Integer, Integer> sources) {
		this.sources = sources;
	}

}
