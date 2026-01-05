package automationtest.tasks;

import automationtest.userinterfaces.CheckoutPageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class ChekOut implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        // Implementation of the checkout task
        actor.attemptsTo(
                Click.on(CheckoutPageObject.BTN_CHECKOUT),
                Enter.theValue("Nancy").into(CheckoutPageObject.INPUT_FIRSTNAME),
                Enter.theValue("Sigcha").into(CheckoutPageObject.INPUT_LASTNAME),
                Enter.theValue("12345").into(CheckoutPageObject.INPUT_POSTALCODE),
                Click.on(CheckoutPageObject.BTN_CONTINUE),
                Click.on(CheckoutPageObject.BTN_FINISH)

        );
    }

    public static ChekOut comprar() {
        return Tasks.instrumented(ChekOut.class);
    }
}
