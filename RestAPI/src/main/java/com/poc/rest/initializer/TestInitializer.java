package com.poc.rest.initializer;

import com.poc.utils.EnvConfig;
import com.poc.utils.ExtentReporterNG;
import org.testng.annotations.Listeners;

@Listeners({ExtentReporterNG.class})
public class TestInitializer{

    public TestInitializer(){
        EnvConfig envConfig = new EnvConfig();
    }

}
