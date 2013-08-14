package com.jd.helloworld.manager.example.impl;

import com.jd.common.manager.BaseManager;
import com.jd.common.util.PaginatedList;
import com.jd.common.util.Query;
import com.jd.common.util.base.BaseQuery;
import com.jd.common.util.base.PaginatedArrayList;
import com.jd.helloworld.dao.example.ExampleDao;
import com.jd.helloworld.domain.example.Example;
import com.jd.helloworld.manager.example.ExampleManager;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.JVMRandom;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * User: Administrator
 * Date: 2010-4-19
 * Time: 14:03:37
 */
public class ExampleManagerImpl extends BaseManager implements ExampleManager {
     private final static Log log = LogFactory.getLog(ExampleManagerImpl.class);
    private ExampleDao exampleDao;

    public List<Example> findExamples() {
        return exampleDao.findExamples();
    }


    public int getExamplesCount() {
        return exampleDao.getExamplesCount();
    }

    public List<Example> findExamplesPage(Query query) {
        return exampleDao.findExamplesPage(query);
    }

    public PaginatedList<Example> findExamples(String name,int pageIndex, int pageSize) {
        BaseQuery baseQuery = new BaseQuery();
        if(StringUtils.isNotBlank(name)) { //设置查询参数
            baseQuery.setValue("%"+name+"%"); //一般情况下不让使用like
        }

        int totalItem = exampleDao.getExamplesCount(baseQuery); //得到总的记录数量

        PaginatedList<Example> examples = new PaginatedArrayList<Example>(pageIndex, pageSize); //构造返回对象，主要是用在页面上显示
        examples.setTotalItem(totalItem);//设置总记录数

        baseQuery.setStartRow(examples.getStartRow());//设置数据库的起始位置
        baseQuery.setEndRow(examples.getEndRow());//设置数据库的结束位置

        List<Example> exampleList = exampleDao.findExamplesPage(baseQuery);//查询得到相应的记录

        examples.addAll(exampleList);
        return examples;
    }

    public int createExample(final Example example) {
        example.setId((int) sequenceUtil.get("pop_user_example_id"));
        TransactionTemplate template = getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try {
                    exampleDao.createExample(example);
                    int rnd = new JVMRandom().nextInt(2);
                    if (rnd == 1) {
                        throw new Exception("随机出错！");
                    }
                } catch (Exception e) {
                    log.error("createExample error!",e);
                     status.setRollbackOnly();
                    throw new RuntimeException("gaga",e);
                }
            }
        });

        return example.getId();
    }

    public void setExampleDao(ExampleDao exampleDao) {
        this.exampleDao = exampleDao;
    }
}
