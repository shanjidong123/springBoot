package com.yy.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女孩
     */
    @GetMapping(value = "/girls")
    public List<Girl> girls() {
        return girlRepository.findAll();
    }

    /**
     * 根据年龄来查询女孩
     */
    @GetMapping(value = "/girls/{age}")
    public List<Girl> girlFindone(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    /**
     * 新增一个女孩
     */
    @PostMapping(value = "/girls")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize, @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);

        return girlRepository.save(girl);
    }

    /**
     * 更新一个女孩的信息
     */
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        girl.setId(id);

        return girlRepository.save(girl);
    }

    /**
     * 删除一个女孩
     */
    @DeleteMapping(value = "/girls/{id}")
    public void deleteGirl(@PathVariable("id") Integer id) {
        girlRepository.deleteById(id);
    }

    /**
     * 同时添加两个女孩
     */
    @PostMapping(value = "/girls/two")
    public void girlTwo() {
        girlService.inserTwo();
    }

}
