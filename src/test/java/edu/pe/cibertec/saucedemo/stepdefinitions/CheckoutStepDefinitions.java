package edu.pe.cibertec.saucedemo.stepdefinitions;

import edu.pe.cibertec.saucedemo.tasks.CompletarCheckout;
import edu.pe.cibertec.saucedemo.ui.CarritoPage;
import edu.pe.cibertec.saucedemo.ui.CheckoutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.playwright.interactions.Click;
import net.serenitybdd.screenplay.playwright.questions.Text;
import net.serenitybdd.screenplay.playwright.questions.Visibility;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CheckoutStepDefinitions {

    @And("she proceeds to checkout with first name {string}, last name {string} and postal code {string}")
    public void sheProceedsToCheckoutWithInformation(String firstName,String lastName,String zip)
    {
        OnStage.theActorInTheSpotlight().attemptsTo(Click.on(".shopping_cart_link"),

        Click.on(CarritoPage.BTN_CHECKOUT),CompletarCheckout.conDatos(firstName,lastName,zip));
    }


    @And("she verifies the order summary shows item total {string}")
    public void sheVerifiesTheOrderSummaryShowsItemTotal(String expectedTotal)
    {
        OnStage.theActorInTheSpotlight().should(seeThat(Text.of(CheckoutPage.ITEM_TOTAL),containsString(expectedTotal)));

    }


    @And("she completes the order")
    public void sheCompletesTheOrder()
    {
        OnStage.theActorInTheSpotlight().attemptsTo(Click.on(CheckoutPage.BTN_FINISH));

    }


    @Then("she should see the confirmation message {string}")
    public void sheShouldSeeTheConfirmationMessage(String expectedMessage)
    {
        OnStage.theActorInTheSpotlight().should(seeThat(Text.of(CheckoutPage.CONFIRMATION_MESSAGE),equalTo(expectedMessage)));

    }


    @And("the checkout form should remain visible")
    public void theCheckoutFormShouldRemainVisible()
    {
        OnStage.theActorInTheSpotlight().should(seeThat("El campo nombre es visible",Visibility.of(CheckoutPage.FIRST_NAME),is(true)));

    }
}
