package automationtest.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CarPageObject {
    public static final Target LISTA_PROD=Target.the("Lista de productos")
            .located(By.className("cart_item"));
    public static final Target NOMBRE_PROD=Target.the("Nombre de productos")
            .located(By.className("inventory_item_name"));


}
