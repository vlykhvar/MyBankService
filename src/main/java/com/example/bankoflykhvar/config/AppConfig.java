package com.example.bankoflykhvar.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.example.bankoflykhvar.model",
        "com.example.bankoflykhvar.service",
        "com.example.bankoflykhvar.dao",
        "com.example.bankoflykhvar.initialize"
})
public class AppConfig {
}
