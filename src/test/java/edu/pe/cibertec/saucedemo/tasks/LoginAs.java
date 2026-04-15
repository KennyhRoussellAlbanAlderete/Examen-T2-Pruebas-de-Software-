package edu.pe.cibertec.saucedemo.tasks;

import edu.pe.cibertec.saucedemo.ui.LoginPage;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.interactions.Click;
import net.serenitybdd.screenplay.playwright.interactions.Enter;

public class LoginAs {
    private final String username;

    public LoginAs(String username) {
        this.username = username;
    }

    public static LoginAs user(String username) {
        return new LoginAs(username);
    }

    public Performable withPassword(String password) {
        return Task.where("{0} logs in as '" + username + "'",
                Enter.theValue(username)
                        .into(Target.the("Username field")
                                .locatedBy(LoginPage.USERNAME_FIELD)),
                Enter.theValue(password)
                        .into(Target.the("Password field")
                                .locatedBy(LoginPage.PASSWORD_FIELD)),

                Click.on(Target.the("Login button")
                        .locatedBy(LoginPage.LOGIN_BUTTON))

        );
    }

}
