package at.htl.model;

import javax.persistence.*;

@Entity
public class ParticipantVehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Operation operation;

    @ManyToOne(cascade = CascadeType.ALL)
    private Vehicle vehicle;


    //region Constructors
    public ParticipantVehicle(){}

    public ParticipantVehicle(Operation operation, Vehicle vehicle) {
        this.operation = operation;
        this.vehicle = vehicle;
    }
    //endregion


    //region Getter and Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    //endregion
}
