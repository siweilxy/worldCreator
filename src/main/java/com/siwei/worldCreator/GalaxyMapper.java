package com.siwei.worldCreator;

import java.util.List;

public interface GalaxyMapper {
	int insertGalaxy(Galaxy galaxy);
	List<Galaxy> selectAllGalaxy();
	Galaxy selectById(int id);
	Galaxy selectByXY(float x,float y);
}
