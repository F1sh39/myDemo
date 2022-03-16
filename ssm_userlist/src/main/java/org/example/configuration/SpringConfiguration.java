package org.example.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("org.example")
@Import({DataSourceConfiguration.class, TemplateConfiguration.class})
public class SpringConfiguration {
}
