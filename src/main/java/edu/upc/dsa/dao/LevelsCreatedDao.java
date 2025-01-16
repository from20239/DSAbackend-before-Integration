package edu.upc.dsa.dao;

import edu.upc.dsa.models.CustomLevel;
import java.sql.SQLException;
import java.util.List;

public interface LevelsCreatedDao {
    List<CustomLevel> getLevelsByUserId(String userId) throws SQLException;
}
