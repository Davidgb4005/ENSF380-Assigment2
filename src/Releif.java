import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class Inquirer {
    final private String FIRST_NAME,LAST_NAME,INFO,SERVICES_PHONE;

    public Inquirer(String firstName, String lastName, String phone, String info) {
        this.FIRST_NAME = firstName;
        this.LAST_NAME = lastName;
        this.SERVICES_PHONE= phone;
        this.INFO = info;
    }
    public String getFirstName(){
        return (FIRST_NAME);
    }
    public String getLastName(){
        return (LAST_NAME);
    }
    public String getServicesPhoneNum(){
        return (SERVICES_PHONE);
    }
    public String getInfo(){
        return (INFO);
    }
}


class DisasterVictim {

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

    public String getGender(){
        return gender;
    }

    public void setGender(String gender) {
        if (gender == null){
            throw new IllegalArgumentException("Gender cannot be null");
        }

        if (this.gender != null && this.gender.toLowerCase(Locale.ROOT).equals("please specify")){
            this.gender = gender;
            return;
        }
        String tempString = gender.trim().toLowerCase(Locale.ROOT);
        tempString = Character.toUpperCase(tempString.charAt(0))  + tempString.substring(1);
        if ((!tempString.equals("Man") && !tempString.equals("Woman") && !tempString.equals("Girl") && !tempString.equals("Boy") && !tempString.toLowerCase(Locale.ROOT).equals("please specify"))) {
            throw new IllegalArgumentException("Gender Must Be Of Listed Type");
        }
        if (((tempString.equals("Girl")  || tempString.equals("Boy")) && !this.getDateOfBirth().isAfter(LocalDate.now().minusYears(18))) || ((tempString.equals("Man")  || tempString.equals("Woman")) && this.getDateOfBirth().isAfter(LocalDate.now().minusYears(18))))  {
            System.out.println(this.getDateOfBirth().isAfter(LocalDate.now().minusYears(18)));
            throw new IllegalArgumentException("Not A child OR not An Adult");
        }
        this.gender = tempString;
    }
}

class FamilyRelation {

    private DisasterVictim personOne;
    private String relationshipTo;
    private DisasterVictim personTwo;

    public FamilyRelation(DisasterVictim personOne, String relationshipTo, DisasterVictim personTwo) {
        if (personOne == null || personTwo == null)
            throw new IllegalArgumentException("Persons cannot be null");

        if (relationshipTo == null)
            throw new IllegalArgumentException("Relationship cannot be null");

        this.personOne = personOne;
        this.relationshipTo = relationshipTo;
        this.personTwo = personTwo;
    }

    public DisasterVictim getPersonOne() {
        return personOne;
    }

    public void setPersonOne(DisasterVictim personOne) {
        if (personOne == null)
            throw new IllegalArgumentException("Person cannot be null");

        this.personOne = personOne;
    }

    public String getRelationshipTo() {
        return relationshipTo;
    }

    public void setRelationshipTo(String relationshipTo) {
        if (relationshipTo == null)
            throw new IllegalArgumentException("Relationship cannot be null");

        this.relationshipTo = relationshipTo;
    }

    public DisasterVictim getPersonTwo() {
        return personTwo;
    }

    public void setPersonTwo(DisasterVictim personTwo) {
        if (personTwo == null)
            throw new IllegalArgumentException("Person cannot be null");

        this.personTwo = personTwo;
    }
}

class Location {

    private String name;
    private String address;
    private DisasterVictim[] occupants;
    private Supply[] supplies;

    public Location(String locationName, String address) {
        this.name = locationName;
        this.address = address;
        this.occupants = new DisasterVictim[0];
        this.supplies = new Supply[0];
    }

    public String getName() {
        return name;
    }

