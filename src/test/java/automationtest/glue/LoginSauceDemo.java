package automationtest.glue;


import automationtest.questions.VerificarLoginCorrecto;
import automationtest.tasks.AbrirSauceDemo;
import automationtest.tasks.EstablecerDatos;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LoginSauceDemo {
    @Before
    @SuppressWarnings("unchecked")
    public void setUp(){
        OnStage.setTheStage(new Cast()); //prepara el escenario y lo inicia
        OnStage.theActorCalled("Usuario").can(BrowseTheWeb.with(Serenity.getDriver())); //Crea el actor y le asigna habilidades
    }
    @Given("que el usuario abre el portal de login SauceDemo")
    public void AccederSauceDemo() {
        theActorInTheSpotlight().wasAbleTo(
                AbrirSauceDemo.pagina()
        );
    }
    @When("ingresa usuario {string} y contraseña {string}")
    public void ingresarCredenciales(String usuario, String contrasena){
        OnStage.theActorInTheSpotlight().attemptsTo(EstablecerDatos.conCredenciales(usuario, contrasena)
        );
    }
    @Then("Visualiza la página de productos")
    public void ValidarAcceso(){
        OnStage.theActorInTheSpotlight().asksFor(VerificarLoginCorrecto.esCorrecto());
    }
}
