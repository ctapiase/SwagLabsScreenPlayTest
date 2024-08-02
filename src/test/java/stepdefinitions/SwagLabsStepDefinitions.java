package stepdefinitions;

import com.choucair.app.questions.ConfirmMsg;
import com.choucair.app.tasks.ChooseSomeProducts;
import com.choucair.app.tasks.LogInOn;
import com.choucair.app.tasks.ChooseProduct;
import com.choucair.app.tasks.MakePayment;
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


}
