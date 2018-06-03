package com.torres.controller;

import com.torres.common.JsonData;
import com.torres.dto.DeptLevelDto;
import com.torres.param.DeptParam;
import com.torres.service.SysDeptService;
import com.torres.service.SysTreeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * 部门接口
 * Created by Torres
 * 2018-06-03 9:39
 */
@Controller
@RequestMapping("/sys/dept")
@Slf4j
public class SysDeptController {

    @Resource
    private SysDeptService sysDeptService;

    @Resource
    private SysTreeService sysTreeService;

    @RequestMapping("/dept.page")
    public ModelAndView page(){
//        返回视图名
        return new ModelAndView("dept");
    }

//    curl http://localhost:8080/sys/dept/save.json\?name\=技术部\&seq\=1\&remark\=技术部
    @RequestMapping("/save.json")
    @ResponseBody
    public JsonData saveDept(DeptParam param) {
        sysDeptService.save(param);
        return JsonData.success();
    }

    @RequestMapping("/tree.json")
    @ResponseBody
    public JsonData tree(){
            List<DeptLevelDto> dtoList=sysTreeService.deptTree();
            return JsonData.success(dtoList);
    }

    @RequestMapping("/update.json")
    @ResponseBody
    public JsonData updateDept(DeptParam param) {
        sysDeptService.update(param);
        return JsonData.success();
    }
}
