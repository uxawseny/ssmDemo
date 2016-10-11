package com.demo1.dao;

import com.demo1.entity.Area;
import java.util.List;

/**
 * 区、县接口
 */
public interface AreaMapper {
	// 根据city的id来查询所有的区、县
	List<Area> showAreaListBycid(Integer cid);

}