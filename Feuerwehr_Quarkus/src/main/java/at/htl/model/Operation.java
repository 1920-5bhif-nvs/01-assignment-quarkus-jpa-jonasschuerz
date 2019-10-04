package at.htl.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@XmlRootElement
@Entity
@Table(name = "Operation")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
        @NamedQuery(name = "Operation.findAll",query = "select o from Operation o")
})
public class Operation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String typeOfMission; //Einsatzart
    @Column()
    private String alarmText;
    @Column()
    private Integer alert; //Alarmstufe
    @Column()
    private String position;
    @Column()
    private LocalDate time;

    public Operation(){

    }

    public Operation(String typeOfMission, String alarmText, Integer alert, String position, LocalDate time) {
        this.typeOfMission = typeOfMission;
        this.alarmText = alarmText;
        this.alert = alert;
        this.position = position;
        this.time = time;
    }

    //region Getter and Setter
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeOfMission() {
        return typeOfMission;
    }

    public void setTypeOfMission(String typeOfMission) {
        this.typeOfMission = typeOfMission;
    }

    public String getAlarmText() {
        return alarmText;
    }

    public void setAlarmText(String alarmText) {
        this.alarmText = alarmText;
    }

    public Integer getAlert() {
        return alert;
    }

    public void setAlert(Integer alert) {
        this.alert = alert;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String ort) {
        this.position = ort;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }
    //endregion

}
