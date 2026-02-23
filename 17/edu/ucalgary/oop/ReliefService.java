package edu.ucalgary.oop;

import java.time.LocalDate;

public class ReliefService {
    private Inquirer inquirer;
    private DisasterVictim missingPerson;
    private LocalDate dateOfInquiry;
    private String infoProvided;
    private Location lastKnownLocation;

    public ReliefService(Inquirer inquirer, DisasterVictim missingPerson, LocalDate inquiryDate, String infoProvided, Location lastLocation) {
        this.inquirer = inquirer;
        this.missingPerson = missingPerson;
        this.dateOfInquiry = inquiryDate;
        this.infoProvided = infoProvided;
        this.lastKnownLocation = lastLocation;
    }

    public void setDateOfInquiry(LocalDate inquiryDate) {
        if (inquiryDate == null || inquiryDate.isAfter(LocalDate.now()))
            throw new IllegalArgumentException();
        this.dateOfInquiry = inquiryDate;
    }

    public Inquirer getInquirer() {
        return (inquirer);
    }

    public void setInquirer(Inquirer inquirer) {
        this.inquirer = inquirer;
    }

    public DisasterVictim getMissingPerson() {
        return (missingPerson);
    }

    public void setMissingPerson(DisasterVictim missingPerson) {
        this.missingPerson = missingPerson;
    }

    public LocalDate getDateOfInquiry() {
        return dateOfInquiry;
    }

    public String getInfoProvided() {
        return infoProvided;
    }

    public void setInfoProvided(String info) {
        this.infoProvided = info;
    }

    public Location getLastKnownLocation() {
        return lastKnownLocation;
    }

    public void setLastKnownLocation(Location lastLocation) {
        this.lastKnownLocation = lastLocation;
    }

    public String getLogDetails() {
        return new String("Inquirer: " + getInquirer().getFirstName() + ", Missing Person: " + getMissingPerson().getFirstName() + ", Date of Inquiry: " + getDateOfInquiry() + ", Info Provided: " + getInfoProvided() + ", Last Known Location: " + getLastKnownLocation().getName());

    }
}
