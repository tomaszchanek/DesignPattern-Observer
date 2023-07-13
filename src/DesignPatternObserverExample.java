import editor.Editor;
import listeners.EmailNotificationListener;
import listeners.LogOpenListener;

public class DesignPatternObserverExample {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.events.subscribe("open", new EmailNotificationListener("abc@dot.com"));
        editor.events.subscribe("open", new EmailNotificationListener("ghana@dot.com"));
        editor.events.subscribe("open", new EmailNotificationListener("fjord@dot.com"));
        editor.events.subscribe("open", new EmailNotificationListener("olha@dot.com"));
        editor.events.subscribe("open", new EmailNotificationListener("tom@dot.com"));
        editor.events.subscribe("save", new EmailNotificationListener("abc@dot.com"));
        editor.events.subscribe("save", new EmailNotificationListener("ghana@dot.com"));
        editor.events.subscribe("save", new EmailNotificationListener("fjord@dot.com"));
        editor.events.subscribe("save", new EmailNotificationListener("olha@dot.com"));
        editor.events.subscribe("save", new EmailNotificationListener("tom@dot.com"));

        editor.events.subscribe("open", new LogOpenListener("/path/to/log/fileABC.txt"));
        editor.events.subscribe("open", new LogOpenListener("/path/to/log/fileGhana.txt"));
        editor.events.subscribe("open", new LogOpenListener("/path/to/log/fileFjord.txt"));
        editor.events.subscribe("open", new LogOpenListener("/path/to/log/fileOlha.txt"));
        editor.events.subscribe("open", new LogOpenListener("/path/to/log/fileTom.txt"));
        editor.events.subscribe("save", new LogOpenListener("/path/to/log/fileABC.txt"));
        editor.events.subscribe("save", new LogOpenListener("/path/to/log/fileGhana.txt"));
        editor.events.subscribe("save", new LogOpenListener("/path/to/log/fileFjord.txt"));
        editor.events.subscribe("save", new LogOpenListener("/path/to/log/fileOlha.txt"));
        editor.events.subscribe("save", new LogOpenListener("/path/to/log/fileTom.txt"));

        editor.openFile("iLikeMetal.txt");
        try {
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}