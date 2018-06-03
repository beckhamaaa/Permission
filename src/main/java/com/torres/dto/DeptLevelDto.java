package com.torres.dto;

import com.google.common.collect.Lists;
import com.torres.model.SysDept;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * 数据传输对象
 * Created by Torres
 * 2018-06-03 10:01
 */
@Getter
@Setter
@ToString
//tostring方法
public class DeptLevelDto extends SysDept {

    private List<DeptLevelDto> deptList= Lists.newArrayList();

    public static DeptLevelDto adapt(SysDept dept){
        DeptLevelDto dto=new DeptLevelDto();
//        复制属性,将dept中的复制到dto
        BeanUtils.copyProperties(dept,dto);
        return dto;
    }
}
