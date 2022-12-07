package com.lexass.Model;

public class Beauty {
    private int id;
    private String name;
    private String background_img;

    public Beauty(int id, String name, String background_img) {
        this.id = id;
        this.name = name;
        this.background_img = background_img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBackground_img() {
        return background_img;
    }

    public void setBackground_img(String background_img) {
        this.background_img = background_img;
    }
}
