/*
 * $Id: HelloWorld.java 471756 2006-11-06 15:01:43Z husted $
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.jd.helloworld.web.action.example;

import com.jd.common.struts.action.BaseAction;
import com.jd.common.web.result.Result;
import com.jd.helloworld.domain.example.Example;
import com.jd.helloworld.service.example.ExampleService;


/**
 * <code>Set welcome message.</code>
 */
public class ExampleAction extends BaseAction {
    
    private ExampleService exampleService;
    private Example example;
    private int pageSize = 20;

    public String list() throws Exception {
        message = Integer.toString(hashCode());
        String name = null;
        if (example!=null) {
            name = example.getName();
        }
        Result examples = exampleService.findExamples(name, page, pageSize);
        toVm(examples);


        return SUCCESS;
    }

    public String add() throws Exception {
        setCookie("a1","abc");
        setCookie("a2","abc");
        return SUCCESS;
    }


    public String doAdd() throws Exception {
        Result result = exampleService.createExample(example);
        toVm(result);
        return SUCCESS;
    }

    /**
     * Field for Message property.
     */
    private String message;


    /**
     * Return Message property.
     *
     * @return Message property
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set Message property.
     *
     * @param message Text to display on HelloWorld page.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    public Example getExample() {
        return example;
    }

    public void setExample(Example example) {
        this.example = example;
    }

    public void setExampleService(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }
}
