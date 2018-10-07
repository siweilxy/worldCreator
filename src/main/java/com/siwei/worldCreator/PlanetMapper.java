package com.siwei.worldCreator;

import java.util.List;

public interface PlanetMapper {
	int insertPlanet(Planet planet);
	List<Planet> selectAllPlanet();
	Planet selectById(int id);
	Planet selectByXY(float x,float y);
}
