package automationtest.questions;

import automationtest.userinterfaces.CarPageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

public class VerificarProductosCarrito implements Question<Integer> {
@Override
    public  Integer answeredBy(Actor actor){
    return CarPageObject.LISTA_PROD.resolveAllFor(actor).size();
}
public static VerificarProductosCarrito es(){
    return new VerificarProductosCarrito();
}
}
