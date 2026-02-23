package edu.ucalgary.oop;

public class Location {

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
