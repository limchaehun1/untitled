package untitled.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import untitled.StoreownerApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { StoreownerApplication.class })
public class CucumberSpingConfiguration {}
