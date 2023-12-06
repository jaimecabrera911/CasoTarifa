package com.example.casotarifa;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = CasoTarifaApplicationTests.class)
public class CucumberSpringConfiguration {
}