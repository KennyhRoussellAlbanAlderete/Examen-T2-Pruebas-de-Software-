package edu.pe.cibertec.saucedemo.stepdefinitions;


import com.microsoft.playwright.Page;
import edu.pe.cibertec.saucedemo.questions.TheErrorMessage;
import edu.pe.cibertec.saucedemo.questions.ThePageTitle;
import edu.pe.cibertec.saucedemo.tasks.LoginAs;
import edu.pe.cibertec.saucedemo.tasks.OpenTheLoginPage;
import edu.pe.cibertec.saucedemo.tasks.VerificarSesion;
import edu.pe.cibertec.saucedemo.ui.InventoryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.playwright.abilities.BrowseTheWebWithPlaywright;
import net.serenitybdd.screenplay.playwright.interactions.Click;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class LoginStepDefinitions {

    private long startTime;

    @Given("{word} is on the SauceDemo login page")
    public void openLoginPage(String actorName) {
        Actor actor = OnStage.theActorCalled(actorName);
        actor.whoCan(BrowseTheWebWithPlaywright.usingTheDefaultConfiguration());
        actor.attemptsTo(OpenTheLoginPage.page());
    }

    @When("she logs in with username {string} and password {string}")
    public void loginWith(String username, String password) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginAs.user(username).withPassword(password)
        );
    }

    @Then("she should be redirect to the inventory page")
    public void shouldBeRedirectedToInventoryPage() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ThePageTitle.displayed(), equalTo("Products"))
        );
    }


    @And("the page load time should be greater than 3000 milliseconds")
    public void verifyLoadTime()
    {
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        assert(duration > 3000);

    }


    @And("she navigates to the cart page")
    public void navigateToCart()
    {
        OnStage.theActorInTheSpotlight().attemptsTo(Click.on(InventoryPage.SHOPPING_CART));


    }


    @And("she navigates back to the inventory page")
    public void navigateBack()
    {
        Page page = BrowseTheWebWithPlaywright.as(OnStage.theActorInTheSpotlight()).getCurrentPage();
        page.goBack();
    }


    @Then("she should still be logged in")
    public void verifyStillLoggedIn()
    {
        Page page = BrowseTheWebWithPlaywright.as(OnStage.theActorInTheSpotlight()).getCurrentPage();

        OnStage.theActorInTheSpotlight().attemptsTo(VerificarSesion.activa());

        assertThat(page.locator(InventoryPage.MENU_BUTTON)).isVisible();

    }


    @Then("she should see the page title {string}")
    public void shouldSeeThePageTitle(String pageTitle) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ThePageTitle.displayed(), equalTo(pageTitle))
        );
    }

    @Then("she should see the error message {string}")
    public void shouldSeeTheErrorMessage(String errorMessage) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(TheErrorMessage.displayed(), equalTo(errorMessage))
        );
    }

    @Then("she should remain on the login page")
    public void shouldRemainOnTheLoginPage()
    {
        Page page = BrowseTheWebWithPlaywright.as(OnStage.theActorInTheSpotlight()).getCurrentPage();

        assertThat(page).hasURL(("https://www.saucedemo.com/"));

    }

}
