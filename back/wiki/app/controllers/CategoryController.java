package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.libs.Json;

import java.sql.SQLException;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;

import dao.CategoryDao;
import models.Category;

public class CategoryController extends Controller {

    @Inject
    CategoryDao categoryDao;

    ObjectMapper mapper = new ObjectMapper();

    public Result findAll() throws SQLException {

        return ok(Json.toJson(categoryDao.findAll()));
    }

    public Result find(Long id) throws SQLException {

        return ok(Json.toJson(categoryDao.find(id)));
    }

    public Result create() throws SQLException, IOException {
        Category category = mapper.readValue(request().body().asJson().toString(), Category.class);
        return ok(Json.toJson(categoryDao.create(category)));
    }

    public Result update() throws SQLException, IOException {
        Category category = mapper.readValue(request().body().asJson().toString(), Category.class);
        return ok(Json.toJson(categoryDao.update(category)));
    }

    public Result delete(Long id) throws SQLException, IOException {
        return ok(Json.toJson(categoryDao.delete(id)));
    }
}