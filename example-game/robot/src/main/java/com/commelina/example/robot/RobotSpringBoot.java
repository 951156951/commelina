package com.commelina.example.robot;

import com.commelina.example.robot.events.GatewayLogin;
import com.commelina.example.robot.interfaces.MainGameEvent;
import com.commelina.example.robot.interfaces.MainHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

/**
 *
 * @author @panyao
 * @date 2017/9/8
 */
@SpringBootApplication
public class RobotSpringBoot {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(RobotSpringBoot.class);
        app.setWebEnvironment(false);
        app.run(args);
    }

    @PostConstruct
    public void init() {
        MainGameEvent event = new MainHandler();
        event.start(new GatewayLogin("", ""));
    }

}