package com.jd.helloworld.manager.example;

import com.jd.common.util.PaginatedList;
import com.jd.helloworld.domain.example.Example;
import com.jd.helloworld.manager.BaseTest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

/**
 * User: yangsiyong@360buy.com
 * Date: 2010-5-10
 * Time: 14:04:46
 */
public class ExampleManagerCachedTest extends BaseTest {
    private final static Log log = LogFactory.getLog(ExampleManagerCachedTest.class);
    private ExampleManager exampleManagerCached;

    @Test
    public void testList() {
        search();
        search();
    }

    private PaginatedList<Example> search() {
        return exampleManagerCached.findExamples("d", 1, 4);
    }

    public void setExampleManagerCached(ExampleManager exampleManagerCached) {
        this.exampleManagerCached = exampleManagerCached;
    }
}
