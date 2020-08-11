package coffee_machine.entities;

import coffee_machine.entities.enums.CoffeeMachineStatus;
import coffee_machine.entities.enums.CoffeeSize;
import coffee_machine.entities.enums.CoffeeType;
import coffee_machine.entities.enums.ResourceType;
import org.apache.commons.lang3.RandomUtils;

import java.util.HashMap;
import java.util.Map;

public class CoffeeMachine {
    private final Integer lowerLimit = 20;
    private final Integer cost = 6;
    private final Integer resource = 6;
    private Integer deposite;
    private Map<ResourceType, Integer> resourceLevel;
    private CoffeeMachineStatus status;
    private CoffeeType type;
    private CoffeeSize size;

    public CoffeeMachine() {
        this.resourceLevel = new HashMap<ResourceType, Integer>() {{
            put(ResourceType.Water, RandomUtils.nextInt(50, 100));
            put(ResourceType.Coffee, RandomUtils.nextInt(50, 100));
            put(ResourceType.Milk, RandomUtils.nextInt(50, 100));
        }};
        this.deposite = 0;
        this.status = CoffeeMachineStatus.Ready;
    }

    public boolean hasSufficientResourceLevel(ResourceType type) {
        return resourceLevel.get(type) > lowerLimit;
    }

    public Integer getResourceLevel(ResourceType type) {
        return resourceLevel.get(type);
    }

    public void increaseResourceLevel(ResourceType type, Integer waterLevel) {
        resourceLevel.put(type, resourceLevel.get(type) + waterLevel);
    }

    public Integer getDeposite() {
        return deposite;
    }

    public void increaseDeposite(Integer deposite) {
        this.deposite += deposite;
    }

    public CoffeeMachineStatus getStatus() {
        return status;
    }

    public void setType(CoffeeType type) {
        this.type = type;
    }

    public void setSize(CoffeeSize size) {
        this.size = size;
    }

    public CoffeeSize getSize() {
        return size;
    }

    public CoffeeType getType() {
        return type;
    }

    public CoffeeCup doCoffee() throws InterruptedException {
        if (deposite >= cost) {
            status = CoffeeMachineStatus.Busy;
            CoffeeCup cup = new CoffeeCup();
            cup.setType(type);
            Thread.sleep(2000);
            cup.setSize(size);
            Thread.sleep(2000);
            status = CoffeeMachineStatus.Ready;
            deposite -= cost;

            return cup;
        }
        return null;
    }
}
