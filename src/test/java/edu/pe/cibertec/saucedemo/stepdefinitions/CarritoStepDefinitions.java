package edu.pe.cibertec.saucedemo.stepdefinitions;

import edu.pe.cibertec.saucedemo.tasks.AgregarAlCarrito;
import edu.pe.cibertec.saucedemo.tasks.EliminarDelCarrito;
import edu.pe.cibertec.saucedemo.ui.CarritoPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import static org.hamcrest.Matchers.*;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.playwright.questions.Text;
import net.serenitybdd.screenplay.playwright.interactions.Click;

import static org.hamcrest.Matchers.hasItems;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class CarritoStepDefinitions {

    @And("she adds the product {string} to the cart")
    public void sheAddsTheProductToTheCart(String productName)
    {
        OnStage.theActorInTheSpotlight().attemptsTo(AgregarAlCarrito.elProducto(productName));

    }


    @And("she removes the product {string} from the cart")
    public void sheRemovesTheProductFromTheCart(String productName)
    {
        OnStage.theActorInTheSpotlight().attemptsTo(EliminarDelCarrito.elProducto(productName));

    }


    @Then("the cart icon should display {string}")
    public void theCartIconShouldDisplay(String expectedCount)
    {
        OnStage.theActorInTheSpotlight().should(seeThat(Text.of(CarritoPage.CART_BADGE),equalTo(expectedCount)));

    }


    @And("the cart should contain {string} and {string}")
    public void theCartShouldContainAnd(String item1, String item2)
    {
        OnStage.theActorInTheSpotlight().attemptsTo(Click.on(CarritoPage.CART_LINK));

        List<String> listaProductos = Text.ofEach(CarritoPage.ITEM_NAME).answeredBy(OnStage.theActorInTheSpotlight());

        org.hamcrest.MatcherAssert.assertThat("Productos encontrados: " + listaProductos, listaProductos, org.hamcrest.Matchers.hasItems(item1, item2));

    }


    @And("the cart should only contain {string}")
    public void theCartShouldOnlyContain(String itemName) {

        OnStage.theActorInTheSpotlight().attemptsTo(Click.on(CarritoPage.CART_LINK));

        List<String> listaProductos = Text.ofEach(CarritoPage.ITEM_NAME).answeredBy(OnStage.theActorInTheSpotlight());

        org.hamcrest.MatcherAssert.assertThat("El carrito debería tener exactamente 1 producto", listaProductos.size(), org.hamcrest.Matchers.is(1));

        org.hamcrest.MatcherAssert.assertThat("El producto en el carrito no es el esperado", listaProductos, org.hamcrest.Matchers.contains(itemName));
    }

}
