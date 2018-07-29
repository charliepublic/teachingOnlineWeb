package com.aneon.mapper;

import java.util.List;

public interface ClassMapper {
    int saveClass(Class cls);

    int updateClass(Class cls);

    int deleteClass(int cnumber);

    Class findCalss(int cnumber);

    List<Class> getAllClass();
}
