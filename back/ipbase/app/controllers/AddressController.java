package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.libs.Json;

import java.sql.SQLException;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;

import dao.AddressDao;
import models.Address;

public class AddressController extends Controller {

    @Inject
    AddressDao addressDao;

    ObjectMapper mapper = new ObjectMapper();

    public Result findAll() throws SQLException {

        return ok(Json.toJson(addressDao.findAll()));
    }

    public Result find(Long id) throws SQLException {

        return ok(Json.toJson(addressDao.find(id)));
    }

    public Result findByGroup(Long id) throws SQLException {

        return ok(Json.toJson(addressDao.findByGroup(id)));
    }

    public Result create() throws SQLException, IOException {
        Address address = mapper.readValue(request().body().asJson().toString(), Address.class);
        return ok(Json.toJson(addressDao.create(address)));
    }

    public Result update() throws SQLException, IOException {
        Address address = mapper.readValue(request().body().asJson().toString(), Address.class);
        return ok(Json.toJson(addressDao.update(address)));
    }

    public Result delete(Long id) throws SQLException, IOException {
        return ok(Json.toJson(addressDao.delete(id)));
    }
}