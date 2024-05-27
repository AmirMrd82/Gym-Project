/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gym;

import java.util.*;

/**
 *
 * @author Admin
 */
public abstract class User {

    public static ArrayList<User> users = new ArrayList<>();
    protected static int counter = 99;
    protected int id;
    protected String name;
    protected String lastName;
    protected String position;

    public User(String name, String lastName) {
        this.id = ++counter;
        this.name = name;
        this.lastName = lastName;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.id;
        hash = 61 * hash + Objects.hashCode(this.name);
        hash = 61 * hash + Objects.hashCode(this.lastName);
        hash = 61 * hash + Objects.hashCode(this.position);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        return Objects.equals(this.position, other.position);
    }

    @Override
    public String toString() {
        String str = "";
        str += "User ID: " + this.id;
        str += "User's position: " + this.position;
        str += "\nUser's name: " + this.name;
        str += "\nUser's last name: " + this.lastName;
        return str;
    }
}
