package com.jd.helloworld.service.example;

import com.jd.common.web.result.Result;
import com.jd.helloworld.domain.example.Example;
 

/**
 * User: yangsiyong@360buy.com
 * Date: 2010-4-16
 * Time: 11:37:51
 */
public interface ExampleService {

      /**
     * 列出所有测
     * @return
     */
    Result findExamples() ;

    /**
     * 通过分页查找
     * @param name
     * @param pageIndex
     * @param pageSize
     * @return
     */
    Result findExamples(String name, int pageIndex, int pageSize) ;


       /**
     * 创建对象
     * @param example
     */
    Result createExample(Example example);
}
