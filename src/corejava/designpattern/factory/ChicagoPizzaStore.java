package corejava.designpattern.factory;

public class ChicagoPizzaStore extends PizzaStore {
    public Pizza createPizza(String type) {
        switch(type) {
            case "cheese" : return new ChicagoStyleCheesePizza();
            case "pepperoni" : return new ChicagoStylePepperoniPizza();
            default : return null;
        }
    }
}
