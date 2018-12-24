package com.example.feigin.service;

import com.example.feigin.model.Student;
import org.springframework.stereotype.Component;

/**
 * @author aegis
 * @date 2018-12-18 15:15
 */
@Component
public class FallBackService implements HelloService {

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry" + name;
    }

    @Override
    public String student(String name, Student student) {
        return null;
    }
}
