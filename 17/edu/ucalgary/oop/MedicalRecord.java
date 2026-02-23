package edu.ucalgary.oop;
import java.time.LocalDate;

public class MedicalRecord {
    Location location;
    String treatmentDetails;
    LocalDate dateOfTreatment;

    public MedicalRecord(Location location, String details, LocalDate date) {
        if (details == null || date == null || date.isAfter(LocalDate.now()))
            throw new IllegalArgumentException();
        this.location = location;
        this.treatmentDetails = details;
        this.dateOfTreatment = date;
    }

    public void setDateOfTreatment(LocalDate dateOfTreatment) {

        if (dateOfTreatment == null || dateOfTreatment.isAfter(LocalDate.now()))
            throw new IllegalArgumentException();
        this.dateOfTreatment = dateOfTreatment;
    }

    public void setTreatmentDetails(String treatmentDetails) {

        if (treatmentDetails == null)
            throw new IllegalArgumentException();
        this.treatmentDetails = treatmentDetails;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getTreatmentDetails() {
        return treatmentDetails;
    }

    public LocalDate getDateOfTreatment() {
        return dateOfTreatment;
    }
}
