package automationtest.tasks;

import automationtest.userinterfaces.SauceDemoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class AbrirSauceDemo implements Task {
    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
                Open.url(SauceDemoPage.URL)
        );
    }

    public static AbrirSauceDemo pagina(){
        return Tasks.instrumented(AbrirSauceDemo.class);
    }
}
