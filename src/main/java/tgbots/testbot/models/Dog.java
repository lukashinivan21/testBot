package tgbots.testbot.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dogs")
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_dog")
    private Long id;

    @Column(name = "name_dog")
    private String name;

    @Column(name = "age")
    private Double age;

    public Dog(Long id, String name, Double age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Dog() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getAge() {
        return age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return id.equals(dog.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
