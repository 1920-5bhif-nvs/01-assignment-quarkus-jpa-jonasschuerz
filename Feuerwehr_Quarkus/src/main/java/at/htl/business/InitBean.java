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
        em.persist(meier);
        Member meierF = new Member("Friedrich Meier","Oberamtswalter","f.meier@mail.com", LocalDate.parse("1994-03-01", fm));
        em.persist(meierF);
        Commando mustermann = new Commando("Max Mustermann","Loeschmeister","m.mustermann@mail.com", LocalDate.parse("1994-03-01", fm),"Amtswalter");
        em.persist(mustermann);
        Commando musterfrau = new Commando("Frau Musterfrau","Loeschmeister","f.musterfrau@mail.com", LocalDate.parse("1994-03-01", fm),"Schriftführerin");
        em.persist(musterfrau);
        Operation operationFirst = new Operation("BRANDMELDEANLAGE","Brandmelder UO-52-1 ausgelöst",1,"Mustercitystraße 5, Mustercity",LocalDate.parse("2018-04-01", fm));
        Operation operationSecond = new Operation("FAHRZEUGBERGUNG","Traktor in Teich",1,"Mustercitystraße 2, Mustercity",LocalDate.parse("2017-07-21", fm));
        Operation operationThree = new Operation("WASSERSCHADEN","Wasser im Keller",1,"Mustercitystraße 1, Mustercity",LocalDate.parse("2018-12-03", fm));

        Vehicle v1 = new Vehicle(56732,LocalDate.parse("2009-11-30", fm),"LFB Mercedes");
        em.persist(v1);
        Vehicle v2 = new Vehicle(21342,LocalDate.parse("2012-12-21",fm),"KDO Mercedes");
        em.persist(v2);
        WaterTender t1 = new WaterTender(34230,LocalDate.parse("1998-07-24", fm),"Steyr",2000,"Fox 2","TLF A 2000");
        em.persist(t1);

        //Erster Einsatz, Teilnehmer und Fahrzeuge
        operationFirst.addMember(meier);
        operationFirst.addMember(meierF);
        operationFirst.addMember(musterfrau);
        operationFirst.addMember(mustermann);
        operationFirst.addVehicle(v1);
        operationFirst.addVehicle(v2);
        operationFirst.addVehicle(t1);
        em.persist(operationFirst);

        //Zweiter Einsatz Teilnehmer und Fahrezeuge
        operationSecond.addMember(meier);
        operationSecond.addMember(mustermann);
        operationSecond.addVehicle(v1);
        operationSecond.addVehicle(v2);
        em.persist(operationSecond);

        // Dritter Einsatz, Teilnehmer und Fahrzeuge
        operationThree.addMember(mustermann);
        operationThree.addMember(musterfrau);
        operationThree.addVehicle(v2);
        operationFirst.addVehicle(v1);
        em.persist(operationThree);



    }

}
