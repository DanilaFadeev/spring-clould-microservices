package org.javastart.deposit.controller;

import org.javastart.deposit.DepositServiceApplication;
import org.javastart.deposit.config.SpringH2DatabaseConfig;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {DepositServiceApplication.class, SpringH2DatabaseConfig.class})
public class DepositControllerTest {
}
