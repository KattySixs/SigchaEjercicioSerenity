package automationtest.tasks;

import automationtest.userinterfaces.CheckoutPageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class ChekOut implements Task {

    private final String nombre;
    private final String apellido;
    private final String cpostal;

    public ChekOut(String nombre, String apellido, String cpostal) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cpostal = cpostal;
    }
    public static Performable conFormulario(String nombre, String apellido, String cpostal) {
        return Tasks.instrumented(ChekOut.class, nombre, apellido, cpostal);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Implementation of the checkout task
        actor.attemptsTo(
                Click.on(CheckoutPageObject.BTN_CHECKOUT),
                Enter.theValue(nombre).into(CheckoutPageObject.INPUT_FIRSTNAME),
                Enter.theValue(apellido).into(CheckoutPageObject.INPUT_LASTNAME),
                Enter.theValue(cpostal).into(CheckoutPageObject.INPUT_POSTALCODE),
                Click.on(CheckoutPageObject.BTN_CONTINUE),
                Click.on(CheckoutPageObject.BTN_FINISH)
        );
    }

    public static ChekOut comprar() {
        return Tasks.instrumented(ChekOut.class);
    }
}
