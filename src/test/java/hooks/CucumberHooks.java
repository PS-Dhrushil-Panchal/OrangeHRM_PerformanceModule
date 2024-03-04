package hooks;

import java.io.IOException;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.BaseClass;

public class CucumberHooks {

    @Before
    public void beforeScenario() throws IOException {
    	BaseClass.startDriver();
    }


    @After
    public void AfterScenario() throws IOException, InterruptedException{
    	Thread.sleep(2000);
    	BaseClass.stopDriver();
    }
}
