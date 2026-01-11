package automationtest.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutPageObject extends PageObject {
    //Objects page your information
    public static final Target BTN_CHECKOUT= Target.the("Btn Checkout")
            .located(By.id("checkout"));
    public static final Target INPUT_FIRSTNAME= Target.the("Nombre")
            .located(By.id("first-name"));
    public static final Target INPUT_LASTNAME= Target.the("Apellido")
            .located(By.id("last-name"));
    public static final Target INPUT_POSTALCODE= Target.the("Codigo Postal")
            .located(By.id("postal-code"));
    public static final Target BTN_CONTINUE= Target.the("Btn Continue")
            .located(By.id("continue"));
    public static final Target BTN_FINISH= Target.the("Btn Finish")
            .located(By.id("finish"));
    // Se cambia a selector CSS por data-test para mayor estabilidad
    public static final Target TXT_CONFIRMATION= Target.the("Mensaje de confirmacion")
            .located(By.cssSelector("h2[data-test='complete-header']"));

}
