package edu.ucalgary.oop;
public class Supply {
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

