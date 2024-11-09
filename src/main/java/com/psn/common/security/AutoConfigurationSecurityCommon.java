package com.psn.common.security;

import com.psn.common.security.service.AuthService;
import com.psn.common.security.service.JwtService;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)  // Annotation này sẽ được áp dụng cho class
@Retention(RetentionPolicy.RUNTIME)
@Import({SecurityConfiguration.class, JwtAuthenticationFilter.class, JwtService.class, AuthService.class})
public @interface AutoConfigurationSecurityCommon {

}
