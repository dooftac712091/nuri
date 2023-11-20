package ksmart.ks48team01.config;

import ksmart.ks48team01.interceptor.CommonInterceptor;
import ksmart.ks48team01.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final CommonInterceptor commonInterceptor;

    private final LoginInterceptor loginInterceptor;

    public WebConfig (CommonInterceptor commonInterceptor, LoginInterceptor loginInterceptor) {
        this.commonInterceptor = commonInterceptor;
        this.loginInterceptor = loginInterceptor;
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//
//        registry.addInterceptor(commonInterceptor)
//                .addPathPatterns("/**")
//                .excludePathPatterns("/css/**")
//                .excludePathPatterns("/js/**")
//                .excludePathPatterns("/favicon.ico");
//
//
//        registry.addInterceptor(loginInterceptor)
//                .addPathPatterns("/**")
//                .excludePathPatterns("/")
//                .excludePathPatterns("/css/**")
//                .excludePathPatterns("/js/**")
//                .excludePathPatterns("/favicon.ico");
//
//        WebMvcConfigurer.super.addInterceptors(registry);
//    }

}
