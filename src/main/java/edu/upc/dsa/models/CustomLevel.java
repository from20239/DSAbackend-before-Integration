package edu.upc.dsa.models;

import edu.upc.dsa.DB.SQLNotInsert;
import edu.upc.dsa.DB.SQLNotSelect;

import java.util.List;

public class CustomLevel {
    @SQLNotInsert private String id;
    @SQLNotInsert @SQLNotSelect private List<MapElement> elements;
    private String levelName;
    private String userId;

    public CustomLevel(){}

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

    public void setUserId(String userName) {
        this.userId = this.userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
