package coffee_machine.steps;

import coffee_machine.entities.*;
import coffee_machine.entities.enums.CoffeeMachineStatus;
import coffee_machine.entities.enums.CoffeeSize;
import coffee_machine.entities.enums.CoffeeType;
import coffee_machine.entities.enums.ResourceType;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

//  Для создания класса Steps необходимо наследовать класс ScenarioSteps
public class CoffeeMachineSteps extends ScenarioSteps {

    private CoffeeMachine coffeeMachine = new CoffeeMachine();
    private CoffeeCup coffeeCup = new CoffeeCup();

    @Step
    public void machineHasResource(ResourceType resource) {
        if (!coffeeMachine.hasSufficientResourceLevel(resource)) {
            coffeeMachine.increaseResourceLevel(resource, 50);
        }
    }

    @Step
    public void setupMachine(CoffeeMachineStatus status) {
        Assert.assertEquals("Coffee Machine Status is - " + status, status, coffeeMachine.getStatus());
    }

    @Step
    public void setDeposite(Integer amount) {
        coffeeMachine.increaseDeposite(amount);
    }

    @Step
    public void chooseCoffeeType(CoffeeType type) {
        coffeeMachine.setType(type);
    }

    @Step
    public void chooseCoffeeSize(CoffeeSize size) {
        coffeeMachine.setSize(size);
    }

    @Step
    public void doCoffee() throws InterruptedException {
        coffeeCup = coffeeMachine.doCoffee();
    }

    @Step
    public void verifyCoffee(CoffeeType type, CoffeeSize size) {
        Assert.assertNotNull("There is no coffee", coffeeCup);
        Assert.assertEquals("Coffee type is wrong", type, coffeeCup.getType());
        Assert.assertEquals("Coffee size is wrong", size, coffeeCup.getSize());
    }
}