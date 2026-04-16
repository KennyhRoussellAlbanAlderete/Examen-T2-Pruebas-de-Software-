package edu.pe.cibertec.saucedemo.tasks;

import net.serenitybdd.screenplay.playwright.interactions.Click;
import edu.pe.cibertec.saucedemo.ui.CarritoPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class AgregarAlCarrito {

    public static Performable elProducto(String productName)
    {
        return Task.where("{0} agrega el producto " + productName,Click.on(CarritoPage.btnAddToCart(productName)));

    }
}
