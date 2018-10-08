package com.demo.prometheusdemo2;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Prometheusdemo2Application {

    @Value("${project.name}")
    private String projectName;

    /**
     * 设置全局tags变量
     *
     * @return
     */
    @Bean
    MeterRegistryCustomizer<MeterRegistry> metricsCommonTags() {
        return registry -> registry.config().commonTags("application", projectName);
    }

    public static void main(String[] args) {
        SpringApplication.run(Prometheusdemo2Application.class, args);
    }
}
