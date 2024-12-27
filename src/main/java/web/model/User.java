package web.model;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    @NotBlank(message = "Name should not be empty!")
    private  String name;

    @Column(name = "surname")
    @NotBlank(message = "Surname should not be empty!")
    private String surname;

    @Column(name = "age")
    @Min(value = 0,message = "Age should be more than 0!")
    private int age;

    public User() {
    }

    public User( String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof User)) return false;

        User user = (User) obj;

        return Objects.equals(user.name, name)
                && Objects.equals(user.surname, surname)
                && Objects.equals(user.age, age);
    }
}