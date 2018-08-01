package com.aneon.mapper;
import com.aneon.po.Class;
import java.util.List;
import java.util.Map;

public interface ClassMapper {
    int addClass(Class cls);

    int updateClass(Map a);

    int deleteClass(int Cnumber);

    List<Class> findClass(int Cnumber);

    List<Class> getAllClass();
    List<Class> getClassNum();
}
