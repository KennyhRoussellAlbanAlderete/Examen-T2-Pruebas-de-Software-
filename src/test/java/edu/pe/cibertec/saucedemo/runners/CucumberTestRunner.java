package edu.pe.cibertec.saucedemo.runners;


import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME,
        value = "edu.pe.cibertec.saucedemo.stepdefinitions,edu.pe.cibertec.saucedemo.hooks")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME,
        value = "pretty, io.cucumber.core.plugin.SerenityReporterParallel")
public class CucumberTestRunner {
}
