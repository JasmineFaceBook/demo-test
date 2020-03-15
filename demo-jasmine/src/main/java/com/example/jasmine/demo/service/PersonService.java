package com.example.jasmine.demo.service;

import com.example.jasmine.demo.core.entity.ResponseEntity;
//import com.example.jasmine.demo.entity.PersonInfoEntity;

/**
 * Created by l on 2017/10/19.
 */
public interface PersonService {

    ResponseEntity selectByPrimaryKey(Long id);
}
