package com.example.jasmine.demo.mapper;

import com.example.jasmine.demo.entity.PersonInfoEntity;

public interface PersonInfoEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PersonInfoEntity record);

    int insertSelective(PersonInfoEntity record);

    PersonInfoEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PersonInfoEntity record);

    int updateByPrimaryKey(PersonInfoEntity record);
}