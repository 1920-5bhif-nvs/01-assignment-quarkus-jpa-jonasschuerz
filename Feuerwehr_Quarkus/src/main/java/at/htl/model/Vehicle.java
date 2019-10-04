package at.htl.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@XmlRootElement
@Entity
@Table(name = "Vehicle")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
        @NamedQuery(name = "Vehicle.findAll",query = "select v from Vehicle v")
})
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int mileage; //Kilometerstand
    @Column
    private LocalDate firstRegistration; //Erstzulassung
    @Column
    private String brand;

    //region Constructors
    public Vehicle(int mileage, LocalDate firstRegistration, String brand) {
        this.mileage = mileage;
        this.firstRegistration = firstRegistration;
        this.brand = brand;
    }

    public Vehicle(){

    }
    //endregion


    //region Getter and Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public LocalDate getFirstRegistration() {
        return firstRegistration;
    }

    public void setFirstRegistration(LocalDate firstRegistration) {
        this.firstRegistration = firstRegistration;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    //endregion

}
