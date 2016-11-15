package by.bsuir.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name = "car", schema = "", catalog = "autopark")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CarEntity {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "idCar")
    private int idCar;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idDriver")
    private DriverEntity idDriver;
    @Column(name = "marka")
    private String marka;
    @Column(name = "gosNumber")
    private String gosNumber;
    @Column(name = "yearMake")
    private int yearMake;

    public CarEntity() {
    }

    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    public DriverEntity getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(DriverEntity idDriver) {
        this.idDriver = idDriver;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getGosNumber() {
        return gosNumber;
    }

    public void setGosNumber(String gosNumber) {
        this.gosNumber = gosNumber;
    }

    public int getYearMake() {
        return yearMake;
    }

    public void setYearMake(int yearMake) {
        this.yearMake = yearMake;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarEntity carEntity = (CarEntity) o;

        if (idCar != carEntity.idCar) return false;
        if (yearMake != carEntity.yearMake) return false;
        if (!idDriver.equals(carEntity.idDriver)) return false;
        if (!marka.equals(carEntity.marka)) return false;
        return gosNumber.equals(carEntity.gosNumber);

    }

    @Override
    public int hashCode() {
        int result = idCar;
        result = 31 * result + idDriver.hashCode();
        result = 31 * result + marka.hashCode();
        result = 31 * result + gosNumber.hashCode();
        result = 31 * result + yearMake;
        return result;
    }
}

