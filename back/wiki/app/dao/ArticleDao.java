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

import models.Article;

public class ArticleDao {

    private Config conf = ConfigFactory.load();
    private String DB_DRIVER = conf.getString("db.default.driver");
    private String DB_CONNECTION = conf.getString("db.default.url");
    private String DB_USER = conf.getString("db.default.username");
    private String DB_PASSWORD = conf.getString("db.default.password");

    public Collection<Article> findAll() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;
        String query = "select * from article;";
        List<Article> articles = new ArrayList();
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Article article = new Article(
                    rs.getLong("id"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getString("body"),
                    rs.getLong("category_id"));
                articles.add(article);
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
        return articles;
    }

    public Article find(Long id) throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;
        String query = "select * from article where id = " + id + ";";
        Article article = new Article();
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                article.setId(rs.getLong("id"));
                article.setTitle(rs.getString("title"));
                article.setAuthor(rs.getString("author"));
                article.setBody(rs.getString("body"));
                article.setCategoryId(rs.getLong("category_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) { statement.close(); }
            if (dbConnection != null) { dbConnection.close(); }
        }
        return article;
    }

    public Collection<Article> findByCategory(Long id) throws SQLException {
        Connection dbConnection = null;
        PreparedStatement statement = null;
        String query = "select * from article where category_id = ?;";
        List<Article> articles = new ArrayList();
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.prepareStatement(query);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Article article = new Article(
                    rs.getLong("id"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getString("body"),
                    rs.getLong("category_id"));
                articles.add(article);
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
        return articles;
    }

    public Boolean create(Article article) throws SQLException {
        Connection dbConnection = null;
        PreparedStatement statement = null;
        String query = "insert into article(title, author, body, category_id) VALUES(?, ?, ?, ?);";
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.prepareStatement(query);
            statement.setString(1, article.getTitle());
            statement.setString(2, article.getAuthor());
            statement.setString(3, article.getBody());
            statement.setLong(4, article.getCategoryId());
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

    public Boolean update(Article article) throws SQLException {
        Connection dbConnection = null;
        PreparedStatement statement = null;
        String query = "update article set title=?, author=?, body=?, category_id=? where id=?;";
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.prepareStatement(query);
            statement.setString(1, article.getTitle());
            statement.setString(2, article.getAuthor());
            statement.setString(3, article.getBody());
            statement.setLong(4, article.getCategoryId());
            statement.setLong(5, article.getId());
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
        String query = "delete from article where id=?;";
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