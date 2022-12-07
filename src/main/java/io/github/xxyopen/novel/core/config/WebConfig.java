package io.github.xxyopen.novel.core.config;

import com.google.protobuf.Api;
import io.github.xxyopen.novel.core.constant.ApiRouterConsts;
import io.github.xxyopen.novel.core.interceptor.AuthInterceptor;
import io.github.xxyopen.novel.core.interceptor.FlowLimitInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final AuthInterceptor authInterceptor;

    private final FlowLimitInterceptor flowLimitInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(flowLimitInterceptor)
                        .addPathPatterns("/**")
                                .order(0);

       registry.addInterceptor(authInterceptor)
               .addPathPatterns(ApiRouterConsts.API_FRONT_USER_URL_PREFIX + "/**",
                       ApiRouterConsts.API_AUTHOR_URL_PREFIX + "/**",
                       ApiRouterConsts.API_ADMIN_URL_PREFIX + "/**")
               .excludePathPatterns(ApiRouterConsts.API_FRONT_USER_URL_PREFIX + "/register",
                       ApiRouterConsts.API_FRONT_USER_URL_PREFIX + "/login",
                       ApiRouterConsts.API_ADMIN_URL_PREFIX + "/login")
               .order(0);
    }
}
