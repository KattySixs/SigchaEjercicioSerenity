package automationtest.questions;

import automationtest.tasks.AbrirSauceDemo;
import automationtest.userinterfaces.SauceDemoPageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class VerificarLoginCorrecto implements Question<Boolean> {
    public static VerificarLoginCorrecto esCorrecto(){
        return new VerificarLoginCorrecto();
    }

    @Override
    public Boolean answeredBy (Actor actor){
        String titulo = SauceDemoPageObject.TITULO_HOME.resolveFor(actor).getText();
        return titulo.contains("Products");

    }
}
