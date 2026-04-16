package edu.pe.cibertec.saucedemo.tasks;

import edu.pe.cibertec.saucedemo.ui.CheckoutPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.interactions.Click;
import net.serenitybdd.screenplay.playwright.interactions.Enter;

public class CompletarCheckout {

    public static Performable conDatos(String firstName,String lastName,String zip)
    {
        return Task.where("{0} completa el checkout", Enter.theValue(firstName).into(CheckoutPage.FIRST_NAME),Enter.theValue(lastName).into(CheckoutPage.LAST_NAME),Enter.theValue(zip).into(CheckoutPage.POSTAL_CODE),
                Click.on(CheckoutPage.BTN_CONTINUE));

    }


}
