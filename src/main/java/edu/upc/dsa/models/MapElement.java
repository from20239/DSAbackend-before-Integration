package edu.upc.dsa.models;

import edu.upc.dsa.DB.SQLNotInsert;

public class MapElement {
    @SQLNotInsert String id;
    private String elementId;
    private String levelId;
    private int x;
    private int y;

    public MapElement(){}

    public MapElement(String id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public String getElementId() {
        return elementId;
    }

    public void setElementId(String elementId) {
        this.elementId = elementId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getLevelId() {
        return levelId;
    }

    public void setLevelId(String levelId) {
        this.levelId = levelId;
    }
}
