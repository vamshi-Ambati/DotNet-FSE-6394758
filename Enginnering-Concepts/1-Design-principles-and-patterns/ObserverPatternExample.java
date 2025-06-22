import java.util.*;

interface Stock {
    void register(Observer observer);
    void deregister(Observer observer);
    void notifyObservers();
    void setPrice(double price);
}

interface Observer {
    void update(double price);
}

class StockMarket implements Stock {
    private final List<Observer> observers = new ArrayList<>();
    private double price;

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deregister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(price);
        }
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }
}

class MobileApp implements Observer {
    private final String name;

    public MobileApp(String name) {
        this.name = name;
    }

    @Override
    public void update(double price) {
        System.out.println("MobileApp " + name + ": Stock price updated to " + price);
    }
}

class WebApp implements Observer {
    private final String name;

    public WebApp(String name) {
        this.name = name;
    }

    @Override
    public void update(double price) {
        System.out.println("WebApp " + name + ": Stock price updated to " + price);
    }
}

public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();
        Observer mobile1 = new MobileApp("Alpha");
        Observer web1 = new WebApp("Beta");

        stockMarket.register(mobile1);
        stockMarket.register(web1);

        stockMarket.setPrice(100.5);
        stockMarket.setPrice(102.0);

        stockMarket.deregister(mobile1);
        stockMarket.setPrice(99.0);
    }
}
