package com.xiaobawang.mtserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MTServerApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MTServerApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {    return application.sources(MTServerApplication.class);}

}



//@SpringBootApplication
//public class MTServerApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(MTServerApplication.class, args);
//    }
//
//}