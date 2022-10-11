package main.java;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

public final class Land extends RealEstate {
    private HashMap<UUID,Land> storage;

    public Land(String listPrice, Date listDate, String listDescription, String listStatus, UUID mlsId, Broker broker, SalesPerson salesPerson, Date closingDate, Boolean isListable, UUID id, Date soldDate, String soldPrice, String virtualTour) {
        super(listPrice, listDate, listDescription, listStatus, mlsId, broker, salesPerson, closingDate, isListable, id,soldDate,soldPrice,virtualTour);
    }
    @Override
    public String toString(){
        StringBuffer sB = new StringBuffer();
        sB.append(super.toString());
        sB.append("Lands: " + this.storage.values().stream().toList());
        String res = sB.toString();
        return res;
    }
    @Override
    public boolean equals(RealEstate o) {
        boolean eq = true;
        if(super.equals(o)){
            Land object = (Land) o;
            eq = this.storage.equals(object.storage);
            return eq;
        }
        return false;
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

        public Builder(Boolean iL){
            this.isListable = iL;
        }
        public Builder setBuilder(Broker b,SalesPerson sP,Date soldDate, Date listDate,String listDescription,int listPrice,String listStatus,String soldPrice,Date closingDate,String virtualTour){
            if (this.isListable == true) {
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
        public Land build(){
            Land obj = new Land(this.listPrice, this.listDate, this.listDescription, this.listStatus, this.mlsId, this.broker, this.salesPerson, this.closingDate, this.isListable, this.id,this.soldDate,this.soldPrice,this.virtualTour);
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
