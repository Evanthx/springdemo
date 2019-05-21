package org.evan.springdemo.spring.Examples;

public class DemoEvent {
    private String value;

    public DemoEvent(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
