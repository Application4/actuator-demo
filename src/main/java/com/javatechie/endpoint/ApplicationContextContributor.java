package com.javatechie.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class ApplicationContextContributor implements InfoContributor {

    @Autowired
    private ApplicationContext context;

    @Override
    public void contribute(Info.Builder builder) {
        Map<String, Object> details = new HashMap<>();
        details.put("bean-definition-count", context.getBeanDefinitionCount());
        details.put("bean-names", context.getBeanDefinitionNames());
        details.put("context-startup", convertTime(context.getStartupDate()));
        builder.withDetail("context", details);
    }

    private String convertTime(long time) {
        Date date = new Date(time);
        Format format = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
        return format.format(date);
    }
}
