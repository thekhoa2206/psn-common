package com.psn.common.security;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)  // Annotation này sẽ được áp dụng cho class
@Retention(RetentionPolicy.RUNTIME)
@Import({SecurityConfiguration.class, JwtAuthenticationFilter.class})
@ComponentScan(basePackages = {"com.psn.common.security"})
public @interface AutoConfigurationSecurityCommon {

}
