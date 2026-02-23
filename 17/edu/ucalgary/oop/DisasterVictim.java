package edu.ucalgary.oop;

import java.time.LocalDate;
import java.util.Locale;

public class DisasterVictim {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private FamilyRelation[] familyConnections;
    private MedicalRecord[] medicalRecords;
    private Supply[] personalBelongings;
    private final LocalDate ENTRY_DATE;
    private String gender;
    private String comments;

    public DisasterVictim(String firstName, LocalDate entryDate) {
        if (firstName == null || entryDate == null)
            throw new IllegalArgumentException("First name and entry date cannot be null");

        this.firstName = firstName;
        this.ENTRY_DATE = entryDate;
        this.familyConnections = new FamilyRelation[0];
        this.medicalRecords = new MedicalRecord[0];
        this.personalBelongings = new Supply[0];
    }

    public DisasterVictim(String firstName, LocalDate entryDate, LocalDate dateOfBirth) {
        if (firstName == null || entryDate == null)
            throw new IllegalArgumentException("First name and entry date cannot be null");

        if (dateOfBirth != null && dateOfBirth.isAfter(LocalDate.now()))
            throw new IllegalArgumentException("Date of birth cannot be in the future");

        this.firstName = firstName;
        this.ENTRY_DATE = entryDate;
        this.dateOfBirth = dateOfBirth;
        this.familyConnections = new FamilyRelation[0];
        this.medicalRecords = new MedicalRecord[0];
        this.personalBelongings = new Supply[0];
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null)
            throw new IllegalArgumentException("First name cannot be null");
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null)
            throw new IllegalArgumentException("Last name cannot be null");
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        if (dateOfBirth != null && dateOfBirth.isAfter(LocalDate.now()))
            throw new IllegalArgumentException("Date of birth cannot be in the future");
        this.dateOfBirth = dateOfBirth;
    }

    public FamilyRelation[] getFamilyConnections() {
        return familyConnections;
    }

    public MedicalRecord[] getMedicalRecords() {
        return medicalRecords;
    }

    public Supply[] getPersonalBelongings() {
        return personalBelongings;
    }

    public void setFamilyConnections(FamilyRelation[] connections) {
        if (connections == null)
            throw new IllegalArgumentException("Connections cannot be null");
        this.familyConnections = connections;
    }

    public void setMedicalRecords(MedicalRecord[] records) {
        if (records == null)
            throw new IllegalArgumentException("Records cannot be null");
        this.medicalRecords = records;
    }

    public void setPersonalBelongings(Supply[] supplies) {
        if (supplies == null)
            throw new IllegalArgumentException("Supplies cannot be null");
        this.personalBelongings = supplies;
    }

    public void addPersonalBelonging(Supply belonging) {
        if (belonging == null)
            throw new IllegalArgumentException("Belonging cannot be null");

        for (Supply s : personalBelongings) {
            if (s.equals(belonging))
                throw new IllegalArgumentException("Belonging already exists");
        }

        Supply[] newArray = new Supply[personalBelongings.length + 1];
        System.arraycopy(personalBelongings, 0, newArray, 0, personalBelongings.length);
        newArray[personalBelongings.length] = belonging;
        personalBelongings = newArray;
    }

    public void removePersonalBelonging(Supply belonging) {
        if (belonging == null)
            throw new IllegalArgumentException("Belonging cannot be null");

        int index = -1;

        for (int i = 0; i < personalBelongings.length; i++) {
            if (personalBelongings[i].equals(belonging)) {
                index = i;
                break;
            }
        }

        if (index == -1)
            throw new IllegalArgumentException("Belonging does not exist");

        Supply[] newArray = new Supply[personalBelongings.length - 1];

        for (int i = 0, j = 0; i < personalBelongings.length; i++) {
            if (i != index) {
                newArray[j++] = personalBelongings[i];
            }
        }

        personalBelongings = newArray;
    }

    public void addFamilyConnection(FamilyRelation connection) {
        if (connection == null)
            throw new IllegalArgumentException("Connection cannot be null");

        for (FamilyRelation fr : familyConnections) {
            if (fr.equals(connection))
                throw new IllegalArgumentException("Connection already exists");
        }

        FamilyRelation[] newArray = new FamilyRelation[familyConnections.length + 1];
        System.arraycopy(familyConnections, 0, newArray, 0, familyConnections.length);
        newArray[familyConnections.length] = connection;
        familyConnections = newArray;
    }

    public void removeFamilyConnection(FamilyRelation connection) {
        if (connection == null)
            throw new IllegalArgumentException("Connection cannot be null");

        int index = -1;

        for (int i = 0; i < familyConnections.length; i++) {
            if (familyConnections[i].equals(connection)) {
                index = i;
                break;
            }
        }

        if (index == -1)
            throw new IllegalArgumentException("Connection does not exist");

        FamilyRelation[] newArray = new FamilyRelation[familyConnections.length - 1];

        for (int i = 0, j = 0; i < familyConnections.length; i++) {
            if (i != index) {
                newArray[j++] = familyConnections[i];
            }
        }

        familyConnections = newArray;
    }

    public void addMedicalRecord(MedicalRecord record) {
        if (record == null)
            throw new IllegalArgumentException("Record cannot be null");

        for (MedicalRecord mr : medicalRecords) {
            if (mr.equals(record))
                throw new IllegalArgumentException("Record already exists");
        }

        MedicalRecord[] newArray = new MedicalRecord[medicalRecords.length + 1];
        System.arraycopy(medicalRecords, 0, newArray, 0, medicalRecords.length);
        newArray[medicalRecords.length] = record;
        medicalRecords = newArray;
    }

    public LocalDate getEntryDate() {
        return ENTRY_DATE;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender == null) {
            throw new IllegalArgumentException("Gender cannot be null");
        }

        if (this.gender != null && this.gender.toLowerCase(Locale.ROOT).equals("please specify")) {
            this.gender = gender;
            return;
        }
        String tempString = gender.trim().toLowerCase(Locale.ROOT);
        tempString = Character.toUpperCase(tempString.charAt(0)) + tempString.substring(1);
        if ((!tempString.equals("Man") && !tempString.equals("Woman") && !tempString.equals("Girl") && !tempString.equals("Boy") && !tempString.toLowerCase(Locale.ROOT).equals("please specify"))) {
            throw new IllegalArgumentException("Gender Must Be Of Listed Type");
        }
        if (((tempString.equals("Girl") || tempString.equals("Boy")) && !this.getDateOfBirth().isAfter(LocalDate.now().minusYears(18))) || ((tempString.equals("Man") || tempString.equals("Woman")) && this.getDateOfBirth().isAfter(LocalDate.now().minusYears(18)))) {
            System.out.println(this.getDateOfBirth().isAfter(LocalDate.now().minusYears(18)));
            throw new IllegalArgumentException("Not A child OR not An Adult");
        }
        this.gender = tempString;
    }
}
