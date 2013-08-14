package com.jd.helloworld.manager.example;

import com.jd.helloworld.manager.BaseTest;
import junit.framework.Assert;
import net.spy.memcached.AddrUtil;
import net.spy.memcached.MemcachedClient;
import org.apache.commons.lang.time.StopWatch;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * User: yangsiyong@360buy.com
 * Date: 2010-5-10
 * Time: 14:26:27
 */
public class MemcachedClientTest extends BaseTest {
    private final static Log log = LogFactory.getLog(MemcachedClientTest.class);
    private MemcachedClient memcachedClient;
    private int thread = 2;
    private int repeat = 2;


    @Test
    public void testMemcachedClient() throws Exception {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        final CountDownLatch countDownLatch = new CountDownLatch(thread);
        final CountDownLatch startLatch = new CountDownLatch(thread+1);
        memcachedClient = new MemcachedClient(AddrUtil.getAddresses("10.10.66.102:11211"));
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(50, 500, 15, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(200));
        for (int i = 0; i < thread; i++) {
            final int h = i;
            poolExecutor.execute(new Runnable() {
                public void run() {
                    try {
                        startLatch.await();
                    } catch (InterruptedException e) {
                        log.error("await error!",e); 
                    }
                    for (int j = 0; j < repeat; j++) {
                        String value = "test_value_" + h + "_" + j;
                        String key = "test_key_" + h + "_" + j;
                        memcachedClient.add(key, 60 * 60, value);
                        Object o = memcachedClient.get(key);
                        Assert.assertEquals(value, o);
                    }
                    countDownLatch.countDown();
                }
            });
            startLatch.countDown();
        }
        log.info("begin...");
        startLatch.countDown();
        countDownLatch.await();
        stopWatch.stop();
        log.info("end...");
        int all = 2 * thread * repeat;
        long time = stopWatch.getTime();
        int speed = all * 1000 / (int) time;
        log.info("thread=" + thread + "; repeat=" + repeat + "; count=" + all + "; time=" + time + "ms; velocity=" + speed + "per second!");
    }
}
