package by.bsuir.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name = "park", schema = "", catalog = "autopark")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ParkEntity {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "idPark")
    private int idPark;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idCar")
    private CarEntity idCar;
    @Column(name = "countTrip")
    private int countTrip;
    @Column(name = "countRepair")
    private int countRepair;
    @Column(name = "access")
    private int access;

    public ParkEntity() {
    }

    public int getIdPark() {
        return idPark;
    }

    public void setIdPark(int idPark) {
        this.idPark = idPark;
    }

    public CarEntity getIdCar() {
        return idCar;
    }

    public void setIdCar(CarEntity idCar) {
        this.idCar = idCar;
    }

    public int getCountTrip() {
        return countTrip;
    }

    public void setCountTrip(int countTrip) {
        this.countTrip = countTrip;
    }

    public int getCountRepair() {
        return countRepair;
    }

    public void setCountRepair(int countRepair) {
        this.countRepair = countRepair;
    }

    public int getAccess() {
        return access;
    }

    public void setAccess(int access) {
        this.access = access;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParkEntity that = (ParkEntity) o;

        if (idPark != that.idPark) return false;
        if (countTrip != that.countTrip) return false;
        if (countRepair != that.countRepair) return false;
        if (access != that.access) return false;
        return idCar.equals(that.idCar);

    }

    @Override
    public int hashCode() {
        int result = idPark;
        result = 31 * result + idCar.hashCode();
        result = 31 * result + countTrip;
        result = 31 * result + countRepair;
        result = 31 * result + access;
        return result;
    }
}