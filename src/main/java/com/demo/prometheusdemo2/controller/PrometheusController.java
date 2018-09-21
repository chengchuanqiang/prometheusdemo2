package com.demo.prometheusdemo2.controller;

import com.demo.prometheusdemo2.common.MyMetrics;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/********************************
 *** 自定义监控指标
 ***@Author chengchuanqiang
 ***@Date 2018/9/21 15:48
 ***@Version 1.0.0
 ********************************/
@RestController
@RequestMapping("prometheus")
public class PrometheusController {

    /**
     * 计数器指标监控
     * @return OK
     */
    @RequestMapping("/counter")
    public String counterExample() {
        // 增加
        MyMetrics.counterExample.increment();
        System.out.println(MyMetrics.counterExample.count());
        System.out.println(MyMetrics.counterExample.measure());
        return "OK";
    }

    /**
     * 仪表指标监控
     * @return OK
     */
    @RequestMapping("/gauge")
    public String gaugeExample() {
        // 减少
        MyMetrics.gaugeAtomicInteger.decrementAndGet();
        System.out.println(MyMetrics.gaugeExample.measure());
        System.out.println(MyMetrics.gaugeExample.value());
        return "OK";
    }

}
