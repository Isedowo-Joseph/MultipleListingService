package main.java;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;


public final class Locker extends Storage{
    private Enum size;
    private HashMap<UUID, Locker> storage;

    public Locker(String listPrice,Date listDate, String listDescription, String listStatus, UUID mlsId, Enum size, Broker broker, SalesPerson salesPerson,Date closingDate,Boolean isListable,UUID id,Date soldDate,String soldPrice,String virtualTour) {
        super(listPrice, listDate, listDescription, listStatus, mlsId, broker, salesPerson, closingDate, isListable, id, soldDate, soldPrice, virtualTour);
        this.setSize(size);
    }
    @Override
    public String toString(){
        StringBuffer sB = new StringBuffer();
        sB.append(super.toString());
        sB.append("lockers: " + this.storage + "\n");
        sB.append("size: " + this.size);
        String res = sB.toString();
        return res;
    }
    @Override
    public boolean equals(RealEstate o) {
        boolean eq = true;
        if(super.equals(o)){
            Locker object = (Locker) o;
            eq = this.storage.equals(object.storage);
            return eq;
        }
        return false;
    }
    public Enum getSize(){
        return this.size;
    }

    private void setSize(Enum s){
        this.size = s;
    }

    public static class Builder{
        private String listPrice;
        private Date listDate;
        private String listDescription;
        private String listStatus;
        private UUID mlsId;
        private Broker broker;
        private SalesPerson salesPerson;
        private Date closingDate;
        private Boolean isListable;
        private UUID id;
        private Date soldDate;
        private String soldPrice;
        private String virtualTour;
        private Enum size;

        public Builder(Boolean iL,String size){
            this.isListable = iL;
            if(size == "small") {
                this.size = Size.SMALL;
            }
            else if(size == "medium"){
                this.size = Size.MEDIUM;
            }
            else if(size == "Large"){
                this.size = Size.LARGE;
            }
            else{
                throw new IllegalArgumentException("Invalid input");
            }
        }
        public Builder setBuilder(Broker b, SalesPerson sP, Date soldDate, Date listDate, String listDescription, int listPrice, String listStatus, String soldPrice, Date closingDate, String virtualTour){
            if (this.isListable) {
                this.salesPerson = sP;
                this.broker = b;
                this.listDate = listDate;
                this.listDescription = listDescription;
                this.listPrice = "$" + listPrice;
                this.listStatus = listStatus;
                this.soldDate = soldDate;
                this.soldPrice = soldPrice;
                this.virtualTour = virtualTour;
                this.closingDate = closingDate;
                this.mlsId = UUID.randomUUID();
            }
            this.id = UUID.randomUUID();
            this.broker = null;
            this.salesPerson = null;
            this.listDate = null;
            this.listDescription = "N/A";
            this.listPrice = "N/A";
            this.listStatus ="N/A" ;
            this.soldDate = null;
            this.soldPrice = null;
            this.virtualTour = "N/A";
            this.closingDate = null;

            return this;
        }
        public Locker build(){
            Locker obj = new Locker(this.listPrice,this.listDate,this.listDescription,this.listStatus,this.mlsId,this.size,this.broker, this.salesPerson,this.closingDate,this.isListable,this.id,this.soldDate,this.soldPrice,this.virtualTour);
            if(this.id != null){
                obj.storage.put(this.id,obj);
            }
            if(this.mlsId != null) {
                Singleton si = Singleton.getInstance();
                si.mlsUpdate(this.mlsId,obj);
            }
            return obj;
        }
    }
}
