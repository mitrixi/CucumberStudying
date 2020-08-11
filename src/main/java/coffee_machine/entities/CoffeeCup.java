package coffee_machine.entities;

import coffee_machine.entities.enums.CoffeeSize;
import coffee_machine.entities.enums.CoffeeType;

public class CoffeeCup {
    private CoffeeType type;
    private CoffeeSize size;

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
}
