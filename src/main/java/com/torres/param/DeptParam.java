package com.torres.param;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by Torres
 * 2018-06-03 9:34
 */
@Getter
@Setter
@ToString
public class DeptParam {

    private Integer id;

    @NotBlank(message="部门名称不可以为空")
    @Length(max=15,min=2,message = "部门名称需要在2-15字符之间")
    private String name;

    private Integer parentId=0;

    @NotNull(message = "展示顺序不可以为空")
    private Integer seq;

    @Length(max=150,message = "备注长度需要在150字符之间")
    private String remark;


}
