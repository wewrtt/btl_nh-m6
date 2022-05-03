package com.example.btlandroidnhom6.model;

import java.io.Serializable;
import java.util.List;

public class NewRespone implements Serializable {
    private List<Float> label;
    private List<Float> value;
    private String title;

    public NewRespone(List<Float> label, List<Float> value, String title) {
        this.label = label;
        this.value = value;
        this.title = title;
    }

    public List<Float> getLabel() {
        return label;
    }

    public void setLabel(List<Float> label) {
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
