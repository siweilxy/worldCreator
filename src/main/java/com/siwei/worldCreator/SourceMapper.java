 package com.siwei.worldCreator;

import java.util.List;

public interface SourceMapper {
	int insertSources(Sources sources);

	List<Sources> selectAllSources();

	Sources selectById(int id);
	void updateSources(Sources sources);
}
