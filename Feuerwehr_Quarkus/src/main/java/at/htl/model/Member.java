package at.htl.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@XmlRootElement
@Entity
@Table(name = "Member")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
        @NamedQuery(name = "Member.findAll",query = "select m from Member m")
})
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    protected Long id;

    @Column
    protected String name; //Vor- und Zuname
    @Column
    protected String rank;
    @Column
    protected String mail;
    @Column
    protected LocalDate involvedSince;

    public Member(String name, String rank, String mail, LocalDate involvedSince) {
        this.name = name;
        this.rank = rank;
        this.mail = mail;
        this.involvedSince = involvedSince;
    }

    public Member(){

    }

    //region Getter and Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public LocalDate getInvolvedSince() {
        return involvedSince;
    }

    public void setInvolvedSince(LocalDate involvedSince) {
        this.involvedSince = involvedSince;
    }
    //endregion
}
