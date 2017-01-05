package com.uwimonacs.computingsociety.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * @author sultanofcardio
 *
 * This class represents a user in the system. We are using ActiveAndroid as an Object Relational
 * Mapper (ORM) and as such, the superclass must be the Model class. Another stipulation is that
 * such a class must have a no argument constructor. The class is annotated with the @Table to
 * inform the superclass that this class should be represented in the database. Its member
 * variables are annotated with the @Column to inform the superclass what the variable names
 * should be in the database. Of course, those could be different from the actual names but for
 * simplicity they are the same. Please note the user of Builder notation for the class setter
 * methods.
 */
@Table(name="User")
public class User extends Model {

    @Column(name="user_id")
    private int user_id;

    @Column(name="email")
    private String email;

    @Column(name="first_name")
    private String first_name;

    @Column(name="last_name")
    private String last_name;

    @Column(name="username")
    private String username;

    /**
     * Mandatory no arguments constructor. To be user by superclass
     */
    public User(){

    }

    /**
     * Returns a new user
     * @param user_id User id
     * @param email Email address
     * @param first_name First name
     * @param last_name Last name
     * @param username Username
     */
    public User(int user_id, String email, String first_name, String last_name, String username) {
        this.user_id = user_id;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
    }

    /**
     * Returns the user id of this user
     * @return integer user id
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * Provide a new user id for this user
     * @param user_id integer user id
     * @return Returns the modified user object
     */
    public User setUser_id(int user_id) {
        this.user_id = user_id;
        return this;
    }

    /**
     * Returns the email address of this user
     * @return String email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Provide a new email address for this user
     * @param email String email address
     * @return Returns the modified user object
     */
    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * Returns the first name of this user
     * @return String first name
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * Provide a new first name for this user
     * @param first_name String first name
     * @return Returns the modified user object
     */
    public User setFirst_name(String first_name) {
        this.first_name = first_name;
        return this;
    }

    /**
     * Returns the last name of this user
     * @return String last name
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * Provide a new last name for this user
     * @param last_name String last name
     * @return Returns the modified user object
     */
    public User setLast_name(String last_name) {
        this.last_name = last_name;
        return this;
    }

    /**
     * Returns the username of this user
     * @return String username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Provide a new username for this user
     * @param username String username
     * @return Returns the modified user object
     */
    public User setUsername(String username) {
        this.username = username;
        return this;
    }
}
