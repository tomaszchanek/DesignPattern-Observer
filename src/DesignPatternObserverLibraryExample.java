import java.util.Observable;
import java.util.Observer;

// Create a custom class that extends Observable
class MyObservable extends Observable {
    private int data;

    public void setData(int data) {
        this.data = data;

        // Notify observers that the data has changed
        setChanged();
        notifyObservers();
    }

    public int getData() {
        return data;
    }
}

// Create an observer class that implements the Observer interface
class MyObserver implements Observer {
    @Override
    public void update(Observable observable, Object arg) {
        if (observable instanceof MyObservable) {
            MyObservable myObservable = (MyObservable) observable;
            int data = myObservable.getData();
            System.out.println("Received data update: " + data);
        }
    }
}

class ObserverExample {
    public static void main(String[] args) {
        // Create an instance of the observable class
        MyObservable observable = new MyObservable();

        // Create an instance of the observer class
        MyObserver observer = new MyObserver();

        // Add the observer to the observable
        observable.addObserver(observer);

        // Set some data in the observable
        observable.setData(42);
    }
}
