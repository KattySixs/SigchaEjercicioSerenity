package automationtest.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SauceDemoPageObject extends PageObject {
    public static final Target USUARIO_INPUT=Target.the("Campo ingreso usuario")
            .located(By.id("user-name"));
    public static final Target CLAVE_INPUT=Target.the("Campo ingreso clave")
            .located(By.id("password"));
    public static final Target BTN_LOGIN=Target.the("Botón para el login")
            .located(By.id("login-button"));
    public static final Target TITULO_HOME=Target.the("Título del home productos")
            .locatedBy(".title");
}
