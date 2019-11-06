package com.offcn.sys.service;

import com.offcn.sys.bean.Sources;

import java.util.List;

public interface SourcesService {
    List<Sources> infoSource(int pid);

    void insertSource(Sources sources);

    Sources lookSource(Integer id);

    void updateSource(Sources sources);

    void deleteSource(Integer id);

    List<Sources> lookMenu(Integer eid);
}
