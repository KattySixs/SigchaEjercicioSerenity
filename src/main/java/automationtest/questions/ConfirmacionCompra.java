package automationtest.questions;

import automationtest.userinterfaces.CheckoutPageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ConfirmacionCompra implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        String titulo = CheckoutPageObject.TXT_CONFIRMATION.resolveFor(actor).getText();
        return titulo != null && titulo.trim().equalsIgnoreCase("Thank you for your order!");

    }

    public static ConfirmacionCompra fueExitosa() {
        return new ConfirmacionCompra();
    }

}
