package publisher;

import java.io.File;
import java.util.*;

import listeners.EventListener;

public class EventManager {
    Map<String, List<EventListener>> listeners = new HashMap();

    public EventManager(String... operations) {
        for (String ops : operations) {
            this.listeners.put(ops, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.add(listener);
    }

    public void unsubscribe(String eventType, EventListener listener) {
        var users = listeners.get(eventType);
        users.remove(listener);
    }

    public void notify(String eventType, File file) {
        var users = listeners.get(eventType);
        for (EventListener listener : users) {
            listener.update(eventType, file);
        }
    }
}
