package com.siwei.worldCreator;

public class Generator {
	private GenerateGalaxy galaxy;
	private GenerateSources sources;

	public Generator() {
		galaxy = new GenerateGalaxy();
		sources = new GenerateSources();
	}
	void run() {
		galaxy.start();
		//sources.start();
	}
}
