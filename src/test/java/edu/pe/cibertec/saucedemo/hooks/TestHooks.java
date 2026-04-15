package edu.pe.cibertec.saucedemo.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.steps.*;

import java.io.File;

public class TestHooks {

    @Before
    public void setTheStage(Scenario scenario) {
        try{
            StepEventBus.getParallelEventBus().getBaseStepListener();
        }
        catch(Exception e){
            StepEventBus.getParallelEventBus().registerListener(
                    new BaseStepListener(new File("target"))
            );
        }
        OnStage.setTheStage(new OnlineCast());
        System.out.println("Stating Scenarios +"+ scenario.getName());
    }
    @After
    public void tearDown(Scenario scenario) {
        System.out.println("Finished Scenarios +"+ scenario.getName() + " | Status: " + scenario.getStatus());
        OnStage.drawTheCurtain();
    }
}
