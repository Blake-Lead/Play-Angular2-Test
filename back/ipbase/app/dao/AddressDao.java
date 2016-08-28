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

import models.Address;

public class AddressDao {

    private Config conf = ConfigFactory.load();
    private String DB_DRIVER = conf.getString("db.default.driver");
    private String DB_CONNECTION = conf.getString("db.default.url");
    private String DB_USER = conf.getString("db.default.username");
    private String DB_PASSWORD = conf.getString("db.default.password");

    public Collection<Address> findAll() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;
        String query = "select * from address;";
        List<Address> addresses = new ArrayList();
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Address address = new Address(
                    rs.getLong("id"),
                    rs.getString("ip"),
                    rs.getInt("port"),
                    rs.getString("description"),
                    rs.getLong("group_id"));
                addresses.add(address);
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
        return addresses;
    }

    public Address find(Long id) throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;
        String query = "select * from address where id = " + id + ";";
        Address address = new Address();
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                address.setId(rs.getLong("id"));
                address.setIp(rs.getString("ip"));
                address.setPort(rs.getInt("port"));
                address.setDescription(rs.getString("description"));
                address.setGroupId(rs.getLong("group_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) { statement.close(); }
            if (dbConnection != null) { dbConnection.close(); }
        }
        return address;
    }

    public Collection<Address> findByGroup(Long id) throws SQLException {
        Connection dbConnection = null;
        PreparedStatement statement = null;
        String query = "select * from address where group_id = ?;";
        List<Address> addresses = new ArrayList();
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.prepareStatement(query);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Address address = new Address(
                    rs.getLong("id"),
                    rs.getString("ip"),
                    rs.getInt("port"),
                    rs.getString("description"),
                    rs.getLong("group_id"));
                addresses.add(address);
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
        return addresses;
    }

    public Boolean create(Address address) throws SQLException {
        Connection dbConnection = null;
        PreparedStatement statement = null;
        String query = "insert into address(ip, port, description, group_id) VALUES(?, ?, ?, ?);";
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.prepareStatement(query);
            statement.setString(1, address.getIp());
            statement.setInt(2, address.getPort());
            statement.setString(3, address.getDescription());
            statement.setLong(4, address.getGroupId());
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

    public Boolean update(Address address) throws SQLException {
        Connection dbConnection = null;
        PreparedStatement statement = null;
        String query = "update address set ip=?, port=?, description=?, group_id=? where id=?;";
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.prepareStatement(query);
            statement.setString(1, address.getIp());
            statement.setInt(2, address.getPort());
            statement.setString(3, address.getDescription());
            statement.setLong(4, address.getGroupId());
            statement.setLong(5, address.getId());
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
        String query = "delete from address where id=?;";
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