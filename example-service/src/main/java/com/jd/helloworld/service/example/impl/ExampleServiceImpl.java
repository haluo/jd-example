package com.jd.helloworld.service.example.impl;

import com.jd.common.web.result.Result;
import com.jd.helloworld.domain.example.Example;
import com.jd.helloworld.manager.example.ExampleManager;
import com.jd.helloworld.service.example.ExampleService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * User: yangsiyong@360buy.com
 * Date: 2010-4-16
 * Time: 11:38:09
 */
public class ExampleServiceImpl implements ExampleService {

    private final static Log log = LogFactory.getLog(ExampleServiceImpl.class);

    public Result findExamples() {
        Result result = new Result();
        try {
            result.addDefaultModel("examples", exampleManager.findExamples());
            result.setSuccess(true);

        } catch (Exception e) {
            log.error("findExamples error!", e);
        }
        return result;
    }


    public Result findExamples(String name, int pageIndex, int pageSize) {
        Result result = new Result();
        try {
            result.addDefaultModel("examples", exampleManager.findExamples(name, pageIndex, pageSize));
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("example.name", name);
            result.addDefaultModel("query", map);
            result.setSuccess(true);
            result.setResultCode("add.success", "Ê¾Àý");
        } catch (Exception e) {
            log.error("findExamples error!", e);
        }
        return result;
    }

    public Result createExample(Example example) {

        Result result = new Result();
        try {
            int exampleId = exampleManager.createExample(example);
            result.addDefaultModel("exampleId", exampleId);
            result.addDefaultModel("example", example);
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("createExample error!", e);
            result.setResultCode("system.error");
        }
        return result;
    }

    private ExampleManager exampleManager;

    public void setExampleManager(ExampleManager exampleManager) {
        this.exampleManager = exampleManager;
    }
}
