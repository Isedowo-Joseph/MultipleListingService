package main.java;

import java.util.Date;
import java.util.UUID;

public class Storage extends RealEstate {
    private int unitNumber;

    public Storage(String listPrice, Date listDate, String listDescription, String listStatus, UUID mlsId, Broker broker, SalesPerson salesPerson, Date closingDate, Boolean isListable, UUID id,Date soldDate,String soldPrice,String virtualTour) {
        super(listPrice, listDate, listDescription, listStatus, mlsId, broker, salesPerson, closingDate, isListable, id,soldDate,soldPrice,virtualTour);
        this.unitNumber = this.hashCode();
    }
    @Override
    public String toString(){
        StringBuffer sB = new StringBuffer();
        sB.append(super.toString());
        sB.append("unitNumber: " + this.getUnitNumber() + "\n");
        String res = sB.toString();
        return res;
    }
    @Override
    public boolean equals(RealEstate o) {
        boolean eq = true;
        if(super.equals(o)){
            Storage object = (Storage) o;
            eq = this.unitNumber == object.getUnitNumber();
            return eq;
        }
        return false;
    }

    public int getUnitNumber() {
        return this.unitNumber;
    }
}