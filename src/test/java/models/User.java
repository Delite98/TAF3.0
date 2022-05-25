package models;

import java.util.Objects;

public class User {
    private String name;
    private String email;
    private String psw;

    public User() {
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPsw() {
        return psw;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getName(), user.name) && Objects.equals(email, user.email) && Objects.equals(psw, user.psw);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, psw);
    }
}
