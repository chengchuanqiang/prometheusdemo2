package com.demo.prometheusdemo2.common;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.Metrics;

import java.util.concurrent.atomic.AtomicInteger;

/********************************
 *** 自定义监控指标
 ***@Author chengchuanqiang
 ***@Date 2018/9/21 15:47
 ***@Version 1.0.0
 ********************************/
public class MyMetrics {
    /**
     * count 计数器，简单理解就是一个只增不减的计数器，它通常用于记录服务的请求数量，完成的任务数量，错误发生的数量
     */
    public static final Counter counterExample = Counter
            .builder("my_sample_counter")
            .tag("status", "success")
            .description("计数器")
            .register(Metrics.globalRegistry);

    /**
     * Gauge 仪表，是一个表示单个数值的度量，它可以表示任意地上下移动的数值测量，通常用于变动的测量值，如当前的内存使用情况，同时也可以测量上下移动的“计数”，队列中的消息数量
     */
    public static final AtomicInteger gaugeAtomicInteger = new AtomicInteger(0);
    // 借助AtomicInteger进行模拟仪表值的增加减少
    public static final Gauge gaugeExample = Gauge
            .builder("my_sample_gauge", gaugeAtomicInteger, AtomicInteger::get)
            .tag("id", "gaugeDemo")
            .description("仪表")
            .register(Metrics.globalRegistry);

}
