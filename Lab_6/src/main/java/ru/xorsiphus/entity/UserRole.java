package ru.xorsiphus.entity;

import javax.persistence.*;

@Entity(name = "userRole")
@Table(name = "user_aut")
public class UserRole implements IEntity
{
    @Id
    @Column
    private String username;

    @Column
    private String role;

    public UserRole()
    {
    }

    public UserRole(String username, String role)
    {
        this.username = username;
        this.role = role;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    @Override
    public String toString()
    {
        return "UserRole{" +
                "username='" + username + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    @Override
    public int getId()
    {
        return 0;
    }

    @Override
    public void setId(int id)
    {

    }
}
