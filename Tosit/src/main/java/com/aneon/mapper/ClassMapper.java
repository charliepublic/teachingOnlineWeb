package com.aneon.mapper;

import java.util.List;

public interface ClassMapper {
    void saveClass(Class cls);

    boolean updateClass(Class cls);

    boolean deleteClass(int cnumber);

    Class findCalss(int cnumber);

    List<Class> getAllClass();
}
