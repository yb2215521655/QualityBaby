package com.swust.question;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * QuestionApplication
 *
 * @author pang
 * @date 2019/3/16 21:20
 */
@SpringBootApplication
@EnableSwagger2
@EnableCaching
public class QuestionApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuestionApplication.class, args);
    }

}