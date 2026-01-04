package automationtest.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductsPageObgect extends PageObject {
    public static final Target BTN_ADDPROD1=Target.the("Btn Agregar Producto al carrito")
            .located(By.id("add-to-cart-sauce-labs-backpack"));
    public static final Target BTN_ADDPROD2=Target.the("Btn Agregar Producto al carrito")
            .located(By.id("add-to-cart-sauce-labs-bike-light"));
    public static final Target BTN_CARRITO=Target.the("Btn Carrito de compras")
            .located(By.id("shopping_cart_container"));

}
