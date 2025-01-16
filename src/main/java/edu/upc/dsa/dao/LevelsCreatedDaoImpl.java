package edu.upc.dsa.dao;

import edu.upc.dsa.dao.LevelsCreatedDao;
import edu.upc.dsa.models.CustomLevel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LevelsCreatedDaoImpl implements LevelsCreatedDao {

    private Connection connection;

    public LevelsCreatedDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<CustomLevel> getLevelsByUserId(String userId) throws SQLException {
        List<CustomLevel> levels = new ArrayList<>();
        String query = "SELECT * FROM CustomLevel WHERE userId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                CustomLevel level = new CustomLevel();
                level.setId(rs.getString("id"));
                level.setUserId(rs.getString("userId"));
                level.setLevelName(rs.getString("levelName"));
                levels.add(level);
            }
        }
        return levels;
    }
}
