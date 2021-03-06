package com.torres.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 计算树的层级
 * Created by Torres
 * 2018-06-03 9:44
 */
public class LevelUtil {

    public final static String SEPARATOR=".";

    public final static String ROOT="0";

//    0
//    0.1
//    0.1.2
//    0.1.3
    public static String calculateLevel(String parentLevel,int parentId){
        if (StringUtils.isBlank(parentLevel)){
            return ROOT;
        }else {
            return StringUtils.join(parentLevel,SEPARATOR,parentId);
        }
    }
}
