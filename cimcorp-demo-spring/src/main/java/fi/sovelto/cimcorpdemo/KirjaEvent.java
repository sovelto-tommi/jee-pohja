package fi.sovelto.cimcorpdemo;

import org.springframework.context.ApplicationEvent;

public class KirjaEvent extends ApplicationEvent {
    private String message;

    public KirjaEvent(Object source, String message) {
        super(source);
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}