    public void setName(String locationName) {
        if (locationName == null)
            throw new IllegalArgumentException("Name cannot be null");
        this.name = locationName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null)
            throw new IllegalArgumentException("Address cannot be null");
        this.address = address;
    }

    public DisasterVictim[] getOccupants() {
        return occupants;
    }

    public void setOccupants(DisasterVictim[] occupants) {
        if (occupants == null)
            throw new IllegalArgumentException("Occupants array cannot be null");
        this.occupants = occupants;
    }

    public Supply[] getSupplies() {
        return supplies;
    }

    public void setSupplies(Supply[] inventory) {
        if (inventory == null)
            throw new IllegalArgumentException("Supplies array cannot be null");
        this.supplies = inventory;
    }

    public void addOccupant(DisasterVictim occupent) {
        if (occupent == null)
            throw new IllegalArgumentException("Occupant cannot be null");

        for (DisasterVictim dv : occupants) {
            if (dv.equals(occupent))
                throw new IllegalArgumentException("Occupant already exists");
        }

        DisasterVictim[] newArray = new DisasterVictim[occupants.length + 1];
        System.arraycopy(occupants, 0, newArray, 0, occupants.length);
        newArray[occupants.length] = occupent;
        occupants = newArray;
    }

    public void removeOccupant(DisasterVictim occupent) {
        if (occupent == null)
            throw new IllegalArgumentException("Occupant cannot be null");

        int index = -1;

        for (int i = 0; i < occupants.length; i++) {
            if (occupants[i].equals(occupent)) {
                index = i;
                break;
            }
        }

        if (index == -1)
            throw new IllegalArgumentException("Occupant does not exist");

        DisasterVictim[] newArray = new DisasterVictim[occupants.length - 1];

        for (int i = 0, j = 0; i < occupants.length; i++) {
            if (i != index) {
                newArray[j++] = occupants[i];
            }
        }

        occupants = newArray;
    }

    public void addSupply(Supply inventory) {
        if (inventory == null)
            throw new IllegalArgumentException("Supply cannot be null");

        for (Supply s : supplies) {
            if (s.equals(inventory))
                throw new IllegalArgumentException("Supply already exists");
        }

        Supply[] newArray = new Supply[supplies.length + 1];
        System.arraycopy(supplies, 0, newArray, 0, supplies.length);
        newArray[supplies.length] = inventory;
        supplies = newArray;
    }

    public void removeSupply(Supply inventory) {
        if (inventory == null)
            throw new IllegalArgumentException("Supply cannot be null");

        int index = -1;

        for (int i = 0; i < supplies.length; i++) {
            if (supplies[i].equals(inventory)) {
                index = i;
                break;
            }
        }

        if (index == -1)
            throw new IllegalArgumentException("Supply does not exist");

        Supply[] newArray = new Supply[supplies.length - 1];

        for (int i = 0, j = 0; i < supplies.length; i++) {
            if (i != index) {
                newArray[j++] = supplies[i];
            }
        }

        supplies = newArray;
    }
}


class ReliefService {
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
    public Inquirer getInquirer(){
        return (inquirer);
    }
    public void setInquirer(Inquirer inquirer){
        this.inquirer = inquirer;
    }
    public DisasterVictim getMissingPerson(){
        return (missingPerson);
    }
    public void setMissingPerson(DisasterVictim missingPerson){
        this.missingPerson = missingPerson;
    }
    public LocalDate getDateOfInquiry(){
        return dateOfInquiry;
    }
    public String getInfoProvided(){
        return infoProvided;
    }
    public void setInfoProvided(String info){
        this.infoProvided = info;
    }
    public Location getLastKnownLocation(){
        return lastKnownLocation;
    }
    public void setLastKnownLocation(Location lastLocation){
        this.lastKnownLocation = lastLocation;
    }
    public String getLogDetails(){
        return null;
    }
}

class Supply {
    String type;
    int quantity;

    public Supply(String type, int quantity) {
        if (quantity < 0) throw new IllegalArgumentException();
        this.type = type;
        this.quantity = quantity;
    }

    public void setQuantity(int q) {
        if (q < 0) throw new IllegalArgumentException();
        this.quantity = q;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return type;
    }
    public int getQuantity(){
        return quantity;
    }
}

class MedicalRecord {
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
    public void setDateOfTreatment(LocalDate dateOfTreatment){

        if (dateOfTreatment == null || dateOfTreatment.isAfter(LocalDate.now()))
            throw new IllegalArgumentException();
        this.dateOfTreatment = dateOfTreatment;
    }
    public void setTreatmentDetails(String treatmentDetails){

        if (treatmentDetails == null)
            throw new IllegalArgumentException();
        this.treatmentDetails = treatmentDetails;
    }
    public Location getLocation(){
        return location;
    }
    public void setLocation(Location location){
        this.location = location;
    }
    public String getTreatmentDetails(){
        return treatmentDetails;
    }
    public LocalDate getDateOfTreatment(){
        return dateOfTreatment;
    }
}
