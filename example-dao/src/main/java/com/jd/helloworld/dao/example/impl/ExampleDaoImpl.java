package com.jd.helloworld.dao.example.impl;

import com.jd.common.dao.BaseDao;
import com.jd.common.util.Query;
import com.jd.helloworld.dao.example.ExampleDao;
import com.jd.helloworld.domain.example.Example;

import java.util.List;

/**
 * User: Administrator
 * Date: 2010-4-15
 * Time: 18:23:46
 */
@SuppressWarnings("unchecked")
public class ExampleDaoImpl extends BaseDao implements ExampleDao {

    public List<Example> findExamples() {        
        return queryForList("Example.findExamples");
    }

    public void createExample(Example example) {
         insert("Example.createExample",example);
    }

    public int getExamplesCount() {
        return (Integer)queryForObject("Example.getExamplesCount");
    }

    public int getExamplesCount(Query query) {
        return (Integer)queryForObject("Example.getExamplesCount",query);
    }


    public List<Example> findExamplesPage(Query query) {
        return queryForList("Example.findExamplesPage",query);
    }
}
