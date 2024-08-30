package com.example.springmvcdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

/**
 * 国际化配置
 */
@Configuration
public class LocalConfig {

    /**
     * 设置解析器
     * @return
     */
//    @Bean
//    public LocaleResolver localResolver(){
//        SessionLocaleResolver resolver = new SessionLocaleResolver();
//        resolver.setDefaultLocale(Locale.CHINA);
//        return resolver;
//    }
//
//    /**
//     * 默认拦截器，其中lang表示切换语言的参数
//     * @return
//     */
//    public WebMvcConfigurer localeInterceptor(){
//        return new WebMvcConfigurer() {
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
//                interceptor.setParamName("lang");
//                registry.addInterceptor(interceptor);
//            }
//        };
//    }
}
