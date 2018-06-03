package com.torres.controller;

import com.torres.common.ApplicationContextHelper;
import com.torres.common.JsonData;
import com.torres.dao.SysAclModuleMapper;
import com.torres.model.SysAclModule;
import com.torres.param.TestVo;
import com.torres.util.BeanValidator;
import com.torres.util.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Torres
 * 2018-05-27 11:56
 */
@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {

    @RequestMapping("/hello.json")
    @ResponseBody
    public JsonData test(){
        log.info("hello");
//        throw new RuntimeException("test exception");
        return JsonData.success("hello,permission");
    }

    @RequestMapping("/validate.json")
    @ResponseBody
    public JsonData validate(TestVo vo){
        log.info("validate");
        SysAclModuleMapper moduleMapper= ApplicationContextHelper.popBean(SysAclModuleMapper.class);
        SysAclModule module=moduleMapper.selectByPrimaryKey(1);
        log.info(JsonMapper.obj2String(module));

        BeanValidator.check(vo);
        return JsonData.success("test validate");
    }
}
