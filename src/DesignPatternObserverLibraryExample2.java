import java.util.EventListener;

// Custom event class
class MyEvent {
    private String message;

    public MyEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

// Custom listener interface that extends EventListener
interface MyEventListener extends EventListener {
    void handleEvent(MyEvent event);
}

// Class that generates events and notifies listeners
class EventGenerator {
    private MyEventListener listener;

    public void setListener(MyEventListener listener) {
        this.listener = listener;
    }

    public void doSomething() {
        // Perform some actions

        // Generate an event
        MyEvent event = new MyEvent("Hello, world!");

        // Notify the listener
        if (listener != null) {
            listener.handleEvent(event);
        }
    }
}

// Class that implements the listener interface
class MyListener implements MyEventListener {
    @Override
    public void handleEvent(MyEvent event) {
        System.out.println("Received event: " + event.getMessage());
    }
}

class EventListenerExample {
    public static void main(String[] args) {
        // Create an instance of the event generator
        EventGenerator generator = new EventGenerator();

        // Create an instance of the listener
        MyListener listener = new MyListener();

        // Set the listener to the generator
        generator.setListener(listener);

        // Trigger the event
        generator.doSomething();
    }
}
