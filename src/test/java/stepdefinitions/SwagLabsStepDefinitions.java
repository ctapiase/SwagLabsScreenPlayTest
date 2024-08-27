package stepdefinitions;

import com.choucair.app.questions.ConfirmMsg;
import com.choucair.app.questions.PriceDeleteCar;
import com.choucair.app.questions.ValidateProductPrice;
import com.choucair.app.questions.ValidateTotalPrice;
import com.choucair.app.tasks.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SwagLabsStepDefinitions {

    @Given("que {string} ha iniciado sesión con el usuario {string} y la contraseña {string}")
    public void queHaIniciadoSesiónConElUsuarioYLaContraseña(String actor, String user, String pass) {
        theActorCalled(actor).wasAbleTo(LogInOn.eriBank(user, pass));
    }

    @When("{string} quiere comprar un producto {string}")
    public void quiereComprarUnProducto(String string, String product) {
        theActorInTheSpotlight().attemptsTo(ChooseProduct.choose(product));
    }

    @When("realiza el pago del producto")
    public void realizaElPagoDelProducto() {
        theActorInTheSpotlight().attemptsTo(MakePayment.pay());

    }

    @Then("debería ver la confirmación del pedido con el mensaje {string}")
    public void deberíaVerLaConfirmaciónDelPedidoConElMensaje(String string) {
        theActorInTheSpotlight().should(seeThat(ConfirmMsg.msgPayment(string)));
    }

    @When("{string} Quiere agregar varios productos al carrito")
    public void quiereAgregarVariosProductosAlCarrito(String actor, DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(ChooseSomeProducts.choose(dataTable));
    }
    @When("Realiza el proceso de CheckIn")
    public void realizaElProcesoDeCheckIn() {
        OnStage.theActorInTheSpotlight().attemptsTo(MakePayment.pay());
    }

    @When("SOL ha agregado variios producto al carrito")
    public void solHaAgregadoVariiosProductoAlCarrito(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(ChooseSomeProducts.choose(dataTable));
    }
    @When("elimina el producto {string} del carrito")
    public void eliminaElProductoDelCarrito(String product) {
        OnStage.theActorInTheSpotlight().attemptsTo(DeleteProduct.delete(product));
    }
    @Then("el total del carrito se actualiza correctamente")
    public void elTotalDelCarritoSeActualizaCorrectamente() {
        theActorInTheSpotlight().should(seeThat(PriceDeleteCar.verifyPriceCheckout()));
    }

    @Given("que Sol ha añadido los siguientes productos al carrito:")
    public void queSolHaAñadidoLosSiguientesProductosAlCarrito(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(ChooseSomeProducts.choose(dataTable));

    }
    @When("el Sol procede al resumen de la compra")
    public void elSolProcedeAlResumenDeLaCompra() {
        OnStage.theActorInTheSpotlight().attemptsTo(MakePayment.pay());
    }
    @Then("los precios individuales se muestran correctamente:")
    public void losPreciosIndividualesSeMuestranCorrectamente(DataTable dataTable) {
        theActorInTheSpotlight().should(seeThat(ValidateProductPrice.validate(dataTable)));
    }
    @Then("el total de la compra se calcula y muestra correctamente como {float}")
    public void elTotalDeLaCompraSeCalculaYMuestraCorrectamenteComo(Float total) {
        theActorInTheSpotlight().should(seeThat(ValidateTotalPrice.validate(total)));
    }

}
