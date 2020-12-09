package ru.xorsiphus.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "user")
@Table(name = "users")
public class User implements IEntity
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private int id;

    @NotNull(message = "Имя пользователя не должно быть пустым")
    @Size(min = 2, max = 30, message = "Некорректная длина имени пользователя")
    @Column(nullable = false)
    private String username;

    @Column
    private String biography;

    @Column
    @NotNull
    @Size(min = 3, max = 30, message = "Некорректная длина пароля")
    private String password;

    @Transient
    private String repeat_password;

    public User()
    {
    }

    public User(String username, String biography, String password)
    {
        this.username = username;
        this.biography = biography;
        this.password = password;
    }

    public User(String username, String biography, String password, String repeat_password)
    {
        this.username = username;
        this.biography = biography;
        this.password = password;
        this.repeat_password = repeat_password;
    }

    public User(int id, String username, String biography, String password)
    {
        this.id = id;
        this.username = username;
        this.biography = biography;
        this.password = password;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getBiography()
    {
        return biography;
    }

    public void setBiography(String biography)
    {
        this.biography = biography;
    }

    public String getPassword()
    {
        return password;
    }

    public String getRepeat_password()
    {
        return repeat_password;
    }

    public void setRepeat_password(String repeat_password)
    {
        this.repeat_password = repeat_password;
    }

    public void setPassword(String password)
    {
        this.password = password;
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

    @Override
    public String toString()
    {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", biography='" + biography + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
