import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDate;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Testing {
    void assertIllegalArgs(Runnable call) {
        assertThrows(IllegalArgumentException.class, call::run);
    }
    <T>void assertGetterSetter(T value, Consumer<T> setter, Supplier<T> getter) {
        setter.accept(value);
        assertEquals(getter.get(),value);
    }

    class InitClass{
        Inquirer inquirer = new Inquirer("First Name", "Last Name", "Phone", "Info");
        DisasterVictim disasterVictim1 = new DisasterVictim("First Name", LocalDate.now());
        DisasterVictim disasterVictim2 = new DisasterVictim("First Name 2", LocalDate.now());
        FamilyRelation familyRelation = new FamilyRelation(disasterVictim1, "Relation To", disasterVictim2);
        Location location = new Location("Location Name", "Location Address");
        ReliefServices reliefServices = new ReliefServices(inquirer, disasterVictim1, LocalDate.now(), "Provided Info", location);
        Supply supply = new Supply("Type", 100);
        MedicalRecord medicalRecord = new MedicalRecord(location, "Treatment Details", LocalDate.now());
    }
    InitClass dummyData = new InitClass();

    @Test
    public void illegalArgsTest(){
        //Person Test
        assertIllegalArgs(() ->dummyData.disasterVictim1.setDateOfBirth(null));
        assertIllegalArgs(() ->dummyData.disasterVictim1.setDateOfBirth(LocalDate.now().plusDays(1)));

        assertIllegalArgs(() ->dummyData.disasterVictim1.addPersonalBelongings(null));
        dummyData.disasterVictim1.addPersonalBelongings(dummyData.supply);
        assertIllegalArgs(() ->dummyData.disasterVictim1.addPersonalBelongings(dummyData.supply));
        assertIllegalArgs(() ->dummyData.disasterVictim1.removePersonalBelongings(null));
        dummyData.disasterVictim1.removePersonalBelongings(dummyData.supply);
        assertIllegalArgs(() ->dummyData.disasterVictim1.removePersonalBelongings(dummyData.supply));

        assertIllegalArgs(() ->dummyData.disasterVictim1.addFamilyConnection(null));
        dummyData.disasterVictim1.addFamilyConnection(dummyData.familyRelation);
        assertIllegalArgs(() ->dummyData.disasterVictim1.addFamilyConnection(dummyData.familyRelation));
        assertIllegalArgs(() ->dummyData.disasterVictim1.removeFamilyConnection(null));
        dummyData.disasterVictim1.removeFamilyConnection(dummyData.familyRelation);
        assertIllegalArgs(() ->dummyData.disasterVictim1.removeFamilyConnection(dummyData.familyRelation));

        assertIllegalArgs(() ->dummyData.disasterVictim1.addMedicalRecord(null));
        dummyData.disasterVictim1.addMedicalRecord(dummyData.medicalRecord);
        assertIllegalArgs(() ->dummyData.disasterVictim1.addMedicalRecord(dummyData.medicalRecord));
        assertIllegalArgs(() ->dummyData.disasterVictim1.removeMedicalRecord(null));
        dummyData.disasterVictim1.removeMedicalRecord(dummyData.medicalRecord);
        assertIllegalArgs(() ->dummyData.disasterVictim1.removeMedicalRecord(dummyData.medicalRecord));

        assertIllegalArgs(() ->dummyData.disasterVictim1.setGender(null));
        //Family Relation
        assertIllegalArgs(() ->new FamilyRelation(dummyData.disasterVictim1,"Relation",null));
        assertIllegalArgs(() ->new FamilyRelation(null,"Relation",dummyData.disasterVictim2));
        //assertIllegalArgs(new FamilyRelation(dummyData.disasterVictim1,null,dummyData.disasterVictim2)); //Should Have A null Check?
        assertIllegalArgs(() ->dummyData.familyRelation.setPersonOne(null));
        assertIllegalArgs(() ->dummyData.familyRelation.setPersonTwo(null));
        //Relief Service
        assertIllegalArgs(() ->dummyData.reliefServices.setDateOfInquiry(LocalDate.now().plusDays(1)));
        assertIllegalArgs(() ->dummyData.reliefServices.setDateOfInquiry(null));
        //Supplies
        assertIllegalArgs(() ->new Supply("Type 1",-1));
        assertIllegalArgs(() ->dummyData.supply.setQuantity(-1));
        //Location
        assertIllegalArgs(() ->dummyData.location.addOccupant(null));
        dummyData.location.addOccupant(dummyData.disasterVictim1);
        assertIllegalArgs(() ->dummyData.location.addOccupant(dummyData.disasterVictim1));
        assertIllegalArgs(() ->dummyData.location.removeOccupant(null));
        dummyData.location.removeOccupant(dummyData.disasterVictim1);
        assertIllegalArgs(() ->dummyData.location.removeOccupant(dummyData.disasterVictim1));

        assertIllegalArgs(() ->dummyData.location.addSupply(null));
        dummyData.location.addSupply(dummyData.supply);
        assertIllegalArgs(() ->dummyData.location.addSupply(dummyData.supply));
        assertIllegalArgs(() ->dummyData.location.removeSupply(null));
        dummyData.location.removeSupply(dummyData.supply);
        assertIllegalArgs(() ->dummyData.location.removeSupply(dummyData.supply));
        //Medical Records
        assertIllegalArgs(() ->new MedicalRecord(dummyData.location,"Details",LocalDate.now().plusDays(1)));
        assertIllegalArgs(() ->new MedicalRecord(dummyData.location,"Detail",null));
        assertIllegalArgs(() ->new MedicalRecord(dummyData.location,null,LocalDate.now().plusDays(1)));
    }
    @Test
    public void setterGetterTest(){
        assertGetterSetter("First Name",dummyData.disasterVictim1::setFirstName,() ->dummyData.disasterVictim1.getFirstName());
        assertGetterSetter("Last Name",dummyData.disasterVictim1::setLastName,() ->dummyData.disasterVictim1.getLastName());
        assertGetterSetter(LocalDate.now(),dummyData.disasterVictim1::setDateOfBirth,() ->dummyData.disasterVictim1.getDateOfBirth());
    }
}
