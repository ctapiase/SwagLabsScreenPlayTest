package com.choucair.app.tasks;

import com.choucair.app.userinterfaces.UiLogIn;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.logging.Logger;

public class LogInOn implements Task {
    String user;
    String password;

    public LogInOn(String user, String password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Logger.getAnonymousLogger().info("Se abre la app");
        actor.attemptsTo(
                Enter.theValue(user).into(UiLogIn.USERNAME_INPUT),
                Enter.theValue(password).into(UiLogIn.PASSWORD_INPUT),
                Click.on(UiLogIn.LOGIN_BUTTON)
        );
    }

    public static LogInOn eriBank(String user, String password) {
        return Tasks.instrumented(LogInOn.class, user, password);
    }
}
