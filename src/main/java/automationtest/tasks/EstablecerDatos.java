package automationtest.tasks;

import automationtest.userinterfaces.SauceDemoPage;
import automationtest.userinterfaces.SauceDemoPageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;

public class EstablecerDatos implements Task {

    private final String usuario;
    private final String password;

    public EstablecerDatos(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(usuario).into(SauceDemoPageObject.USUARIO_INPUT),
                Enter.theValue(password).into(SauceDemoPageObject.CLAVE_INPUT),
                Click.on(SauceDemoPageObject.BTN_LOGIN)
        );
    }

    public static EstablecerDatos conCredenciales(String usuario, String password) {
        return Tasks.instrumented(EstablecerDatos.class, usuario, password);
    }
}