package by.bsuir.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name = "driver", schema = "", catalog = "autopark")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DriverEntity {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "idDriver")
    private int idDriver;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUser")
    private UserEntity idUser;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "age")
    private int age;
    @Column(name = "mail")
    private String main;

    public DriverEntity() {
    }

    public int getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(int idDriver) {
        this.idDriver = idDriver;
    }

    public UserEntity getIdUser() {
        return idUser;
    }

    public void setIdUser(UserEntity idUser) {
        this.idUser = idUser;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DriverEntity that = (DriverEntity) o;

        if (idDriver != that.idDriver) return false;
        if (age != that.age) return false;
        if (!idUser.equals(that.idUser)) return false;
        if (!name.equals(that.name)) return false;
        if (!surname.equals(that.surname)) return false;
        if (!lastname.equals(that.lastname)) return false;
        return main.equals(that.main);

    }

    @Override
    public int hashCode() {
        int result = idDriver;
        result = 31 * result + idUser.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + lastname.hashCode();
        result = 31 * result + age;
        result = 31 * result + main.hashCode();
        return result;
    }
}
