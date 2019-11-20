package at.htl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@XmlRootElement
@Entity
@Table(name = "WATERTENDER")
public class WaterTender extends Vehicle {

    @Column
    private int tank;
    @Column
    private String portablePump;
    @Column
    private String type;

    //region Constructors
    public WaterTender(int mileage, LocalDate firstRegistration, String brand, int tank, String portablePump, String type) {
        super(mileage, firstRegistration, brand);
        this.tank = tank;
        this.portablePump = portablePump;
        this.type = type;
    }

    public WaterTender() {
    }
    //endregion

    //region Getter and Setter
    public int getTank() {
        return tank;
    }

    public void setTank(int tank) {
        this.tank = tank;
    }

    public String getPortablePump() {
        return portablePump;
    }

    public void setPortablePump(String tragkraftspritze) {
        this.portablePump = tragkraftspritze;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    //endregion

}
