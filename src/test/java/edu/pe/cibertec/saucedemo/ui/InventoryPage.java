package edu.pe.cibertec.saucedemo.ui;

public class InventoryPage {

    public static final String PAGE_TITLE = "[data-test='title']";
    public static final String ORDER_PRODUCT_SELECT = "[data-test='product-sort-container']";
    public static final String FIRST_ITEM_PRICE = "[data-test='inventory-item']:first-child [data-test='inventory-item-price']";
    public static final String LAST_ITEM_PRICE = "[data-test='inventory-item']:last-child [data-test='inventory-item-price']";

    public static final String SHOPPING_CART = "[data-test='shopping-cart-link']";
    public static final String MENU_BUTTON = "#react-burger-menu-btn";


    public static  String itemNameLink (String productName){
        return  "text=" + productName;
    }

}
