package by.bsuir.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name = "user", schema = "", catalog = "autopark")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserEntity {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "idUser")
    private int idUser;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;

    public UserEntity() {

    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (idUser != that.idUser) return false;
        if (!login.equals(that.login)) return false;
        return password.equals(that.password);

    }

    @Override
    public int hashCode() {
        int result = idUser;
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }
}

