package com.jd.helloworld.dao.example;

import com.jd.common.util.Query;
import com.jd.helloworld.domain.example.Example;

import java.util.List;

/**
 * User: Administrator
 * Date: 2010-4-15
 * Time: 18:17:34
 */
public interface ExampleDao {

    /**
     * 列出所有测
     * @return
     */
    public List<Example> findExamples() ;

    /**
     * 取得总记录数
     * @return 记录数量
     */
    int getExamplesCount();

    /**
     * 取得总记录数
     * @return 记录数量
     */
    int getExamplesCount(Query query);

    /**
     * 取得相关的记录数
     * @param query 查询参数
     * @return 相关记录
     */
    List<Example> findExamplesPage(Query query);

    /**
     * 创建对象
     * @param example
     */
    void createExample(Example example);
}
