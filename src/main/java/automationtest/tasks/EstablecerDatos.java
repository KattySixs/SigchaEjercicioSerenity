package automationtest.tasks;

import automationtest.userinterfaces.SauceDemoPageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.io.InputStream;
import java.util.Properties;

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

    public static EstablecerDatos conCredencialesDesdeArchivo() {
        try (InputStream input = EstablecerDatos.class.getClassLoader().getResourceAsStream("credentials.properties")) {
            Properties prop = new Properties();
            if (input == null) {
                throw new RuntimeException("No se encontró el archivo credentials.properties en el classpath");
            }
            prop.load(input);
            String user = prop.getProperty("username");
            String pass = prop.getProperty("password");
            if (user == null || pass == null) {
                throw new RuntimeException("Las propiedades 'username' o 'password' no están definidas en credentials.properties");
            }
            return conCredenciales(user, pass);
        } catch (Exception e) {
            throw new RuntimeException("Error leyendo credentials.properties: " + e.getMessage(), e);
        }
    }
}