package main.java;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public abstract class RealEstate implements Listable {
    private String listPrice;
    private Date listDate;
    private String listDescription;
    private String listStatus;
    private final UUID mlsId;//number associated to the property in market
    private Broker broker;
    private SalesPerson salesPerson;
    private Date closingDate;
    private Boolean isListable;
    private UUID id;
    private Date soldDate;
    private String soldPrice;
    private String virtualTour;


    public RealEstate(String listPrice, Date listDate, String listDescription, String listStatus, UUID mlsId, Broker broker, SalesPerson salesPerson,Date closingDate,Boolean isListable,UUID id,Date soldDate,String soldPrice,String virtualTour) {
        this.listPrice = listPrice;
        this.listDate = listDate;
        this.listDescription = listDescription;
        this.listStatus = listStatus;
        this.mlsId = mlsId;
        this.broker = broker;
        this.salesPerson = salesPerson;
        this.closingDate = closingDate;
        this.isListable = isListable;
        this.id = id;
        this.soldDate = soldDate;
        this.soldPrice = soldPrice;
        this.virtualTour = virtualTour;
    }

    public UUID getMlsId() {
        return mlsId;
    }
    public UUID getId(){
        return this.id;
    }
    @Override
    public Boolean getIsListable(){
        return this.isListable;
    }
    @Override
    public Boolean setIsListable(){
        return this.isListable;
    }

    @Override
    public String toString(){
        StringBuffer b = new StringBuffer();
        b.append("RealEstate: \n" + "listDescription: " + this.listDescription + "\n");
        b.append("listPrice: " + this.listPrice + "\n");
        b.append("listDate: " + this.listDate + "\n");
        b.append("listStatus: " + this.listStatus + "\n");
        b.append("mlsId: " + this.mlsId + "\n");
        b.append(this.broker + "\n");
        b.append(this.salesPerson + "\n");
        b.append("closingDate: " + this.closingDate + "\n");
        b.append("isListable: " + this.isListable + "\n");
        b.append("id: " + this.id + "\n");
        b.append("soldDate: " + this.soldDate + "\n");
        b.append("SoldPrice: " + this.soldPrice + "\n");
        b.append("virtualTour: " + this.virtualTour + "\n");

        return b.toString();
    }

    public boolean equals(RealEstate o) {
        Boolean check = false;
        if (o != null && this.getClass() == o.getClass()) {
            check = this.listPrice == o.listPrice && this.listDate == o.listDate && this.listStatus == o.listStatus && this.mlsId == o.mlsId && this.broker == o.broker && this.salesPerson == o.salesPerson && this.closingDate == o.closingDate && this.isListable == o.isListable && this.id == o.id && this.soldDate == o.soldDate && this.soldPrice == o.soldPrice && this.virtualTour == o.virtualTour;
            return check;
        }
        return check;
    }

}
