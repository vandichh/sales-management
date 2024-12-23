package com.example.common.config;

import org.springframework.context.annotation.PropertySource;
import org.springframework.util.ResourceUtils;

@PropertySource(ResourceUtils.CLASSPATH_URL_PREFIX + "application-shared.properties")
public class SharedAutoConfiguration {
}
