package com.siwei.worldCreator;

import java.util.List;

public interface SpaceMapper {
	int insertSpace(Space space);
	List<Space> selectAllSpace();
	Space selectById(int id);
	Space selectByXY(float x,float y);
}
