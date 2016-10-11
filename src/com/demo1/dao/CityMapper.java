package com.demo1.dao;

import com.demo1.entity.City;

import java.util.List;

/**
 * 城市接口
 */
public interface CityMapper {
    // 根据省id来查询对应的城市
    List<City> showCityListByPid(Integer id);
}