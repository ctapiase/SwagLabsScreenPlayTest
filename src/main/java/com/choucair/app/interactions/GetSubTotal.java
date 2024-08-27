package com.choucair.app.interactions;

import com.choucair.app.userinterfaces.UiCheckout;
import com.choucair.moviles.libreria.interactions.choucair.builders.Scroll;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetSubTotal implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Obtener el texto del Target
        actor.attemptsTo(
                Scroll.on(UiCheckout.SUBTOTAL)
        );
        String subtotalText = Text.of(UiCheckout.SUBTOTAL).answeredBy(actor).replaceAll("[a-zA-Z\\\\$]", "");;

        System.out.println("Subtotal text: " + subtotalText);

        // Extraer solo el precio usando una expresión regular
        Pattern pattern = Pattern.compile("Subtotal: \\$(\\d+\\.\\d{2})");
        Matcher matcher = pattern.matcher(subtotalText);

        if (matcher.find()) {
            String price = matcher.group(1);
            System.out.println("El precio es: " + price);
        } else {
            System.out.println("No se pudo encontrar el precio en el texto: " + subtotalText);
        }

    }

    public static GetSubTotal checkSubtotal() {
        return new GetSubTotal();
    }
}
