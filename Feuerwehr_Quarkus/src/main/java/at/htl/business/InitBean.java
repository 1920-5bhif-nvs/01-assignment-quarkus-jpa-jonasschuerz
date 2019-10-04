package at.htl.business;

import at.htl.model.*;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@ApplicationScoped
public class InitBean {

    @Inject
    EntityManager em;

    @Transactional
    public void init(@Observes StartupEvent ev){
        DateTimeFormatter fm = DateTimeFormatter.ofPattern("yyyy-MM-dd");


        Member meier = new Member("Max Meier","Oberfeuerwehrmann","m.meier@mail.com", LocalDate.parse("1990-10-01", fm));
        Member meierF = new Member("Friedrich Meier","Oberamtswalter","f.meier@mail.com", LocalDate.parse("1994-03-01", fm));
        Commando mustermann = new Commando("Max Mustermann","Loeschmeister","m.mustermann@mail.com", LocalDate.parse("1994-03-01", fm),"Amtswalter");
        Commando musterfrau = new Commando("Frau Musterfrau","Loeschmeister","f.musterfrau@mail.com", LocalDate.parse("1994-03-01", fm),"Schriftführerin");
        Operation mission1 = new Operation("BRANDMELDEANLAGE","Brandmelder UO-52-1 ausgelöst",1,"Mustercitystraße 5, Mustercity",LocalDate.parse("2018-04-01", fm));
        Operation mission2 = new Operation("FAHRZEUGBERGUNG","Traktor in Teich",1,"Mustercitystraße 2, Mustercity",LocalDate.parse("2017-07-21", fm));
        Operation mission3 = new Operation("WASSERSCHADEN","Wasser im Keller",1,"Mustercitystraße 1, Mustercity",LocalDate.parse("2018-12-03", fm));

        ParticipantMember m1 = new ParticipantMember(meier,mission1);
        ParticipantMember m2 = new ParticipantMember(meier,mission2);
        ParticipantMember m3 = new ParticipantMember(meier,mission3);
        ParticipantMember m4 = new ParticipantMember(meierF,mission1);
        ParticipantMember m5 = new ParticipantMember(meierF,mission3);
        ParticipantMember m6 = new ParticipantMember(mustermann,mission2);
        ParticipantMember m7 = new ParticipantMember(mustermann,mission3);
        ParticipantMember m8 = new ParticipantMember(musterfrau,mission1);
        ParticipantMember m9 = new ParticipantMember(musterfrau,mission3);

        Vehicle v1 = new Vehicle(56732,LocalDate.parse("2009-11-30", fm),"Mercedes");
        WaterTender t1 = new WaterTender(34230,LocalDate.parse("1998-07-24", fm),"Steyr",2000,"Fox 2","TLF A 2000");

        ParticipantVehicle p1 = new ParticipantVehicle(mission1,t1);
        ParticipantVehicle p2 = new ParticipantVehicle(mission2,v1);
        ParticipantVehicle p3 = new ParticipantVehicle(mission2,t1);
        ParticipantVehicle p4 = new ParticipantVehicle(mission3,v1);

        em.persist(meier);
        em.persist(meierF);
        em.persist(mustermann);
        em.persist(musterfrau);
        em.persist(mission1);
        em.persist(mission2);
        em.persist(mission3);
        em.persist(m1);
        em.persist(m2);
        em.persist(m3);
        em.persist(m4);
        em.persist(m5);
        em.persist(m6);
        em.persist(m7);
        em.persist(m8);
        em.persist(m9);
        em.persist(v1);
        em.persist(t1);
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.persist(p4);
    }

}
