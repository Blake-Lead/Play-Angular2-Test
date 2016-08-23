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

import models.Group;

public class GroupDao {

    private Config conf = ConfigFactory.load();
    private String DB_DRIVER = conf.getString("db.postgresql.driver");
    private String DB_CONNECTION = conf.getString("db.postgresql.url");
    private String DB_USER = conf.getString("db.postgresql.username");
    private String DB_PASSWORD = conf.getString("db.postgresql.password");

    public Collection<Group> findAll() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;
        String query = "select * from agroup;";
        List<Group> groups = new ArrayList();
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Group group = new Group(
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("description"));
                groups.add(group);
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
        return groups;
    }

    public Group find(Long id) throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;
        String query = "select * from agroup where id = " + id + ";";
        Group group = new Group();
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                group.setId(rs.getLong("id"));
                group.setName(rs.getString("name"));
                group.setDescription(rs.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) { statement.close(); }
            if (dbConnection != null) { dbConnection.close(); }
        }
        return group;
    }

    public Boolean create(Group group) throws SQLException {
        Connection dbConnection = null;
        PreparedStatement statement = null;
        String query = "insert into agroup(name, description) VALUES(?, ?);";
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.prepareStatement(query);
            statement.setString(1, group.getName());
            statement.setString(2, group.getDescription());
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

    public Boolean update(Group group) throws SQLException {
        Connection dbConnection = null;
        PreparedStatement statement = null;
        String query = "update agroup set name=?, description=? where id=?;";
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.prepareStatement(query);
            statement.setString(1, group.getName());
            statement.setString(2, group.getDescription());
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
        String query = "delete from agroup where id=?;";
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