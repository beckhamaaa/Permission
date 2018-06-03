package com.torres.param;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 验证实体
 * Created by Torres
 * 2018-05-27 17:37
 */
@Getter
@Setter
public class TestVo {

    @NotBlank
//    判断字符串
    private String msg;

    @NotNull(message = "id不可以为空")
//    判断对象
    @Max(value = 10,message = "id 不能大于10")
    @Min(value = 0,message = "id 至少大于等于0")
    private Integer id;

//    @NotEmpty
//    判断数组、集合
    private List<String> str;
}
