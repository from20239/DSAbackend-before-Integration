package edu.upc.dsa.models;

import java.util.List;

public class CustomLevel {
    private List<MapElement> elements;
    private String levelName;
    private String userId;

    public List<MapElement> getElements() {
        return elements;
    }

    public void setElements(List<MapElement> elements) {
        this.elements = elements;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
