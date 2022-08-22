package com.ml.app.config;

import com.ml.coreweb.interceptors.ActivityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * BookWormV2
 * Created on 19/8/22 - Friday
 * User Khan, C M Abdullah
 * Ref:
 */
@Configuration
public class AppConfig implements WebMvcConfigurer {
	
	private final ActivityInterceptor activityInterceptor;
	
	@Autowired
	public AppConfig(ActivityInterceptor activityInterceptor) {
		
		this.activityInterceptor = activityInterceptor;
		
	}
	
	@Bean
	public RequestContextListener requestContextListener() {
		return new RequestContextListener();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(activityInterceptor);
	}
	
}
