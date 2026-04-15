package edu.pe.cibertec.saucedemo.questions;

import edu.pe.cibertec.saucedemo.ui.InventoryPage;
import edu.pe.cibertec.saucedemo.ui.LoginPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.questions.Text;

public class ThePageTitle {
    public static Question<String> displayed() {
        return Text.of(Target.the("Page title")
                .locatedBy(InventoryPage.PAGE_TITLE));
    }
}
