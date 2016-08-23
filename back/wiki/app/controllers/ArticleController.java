package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.libs.Json;

import java.sql.SQLException;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;

import dao.ArticleDao;
import models.Article;

public class ArticleController extends Controller {

    @Inject
    ArticleDao articleDao;

    ObjectMapper mapper = new ObjectMapper();

    public Result findAll() throws SQLException {

        return ok(Json.toJson(articleDao.findAll()));
    }

    public Result find(Long id) throws SQLException {

        return ok(Json.toJson(articleDao.find(id)));
    }

    public Result findByCategory(Long id) throws SQLException {

        return ok(Json.toJson(articleDao.findByCategory(id)));
    }

    public Result create() throws SQLException, IOException {
        Article article = mapper.readValue(request().body().asJson().toString(), Article.class);
        return ok(Json.toJson(articleDao.create(article)));
    }

    public Result update() throws SQLException, IOException {
        Article article = mapper.readValue(request().body().asJson().toString(), Article.class);
        return ok(Json.toJson(articleDao.update(article)));
    }

    public Result delete(Long id) throws SQLException, IOException {
        return ok(Json.toJson(articleDao.delete(id)));
    }
}