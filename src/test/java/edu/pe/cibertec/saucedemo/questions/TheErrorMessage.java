package edu.pe.cibertec.saucedemo.questions;

import edu.pe.cibertec.saucedemo.ui.LoginPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.questions.Text;

public class TheErrorMessage {
    public static Question<String> displayed() {
        return Text.of(Target.the("Error message")
                .locatedBy(LoginPage.ERROR_MESSAGE));
    }
}
