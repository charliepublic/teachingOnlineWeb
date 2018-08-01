package com.aneon.service.Impl;

import com.aneon.mapper.ClassMapper;
import com.aneon.po.Class;
import com.aneon.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    ClassMapper classMapper;

    @Override
    public List<Class> getClassById(int Cnumber) {
        return classMapper.findClass(Cnumber);
    }

    @Override
    public int moreClass(Class cls) {
        return classMapper.addClass(cls);
    }


    @Override
    public int changeClass(Class cls) {
        Map<String,Object> change = new HashMap<>();
        change.put("Cnumber",cls.getCnumber());
        change.put("Cname",cls.getCname());
        return classMapper.updateClass(change);
    }

    @Override
    public int remoClass(int Cnumber) {
        return classMapper.deleteClass(Cnumber);
    }

    @Override
    public List<Class> qureyAllClass() {
        return classMapper.getAllClass();
    }

    @Override
    public List<Class> getClassId() {
        return classMapper.getClassNum();
    }
}
