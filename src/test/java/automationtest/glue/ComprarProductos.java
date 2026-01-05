package automationtest.glue;

import automationtest.questions.ConfirmacionCompra;
import automationtest.questions.VerificarProductosCarrito;
import automationtest.tasks.AbrirSauceDemo;
import automationtest.tasks.AgregarProd;
import automationtest.tasks.ChekOut;
import automationtest.tasks.EstablecerDatos;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;


public class ComprarProductos {
    @Given("que el usuario inicia sesion en saucedemo con {string} y contraseña {string}")
    public void login (String usuario, String password){
        theActorInTheSpotlight().wasAbleTo(
                AbrirSauceDemo.pagina(),
                EstablecerDatos.conCredenciales(usuario,password));
        }
    @When("Agrega 2 productos al carrtio")
    public void AgregarProd() {
        theActorInTheSpotlight().attemptsTo(AgregarProd.ahora()
        );
    }

    @And ("visualizar los productos en carrito de compras")
    public void verproductos(){
        theActorInTheSpotlight().should(
                seeThat(
                VerificarProductosCarrito.es(),
                equalTo(2)
                )
        );
    }
    @And("Completar el formulario de compra")
    public void completarformulario(){
        theActorInTheSpotlight().attemptsTo(ChekOut.comprar());
    }
    @Then("Visualizar la confirmacion de la compra")
    public void confirmarcompra(){
        theActorInTheSpotlight().should(
                seeThat(
                        ConfirmacionCompra.fueExitosa(),
                        equalTo(true)
                )
        );
    }

}
