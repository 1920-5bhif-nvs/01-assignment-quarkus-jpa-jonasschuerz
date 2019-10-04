package at.htl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@XmlRootElement
@Entity
@Table(name = "Commando")
public class Commando extends Member {

    @Column
    private String functioning;

    public Commando(String name, String rank, String mail, LocalDate involvedSince, String function) {
        super(name, rank, mail, involvedSince);
        this.functioning = function;
    }

    public Commando(){}

    public String getFunctioning() {
        return functioning;
    }

    public void setFunctioning(String function) {
        this.functioning = function;
    }
}
