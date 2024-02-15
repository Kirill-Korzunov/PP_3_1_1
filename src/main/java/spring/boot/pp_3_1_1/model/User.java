package spring.boot.pp_3_1_1.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "Поле должно быть заполнено")
    private String name;

    @Column(name = "surname")
    @NotBlank(message = "Поле должно быть заполнено")
    private String surName;

    @Column(name = "age")
    @Min(value = 0, message = "Введите свой возраст")
    @Max(value = 100, message = "Введите свой возраст")
    private Integer age;

    @Column(name = "city")
    @NotBlank(message = "Поле должно быть заполнено")
    private String city;

    public User() {
    }

    public User(String name, String surName, Integer age, String city) {
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }
}
