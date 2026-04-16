package edu.pe.cibertec.saucedemo.ui;

public class CarritoPage {

    public static final String BTN_CHECKOUT="[data-test='checkout']";
    public static final String CART_BADGE="[data-test='shopping-cart-badge']";
    public static final String CART_LINK ="[data-test='shopping-cart-link']";
    public static final String ITEM_NAME="[data-test='inventory-item-name']";

    public static String btnAddToCart(String productName)
    {
        return "button[id='add-to-cart-" + productName.toLowerCase().replace(" ","-") + "']";

    }


    public static String btnRemoveFromCart(String productName)
    {
        return "button[id='remove-" + productName.toLowerCase().replace(" ","-") + "']";

    }
}
