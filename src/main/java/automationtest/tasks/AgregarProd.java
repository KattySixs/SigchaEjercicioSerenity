package automationtest.tasks;

import automationtest.userinterfaces.ProductsPageObgect;
import automationtest.userinterfaces.SauceDemoPageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class AgregarProd implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ProductsPageObgect.BTN_ADDPROD1),
                Click.on(ProductsPageObgect.BTN_ADDPROD2),
                Click.on(ProductsPageObgect.BTN_CARRITO)
        );
    }
    public static AgregarProd ahora () {
        return Tasks.instrumented(AgregarProd.class);
    }



}
