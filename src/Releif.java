import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Inquirer {
    String firstName, lastName, phone, info;

    public Inquirer(String firstName, String lastName, String phone, String info) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.info = info;
    }
}

class DisasterVictim {
    String  firstName;
    String  lastName;
    LocalDate dob;
    String gender;
    List<Supply> belongings = new ArrayList<>();
    List<MedicalRecord> medicalRecords = new ArrayList<>();
    List<FamilyRelation> familyConnections = new ArrayList<>();

    public DisasterVictim(String firstName, LocalDate dob) {
        this.firstName = firstName;
        this.dob = dob;
    }
    // 1. First Name
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null) throw new IllegalArgumentException("First name cannot be null");
        this.firstName = firstName;
    }

    // 2. Last Name
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null) throw new IllegalArgumentException("Last name cannot be null");
        this.lastName = lastName;
    }

    // 3. Date of Birth
    public LocalDate getDateOfBirth() {
        return this.dob;
    }
    public void setDateOfBirth(LocalDate date) {
        if (date == null || date.isAfter(LocalDate.now()))
            throw new IllegalArgumentException();
        this.dob = date;
    }

    public void setGender(String gender) {
        if (gender == null) throw new IllegalArgumentException();
        this.gender = gender;
    }

    public void addPersonalBelongings(Supply item) {
        if (item == null) throw new IllegalArgumentException();
        if (belongings.contains(item))
            throw new IllegalArgumentException("Belongings already contains this supply");
        belongings.add(item);
    }

    public void removePersonalBelongings(Supply item) {
        if (item == null) throw new IllegalArgumentException();
        if (!belongings.contains(item))
            throw new IllegalArgumentException("Belongings does not contain this supply");
        belongings.remove(item);
    }

    public void addFamilyConnection(FamilyRelation fr) {
        if (fr == null) throw new IllegalArgumentException();
        if (familyConnections.contains(fr))
            throw new IllegalArgumentException("Family connection already exists");
        familyConnections.add(fr);
    }

    public void removeFamilyConnection(FamilyRelation fr) {
        if (fr == null) throw new IllegalArgumentException();
        if (!familyConnections.contains(fr))
            throw new IllegalArgumentException("Family connection does not exist");
        familyConnections.remove(fr);
    }

    public void addMedicalRecord(MedicalRecord mr) {
        if (mr == null) throw new IllegalArgumentException();
        if (medicalRecords.contains(mr))
            throw new IllegalArgumentException("Medical record already exists");
        medicalRecords.add(mr);
    }

    public void removeMedicalRecord(MedicalRecord mr) {
        if (mr == null) throw new IllegalArgumentException();
        if (!medicalRecords.contains(mr))
            throw new IllegalArgumentException("Medical record does not exist");
        medicalRecords.remove(mr);
    }
}

class FamilyRelation {
    DisasterVictim personOne, personTwo;
    String relation;

    public FamilyRelation(DisasterVictim p1, String relation, DisasterVictim p2) {
        if (p1 == null || p2 == null) throw new IllegalArgumentException();
        this.personOne = p1;
        this.personTwo = p2;
        this.relation = relation;
    }

    public void setPersonOne(DisasterVictim p) {
        if (p == null) throw new IllegalArgumentException();
        personOne = p;
    }

    public void setPersonTwo(DisasterVictim p) {
        if (p == null) throw new IllegalArgumentException();
        personTwo = p;
    }
}

class Location {
    String name, address;
    List<DisasterVictim> occupants = new ArrayList<>();
    List<Supply> supplies = new ArrayList<>();

    public Location(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void addOccupant(DisasterVictim dv) {
        if (dv == null) throw new IllegalArgumentException();
        if (occupants.contains(dv))
            throw new IllegalArgumentException("Occupant already exists");
        occupants.add(dv);
    }

    public void removeOccupant(DisasterVictim dv) {
        if (dv == null) throw new IllegalArgumentException();
        if (!occupants.contains(dv))
            throw new IllegalArgumentException("Occupant does not exist");
        occupants.remove(dv);
    }

    public void addSupply(Supply s) {
        if (s == null) throw new IllegalArgumentException();
        if (supplies.contains(s))
            throw new IllegalArgumentException("Supply already exists");
        supplies.add(s);
    }

    public void removeSupply(Supply s) {
        if (s == null) throw new IllegalArgumentException();
        if (!supplies.contains(s))
            throw new IllegalArgumentException("Supply does not exist");
        supplies.remove(s);
    }
}

class ReliefServices {
    Inquirer inquirer;
    DisasterVictim victim;
    LocalDate dateOfInquiry;
    String providedInfo;
    Location location;

    public ReliefServices(Inquirer inquirer, DisasterVictim victim, LocalDate date, String info, Location loc) {
        this.inquirer = inquirer;
        this.victim = victim;
        this.dateOfInquiry = date;
        this.providedInfo = info;
        this.location = loc;
    }

    public void setDateOfInquiry(LocalDate date) {
        if (date == null || date.isAfter(LocalDate.now())) throw new IllegalArgumentException();
        this.dateOfInquiry = date;
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
}

class MedicalRecord {
    Location location;
    String treatmentDetails;
    LocalDate date;

    public MedicalRecord(Location location, String details, LocalDate date) {
        if (location == null || details == null || date == null || date.isAfter(LocalDate.now()))
            throw new IllegalArgumentException();
        this.location = location;
        this.treatmentDetails = details;
        this.date = date;
    }
}
