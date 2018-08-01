package com.aneon.service;

import com.aneon.po.Class;

import java.util.List;
import java.util.Map;

public interface ClassService {
    public List<Class> getClassById(int Cnumber);
    public int moreClass(Class cls);
    public int changeClass(Class cls);
    public int remoClass(int cls);
    public List<Class> qureyAllClass();
    public List<Class> getClassId();
}
