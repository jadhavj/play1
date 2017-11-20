package models;

/**
 * Created by M1039838 on 11/17/2017.
 */
public class User {
    protected String email;
    protected String password;

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
