package br.sp.anhembi.p1.entities;

public class Card {

    public enum Type {
        NUMERIC,
        REVERSE,
        JUMP,
        PLUS_2,
        PLUS_4,
        CHANGE_COLOR
    }

    private final String label;
    private final Type type;
    private final String color;

    public Card(String label, Type type, String color) {
        this.label = label;
        this.type = type;
        this.color = color;
    }

    public Card(String label, Type type) {
        this.label = label;
        this.type = type;
        this.color = type == Type.CHANGE_COLOR || type == Type.PLUS_4 ? "black" : null;
    }

    public String getLabel() {
        return label;
    }

    public Type getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public String getCardImagePath() {
        String path = System.getProperty("user.dir") + "/assets/";
        if (color.equals("black"))
            path += "special/" + getLabel().toLowerCase() + ".png";
        else
            path += getColor() + "/" + getLabel().toLowerCase() + ".png";
        return path;
    }
}