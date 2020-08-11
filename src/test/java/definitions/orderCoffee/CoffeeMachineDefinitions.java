package definitions.orderCoffee;

import coffee_machine.entities.CoffeeMachine;
import coffee_machine.entities.enums.CoffeeMachineStatus;
import coffee_machine.entities.enums.CoffeeSize;
import coffee_machine.entities.enums.CoffeeType;
import coffee_machine.entities.enums.ResourceType;
import coffee_machine.steps.CoffeeMachineSteps;
//import cucumber.api.DataTable;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class CoffeeMachineDefinitions {

    // Для использования шагов их нужно просто объявить без инициализации
    @Steps
    CoffeeMachineSteps coffeeMachineSteps;

    @Given("coffee machine is ready for an order")
    public void coffeeMachineIsReady() {
        Stream.of(ResourceType.values())
                .forEach(coffeeMachineSteps::machineHasResource);
        coffeeMachineSteps.setupMachine(CoffeeMachineStatus.Ready);

    }

//    @When("Customer order a cup of <$type>")
//    public void customerOrderACupOfLatte(CoffeeType type) {
//    }

    // $ определяет что это переменная
    @When("Customer order a cup of ('*')")
    public void OrderACup(CoffeeType type) throws InterruptedException {
        coffeeMachineSteps.chooseCoffeeType(type);
        coffeeMachineSteps.chooseCoffeeSize(CoffeeSize.Medium);
        coffeeMachineSteps.setDeposite(6);
        coffeeMachineSteps.doCoffee();
    }

    @Then("Customer get a cap of ('*')")
    public void verifyCup(CoffeeType type) {
        coffeeMachineSteps.verifyCoffee(type, CoffeeSize.Medium);
    }

    @Given("Coffee machine has enough ('*') in the machine")
    public void coffeeMachineHasResourse(ResourceType resource) {
        coffeeMachineSteps.machineHasResource(resource);
    }

    @Given("Coffee machine in ('*') status")
    public void setCoffeeMachineStatus(CoffeeMachineStatus status) {
        coffeeMachineSteps.setupMachine(status);
    }

    @When("Customer have deposited ('\\d') dollar")
    public void depositeMoney(Integer amount) {
        coffeeMachineSteps.setDeposite(amount);
    }

    @When("Customer choose coffee type ('*')")
    public void setCoffeeType(CoffeeType type) {
        coffeeMachineSteps.chooseCoffeeType(type);
    }

    @When("Customer choose coffee size ('*')")
    public void setCoffeeSize(CoffeeSize size) {
        coffeeMachineSteps.chooseCoffeeSize(size);
    }

    @When("Customer press the Start button")
    public void setCoffeeSize() throws InterruptedException {
        coffeeMachineSteps.doCoffee();
    }

    @Then("Customer get a cap of coffee with params: $params")
    public void verifyCoffee(DataTable params) {
//        for (Parameters row : params.getRowsAsParameters()) {
//            CoffeeType type = row.valueAs("type", CoffeeType.class);
//            CoffeeSize size = row.valueAs("size", CoffeeSize.class);
//            coffeeMachineSteps.verifyCoffee(type, size);
//        }

        List<Map<String, String>> exampleTable = params.asMaps(String.class, String.class);
//        List<List<String>> exampleTable = params.raw();

        for (Map<String, String> row : exampleTable) {
            CoffeeType type = CoffeeType.valueOf(row.get("type"));
            CoffeeSize size = CoffeeSize.valueOf(row.get("size"));
            coffeeMachineSteps.verifyCoffee(type, size);
        }

//        for (List<String> row : exampleTable) {
//            CoffeeType type = CoffeeType.valueOf(row.get(0));
//            CoffeeSize size = CoffeeSize.valueOf(row.get(1));
//            coffeeMachineSteps.verifyCoffee(type, size);
//        }

    }
}
