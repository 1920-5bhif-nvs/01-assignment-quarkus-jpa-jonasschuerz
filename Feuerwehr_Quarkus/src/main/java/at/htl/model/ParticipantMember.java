package at.htl.model;

import javax.persistence.*;

@Entity(name = "Participant_Member")
public class ParticipantMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Member member;

    @ManyToOne(cascade = CascadeType.ALL)
    private Operation operation;

    //region Constructors
    public ParticipantMember(){

    }

    public ParticipantMember(Member member, Operation mission) {
        this.member = member;
        this.operation = mission;
    }

    //endregion


    //region Getter and Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
    //endregion
}
