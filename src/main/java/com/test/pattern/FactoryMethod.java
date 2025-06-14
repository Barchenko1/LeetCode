package com.test.pattern;

public class FactoryMethod {

    class Burger {

    }

    class VeganBurger extends Burger {

    }

    class CheeseBurger extends Burger {

    }

    enum BurgerType {
        CHEESEBURGER,
        DELUXE_CHEESEBURGER,
        VEGANBURGER,
    }

    class SimpleBurger {
        public Burger getBurger(BurgerType burgerType) {
            if (BurgerType.CHEESEBURGER == burgerType) {
                return new CheeseBurger();
            }
            if (BurgerType.VEGANBURGER == burgerType) {
                return new VeganBurger();
            }
            return null;
        }
    }
}
