package com.springiscoming.config;

import com.springiscoming.web.DefaultController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(DefaultController.class);
    }
}
