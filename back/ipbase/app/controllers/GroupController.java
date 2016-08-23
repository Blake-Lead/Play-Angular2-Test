package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.libs.Json;

import java.sql.SQLException;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;

import dao.GroupDao;
import models.Group;

public class GroupController extends Controller {

    @Inject
    GroupDao groupDao;

    ObjectMapper mapper = new ObjectMapper();

    public Result findAll() throws SQLException {

        return ok(Json.toJson(groupDao.findAll()));
    }

    public Result find(Long id) throws SQLException {

        return ok(Json.toJson(groupDao.find(id)));
    }

    public Result create() throws SQLException, IOException {
        Group group = mapper.readValue(request().body().asJson().toString(), Group.class);
        return ok(Json.toJson(groupDao.create(group)));
    }

    public Result update() throws SQLException, IOException {
        Group group = mapper.readValue(request().body().asJson().toString(), Group.class);
        return ok(Json.toJson(groupDao.update(group)));
    }

    public Result delete(Long id) throws SQLException, IOException {
        return ok(Json.toJson(groupDao.delete(id)));
    }
}