package com.qf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.util.pattern.PathPatternParser;
import reactor.core.publisher.Mono;

/**
 * <p>title: com.qf</p>
 * <p>Company: wendao</p>
 * author zhuximing
 * date 2021/8/23
 * description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GWApp {


    public static void main(String[] args) {
        SpringApplication.run(GWApp.class, args);
    }


    @Bean
    @Order(-1)
    public GlobalFilter a() {
        return (exchange, chain) -> {
            System.out.println("first pre filter");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                System.out.println("first post filter");
            }));
        };
    }

    @Bean
    @Order(0)
    public GlobalFilter b() {
        return (exchange, chain) -> {
            System.out.println("second pre filter");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                System.out.println("second post filter");
            }));
        };
    }

    @Bean
    @Order(1)
    public GlobalFilter c() {
        return (exchange, chain) -> {
            System.out.println("third pre filter");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                System.out.println("third post filter");
            }));
        };
    }

    @Bean
    public CorsWebFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedMethod("*");
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());
        source.registerCorsConfiguration("/**", config);

        return new CorsWebFilter(source);
    }


}