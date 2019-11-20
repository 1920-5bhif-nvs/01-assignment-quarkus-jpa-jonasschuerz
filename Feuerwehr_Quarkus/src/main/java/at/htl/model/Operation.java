package at.htl.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@XmlRootElement
@Entity
@Table(name = "OPERATION")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
        @NamedQuery(name = "Operation.findAll",query = "select o from Operation o ")
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

    @ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name="PARTICIPATE_VEHICLE",
            joinColumns = @JoinColumn(name = "OPERATIONID"),
            inverseJoinColumns = @JoinColumn(name = "VEHICLEID")
    )
    private List<Vehicle> vehicles;

    @ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name="PARTICIPATE_MEMBER",
            joinColumns = @JoinColumn(name = "OPERATIONID"),
            inverseJoinColumns = @JoinColumn(name = "MEMBERID")
    )
    private List<Member> members;

    public Operation(){
        members = new LinkedList<>();
        vehicles = new LinkedList<>();
    }

    public Operation(String typeOfMission, String alarmText, Integer alert, String position, LocalDate time) {
        this();
        this.typeOfMission = typeOfMission;
        this.alarmText = alarmText;
        this.alert = alert;
        this.position = position;
        this.time = time;
    }

    //region Getter and Setter
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        if(!vehicles.contains(vehicle))
            vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){
        if(!vehicles.contains(vehicle))
            vehicles.remove(vehicle);
    }

    public List<Member> getMembers() {
        return members;
    }

    public void addMember(Member member) {
        if(!members.contains(member))
            members.add(member);
    }

    public void removeMember(Member member){
        if(!members.contains(member))
            members.remove(member);
    }

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
