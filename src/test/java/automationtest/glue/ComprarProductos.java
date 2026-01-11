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
    @Given("que el usuario inicia sesión correctamente en SauceDemo con {string} y {string}")
    public void login (String usuario, String contrasena){
        theActorInTheSpotlight().wasAbleTo(
                AbrirSauceDemo.pagina(),
                EstablecerDatos.conCredenciales(usuario,contrasena));
        }
    @When("Agrega 2 productos al carrito")
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
    @And("Completar el formulario de compra con {string}, {string} y {string}")
    public void completarformulario(String nombre, String apellido, String cpostal){
        theActorInTheSpotlight().attemptsTo(ChekOut.conFormulario(nombre, apellido, cpostal));
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
