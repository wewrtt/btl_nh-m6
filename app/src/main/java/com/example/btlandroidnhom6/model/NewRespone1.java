package com.example.btlandroidnhom6.model;

import java.io.Serializable;
import java.util.List;

public class NewRespone1 implements Serializable {
    private List<String> label;
    private List<Float> value;
    private String title;

    public NewRespone1(List<String> label, List<Float> value, String title) {
        this.label = label;
        this.value = value;
        this.title = title;
    }

    public List<String> getLabel() {
        return label;
    }

    public void setLabel(List<String> label) {
        this.label = label;
    }

    public List<Float> getValue() {
        return value;
    }

    public void setValue(List<Float> value) {
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
