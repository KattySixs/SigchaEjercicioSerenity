package automationtest.tasks;

import automationtest.userinterfaces.SauceDemoPageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class EstablecerDatos implements Task {

    private final String usuario;
    private final String contrasena;

    public EstablecerDatos(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }
    public static Performable conCredenciales(String usuario, String contrasena) {
        return Tasks.instrumented(EstablecerDatos.class, usuario, contrasena);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(usuario).into(SauceDemoPageObject.USUARIO_INPUT),
                Enter.theValue(contrasena).into(SauceDemoPageObject.CLAVE_INPUT),
                Click.on(SauceDemoPageObject.BTN_LOGIN)
        );
    }
}