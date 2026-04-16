package edu.pe.cibertec.saucedemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import edu.pe.cibertec.saucedemo.ui.InventoryPage;


import static net.serenitybdd.screenplay.Tasks.instrumented;

public class VerificarSesion implements Task {

    public static VerificarSesion activa()
    {
        return instrumented(VerificarSesion.class);

    }

    @Override
    public <T extends Actor> void performAs(T actor)
    {
        actor.attemptsTo();

    }

}
