package edu.averagejoecoffeeco.userdb.api.entities;

public class User {

    private String id;

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Double credit;

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", username='" + getUsername() + "'" + ", password='" + getPassword()
                + "'" + ", firstName='" + getFirstName() + "'" + ", lastName='" + getLastName() + "'" + ", credit='"
                + getCredit() + "'" + "}";
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getCredit() {
        return this.credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public User(String username, String password, String firstName, String lastName, Double credit) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.credit = credit;
    }

}
