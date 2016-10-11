package com.demo1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo1.dao.AreaMapper;
import com.demo1.dao.CityMapper;
import com.demo1.dao.ProvinceMapper;
import com.demo1.entity.Area;
import com.demo1.entity.City;
import com.demo1.entity.Province;

/**
 * 处理业务
 * 
 * @author Zhang wenmeng
 * 
 */
@Service
public class PC {

	@Autowired
	ProvinceMapper dao;

	@Autowired
	CityMapper dao1;

	@Autowired
	AreaMapper dao2;

	// 查询出所有的省份
	public List<Province> showProvinceList() {

		return dao.showProvinceList();
	}

	// 根据省id来查询所对应的城市名称
	public List<City> showCityListByPid(int pid) {
		return dao1.showCityListByPid(pid);
	}

	// 根据city的id来查询所有的区、县
	public List<Area> showAreaListBycid(int cid) {
		return dao2.showAreaListBycid(cid);
	}

}
