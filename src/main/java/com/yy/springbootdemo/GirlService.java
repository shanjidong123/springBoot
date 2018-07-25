package com.yy.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void inserTwo(){
        Girl girl1 = new Girl();
        girl1.setAge(18);
        girl1.setCupSize("A");
        girlRepository.save(girl1);

        Girl girl2 = new Girl();
        girl2.setAge(19);
        girl2.setCupSize("EEEEEEEEEEEEEEEEEEEEEEEEE");
        girlRepository.save(girl2);
    }
}
