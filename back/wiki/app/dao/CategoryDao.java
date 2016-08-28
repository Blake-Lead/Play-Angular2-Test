package dao;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

import models.Category;

public class CategoryDao {

    private Config conf = ConfigFactory.load();
    private String DB_DRIVER = conf.getString("db.default.driver");
    private String DB_CONNECTION = conf.getString("db.default.url");
    private String DB_USER = conf.getString("db.default.username");
    private String DB_PASSWORD = conf.getString("db.default.password");

    public Collection<Category> findAll() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;
        String query = "select * from category;";
        List<Category> categories = new ArrayList();
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Category category = new Category(
                    rs.getLong("id"),
                    rs.getString("tag"),
                    rs.getString("description"));
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
        return categories;
    }

    public Category find(Long id) throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;
        String query = "select * from category where id = " + id + ";";
        Category category = new Category();
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                category.setId(rs.getLong("id"));
                category.setTag(rs.getString("tag"));
                category.setDescription(rs.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) { statement.close(); }
            if (dbConnection != null) { dbConnection.close(); }
        }
        return category;
    }

    public Boolean create(Category category) throws SQLException {
        Connection dbConnection = null;
        PreparedStatement statement = null;
        String query = "insert into category(tag, description) VALUES(?, ?);";
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.prepareStatement(query);
            statement.setString(1, category.getTag());
            statement.setString(2, category.getDescription());
            int rs = statement.executeUpdate();
            return (rs == 1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) { statement.close(); }
            if (dbConnection != null) { dbConnection.close(); }
        }
        return false;
    }

    public Boolean update(Category category) throws SQLException {
        Connection dbConnection = null;
        PreparedStatement statement = null;
        String query = "update category set tag=?, description=? where id=?;";
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.prepareStatement(query);
            statement.setString(1, category.getTag());
            statement.setString(2, category.getDescription());
            int rs = statement.executeUpdate();
            return (rs == 1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) { statement.close(); }
            if (dbConnection != null) { dbConnection.close(); }
        }
        return false;
    }

    public Boolean delete(Long id) throws SQLException {
        Connection dbConnection = null;
        PreparedStatement statement = null;
        String query = "delete from category    where id=?;";
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.prepareStatement(query);
            statement.setLong(1, id);
            int rs = statement.executeUpdate();
            return (rs == 1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) { statement.close(); }
            if (dbConnection != null) { dbConnection.close(); }
        }
        return false;
    }

    private Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dbConnection;
    }
}