package com.swust.question;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * QuestionApplication
 *
 * @author pang
 * @date 2019/3/16 21:20
 */
@MapperScan("com.swust.question.dao")
@SpringBootApplication
public class QuestionApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuestionApplication.class, args);
    }

}