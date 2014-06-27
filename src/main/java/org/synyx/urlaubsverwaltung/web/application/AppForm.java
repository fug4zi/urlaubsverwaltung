/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.synyx.urlaubsverwaltung.web.application;

import org.joda.time.DateMidnight;

import org.synyx.urlaubsverwaltung.core.application.domain.Application;
import org.synyx.urlaubsverwaltung.core.application.domain.DayLength;
import org.synyx.urlaubsverwaltung.core.application.domain.VacationType;
import org.synyx.urlaubsverwaltung.core.person.Person;


/**
 * View class representing an application for leave.
 *
 * @author  Aljona Murygina
 */
public class AppForm {

    private DateMidnight startDate;

    private DateMidnight startDateHalf;

    private DateMidnight endDate;

    // Type of holiday, e.g. holiday, special leave, etc.
    private VacationType vacationType;

    // length of day: contains time of day (morning, noon or full day) and value (1.0 or 0.5 - as BigDecimal)
    private DayLength howLong;

    // For special and unpaid leave a reason is required
    // for holiday default = "Erholung"
    private String reason;

    // Representative of employee during his/her holiday
    private Person rep;

    // Address and phone number during holiday
    private String address;

    private DateMidnight applicationDate;

    private boolean teamInformed;

    private String comment;

    public String getAddress() {

        return address;
    }


    public void setAddress(String address) {

        this.address = address;
    }


    public DateMidnight getApplicationDate() {

        return applicationDate;
    }


    public void setApplicationDate(DateMidnight applicationDate) {

        this.applicationDate = applicationDate;
    }


    public DateMidnight getEndDate() {

        return endDate;
    }


    public void setEndDate(DateMidnight endDate) {

        this.endDate = endDate;
    }


    public DayLength getHowLong() {

        return howLong;
    }


    public void setHowLong(DayLength howLong) {

        this.howLong = howLong;
    }


    public String getReason() {

        return reason;
    }


    public void setReason(String reason) {

        this.reason = reason;
    }


    public Person getRep() {

        return rep;
    }


    public void setRep(Person rep) {

        this.rep = rep;
    }


    public DateMidnight getStartDate() {

        return startDate;
    }


    public void setStartDate(DateMidnight startDate) {

        this.startDate = startDate;
    }


    public DateMidnight getStartDateHalf() {

        return startDateHalf;
    }


    public void setStartDateHalf(DateMidnight startDateHalf) {

        this.startDateHalf = startDateHalf;
    }


    public VacationType getVacationType() {

        return vacationType;
    }


    public void setVacationType(VacationType vacationType) {

        this.vacationType = vacationType;
    }


    public String getComment() {

        return comment;
    }


    public void setComment(String comment) {

        this.comment = comment;
    }


    public boolean isTeamInformed() {

        return teamInformed;
    }


    public void setTeamInformed(boolean teamInformed) {

        this.teamInformed = teamInformed;
    }


    public Application createApplicationObject() {

        Application app = new Application();

        app.setAddress(this.address);
        app.setVacationType(this.vacationType);
        app.setHowLong(this.howLong);
        app.setReason(this.reason);
        app.setRep(this.rep);
        app.setAddress(this.address);
        app.setApplicationDate(this.applicationDate);
        app.setTeamInformed(this.teamInformed);
        app.setComment(this.comment);

        if (this.howLong == DayLength.FULL) {
            app.setStartDate(this.startDate);
            app.setEndDate(this.endDate);
        } else {
            app.setStartDate(this.startDateHalf);
            app.setEndDate(this.startDateHalf);
        }

        return app;
    }
}