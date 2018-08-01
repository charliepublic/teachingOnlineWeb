package com.aneon.mapper;
import com.aneon.po.Team;

import java.util.List;

public interface TeamMapper {
    int addTeam(Team team);
    List<Team> getAllTeam();
    Team getTimeByNumber(String Gnumber);
}
