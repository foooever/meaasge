package model;
import Dao.*;
import control.*;

public class User {
    public String id;
    public String name;
    public String sex;
    public String password;
    public User() {
        this.id = null;
        this.name = null;
        this.sex = null;
        this.password = null;
    }

    public User(String id, String name, String sex, String password) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
