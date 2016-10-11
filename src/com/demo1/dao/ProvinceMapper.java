package com.demo1.dao;

import com.demo1.entity.Province;

import java.util.List;

/**
 * 省接口
 */
public interface ProvinceMapper {

    // 查询出所有的省id
    List<Province> showProvinceList();
}