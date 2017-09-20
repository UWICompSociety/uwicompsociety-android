package com.uwimonacs.computingsociety.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

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

    @Column(name="userId")
    private int userId;

    @Column(name="email")
    private String email;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="username")
    private String username;

    @Column(name="position")
    private String position;

    @Column(name="imageUrl")
    private String imageUrl;

    /**
     * Mandatory no arguments constructor. To be user by superclass
     */
    public User(){
        super();
    }

    /**
     * Returns a new user
     * @param userId User id
     * @param email Email address
     * @param firstName First name
     * @param lastName Last name
     * @param username Username
     * @param position Username
     * @param imageUrl Username
     */
    public User(int userId, String email, String firstName, String lastName, String username,
                String position, String imageUrl) {
        this.userId = userId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.position = position;
        this.imageUrl = imageUrl;
    }

    /**
     * Returns the user id of this user
     * @return integer user id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Provide a new user id for this user
     * @param userId integer user id
     * @return Returns the modified user object
     */
    public User setUserId(int userId) {
        this.userId = userId;
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
    public String getFirstName() {
        return firstName;
    }

    /**
     * Provide a new first name for this user
     * @param firstName String first name
     * @return Returns the modified user object
     */
    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * Returns the last name of this user
     * @return String last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Provide a new last name for this user
     * @param lastName String last name
     * @return Returns the modified user object
     */
    public User setLastName(String lastName) {
        this.lastName = lastName;
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

    /**
     * Returns the position of this user in the Computing Society
     * @return String position
     */
    public String getPosition() {
        return position;
    }

    /**
     * Provide a new position for this user
     * @param position String position
     * @return Returns the modified user object
     */
    public User setPosition(String position) {
        this.position = position;
        return this;
    }

    /**
     * Returns the URL of this user's profile image
     * @return String URL
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * Provide a new profile image URL for this user
     * @param imageUrl String URL
     * @return Returns the modified user object
     */
    public User setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public static User getUser(int user_id){
        return new Select().from(User.class).where("id = ?", user_id).executeSingle();
    }
}
