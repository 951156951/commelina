package com.module.foundation.game.gateway;

import com.nexus.maven.netty.starter.NettyNioSocketServerForSpringBoot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by @panyao on 2017/8/10.
 */
@SpringBootApplication
@ImportResource(locations={"classpath:spring-gateway-context.xml"})
public class GatewaySpringBoot {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(GatewaySpringBoot.class);
        app.setWebEnvironment(false);
        app.run(args);
    }

    @Bean
    public NettyNioSocketServerForSpringBoot createServer() {
        return new NettyNioSocketServerForSpringBoot();
    }

}
