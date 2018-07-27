package corejava.designpattern.factory;

public class NYPizzaStore extends PizzaStore {
    public Pizza createPizza(String type) {
        switch(type) {
            case "cheese" : return new NYStyleCheesePizza();
            case "pepperoni" : return new NYStylePepperoniPizza();
            default : return null;
        }        
    }
}
