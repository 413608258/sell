package com.lous.sell;

import javafx.scene.control.ChoiceDialog;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName : LoggerTest
 * @Description : TODO
 *
 * @author : Loushuai
 * @since : 2018-10-31
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {

    //private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void test(){

        String name = "test";
        String pw = "123465";

        log.debug("debug...");
        log.info("info...");
        log.error("errot...");
        log.info("name: {}, pw: {}", name, pw);
    }

}
