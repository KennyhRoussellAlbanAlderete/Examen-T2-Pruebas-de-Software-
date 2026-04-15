package edu.pe.cibertec.saucedemo.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.interactions.Open;

public class OpenTheLoginPage {

    private static final String SAUCEDEMO_URL = "https://www.saucedemo.com";

    public static Performable page() {
        return Task.where("{0} opens the Saucedemo login page", Open.url(SAUCEDEMO_URL));
    }


}
