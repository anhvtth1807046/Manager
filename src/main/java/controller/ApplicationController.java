package controller;

import java.sql.SQLException;

public interface ApplicationController {
    void create();
    void readList();
    void update() throws SQLException;
    void delete();
    void find();
}
