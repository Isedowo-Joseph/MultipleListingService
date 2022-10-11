package main.java;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

public final class Structure extends RealEstate implements Buildable,Summable,Movable{
    private int bedrooms;
    private int bathrooms;
    private String heatingType;
    private Enum propertyType;
    private int builtYear;
    private String owner;
    private ArrayList<AdditionalInfo> additionalInformation;
    private String location;
    private String exteriorType;
    private Boolean isMovable;
    private Style buildingStyle;
    private String lotSize;

    private HashMap<UUID,Structure> storage;

    public Structure(String listPrice, Date listDate, String listDescription, String listStatus, UUID mlsId, Broker broker, SalesPerson salesPerson, Date closingDate, Boolean isListable, UUID id, Date soldDate, String soldPrice, String virtualTour) {
        super(listPrice,listDate, listDescription, listStatus, mlsId,broker,salesPerson,closingDate,isListable,id,soldDate,soldPrice,virtualTour);
        storage = new HashMap<>();
    }
    @Override
    public String toString(){
        StringBuffer sB = new StringBuffer();
        sB.append(super.toString());
        sB.append("bedrooms: " + this.bedrooms + "\n");
        sB.append("bathrooms: " + this.bathrooms + "\n");
        sB.append("heatingType: " + this.heatingType + "\n");
        sB.append("propertyType: " + this.propertyType + "\n");
        sB.append("builtYear: " + this.builtYear + "\n");
        sB.append("additionalInformation: " + this.additionalInformation + "\n");
        sB.append("location: " + this.location + "\n");
        sB.append("exteriorType: " + this.exteriorType + "\n");
        sB.append("isMovable: " + this.isMovable + "\n");
        sB.append("buildingStyle: " + this.buildingStyle + "\n");
        sB.append("lotSize: " + this.lotSize + "\n");
        sB.append("Structures: " + this.storage.values().stream().toList() + "\n" + "\n");
        String res = sB.toString();
        return res;
    }
    @Override
    public boolean equals(RealEstate o) {
        boolean eq = true;
        if(super.equals(o)){
            Structure object = (Structure) o;
            eq = this.storage.equals(object.storage);
            return eq;
        }
        return false;
    }
    public String getLotSize() {
        return this.lotSize;
    }

    @Override
    public int getBedrooms() {
        return this.bedrooms;
    }

    @Override
    public int getBathrooms() {
        return this.bathrooms;
    }

    @Override
    public String getHeatingType() {
        return this.heatingType;
    }

    @Override
    public String getExteriorType() {
        return this.exteriorType;
    }

    @Override
    public Enum getPropertyType() {
        return this.propertyType;
    }

    @Override
    public int getBuiltYear() {
        return this.builtYear;
    }

    @Override
    public String getOwner() {
        return this.owner;
    }

    @Override
    public ArrayList<AdditionalInfo> getAdditionalInformation() {
        return this.additionalInformation;
    }
    @Override
    public Style getBuildingStyle() {
        return this.buildingStyle;
    }

    @Override
    public String getLocation() {
        return this.location;
    }

    @Override
    public boolean isMovable() {
        return this.isMovable;
    }
    public HashMap<UUID, Structure> getStorage() {
        return this.storage;
    }

    public static class Builder{
        private int bedrooms;
        private int bathrooms;
        private String heatingType;
        private SalesPerson salesPerson;
        private Broker broker;
        private String listPrice;
        private Date listDate;
        private String listDescription;
        private UUID mlsId;
        private UUID id;
        private String listStatus;
        private Enum propertyType;
        private int builtYear;
        private Date soldDate;
        private String owner;
        private String soldPrice;
        private String virtualTour;
        private ArrayList<AdditionalInfo>  additionalInformation;
        private String location;
        private Date closingDate;
        private String exteriorType;
        private Style buildingStyle;
        private Boolean isMovable;
        private String lotSize;
        private Boolean isListable;

        public Builder(String owner){
            this.owner = owner;
        }
        public Builder exteriorType (String eT){
            this.exteriorType = eT;
            return this;
        }
        public Builder lotSize (String l){
            if(this.isMovable == true){
                this.lotSize = "0";
            }
            else{
                this.lotSize = l;
            }
            this.lotSize = l;
            return this;
        }
        public Builder heatingType(String hT){
            this.heatingType = hT;
            return this;
        }
        public Builder propertyType(String propertyType) {
            if(propertyType == "residential"){
                this.propertyType = PropertyType.RESIDENTIAL;
                return this;
            }
            else if(propertyType == "commercial"){
                this.propertyType = PropertyType.COMMERCIAL;
                return this;
            }
            else if(propertyType == "industrial"){
                this.propertyType = PropertyType.INDUSTRIAL;
                return this;
            }
            return this;
        }
        public Builder beds(int bed){
            this.bedrooms = bed;
            return this;
        }
        public Builder baths(int bath){
            this.bathrooms = bath;
            return this;
        }

        public Builder builtYear(int y) {
            this.builtYear = y;
            return this;
        }

        public Builder location(String l) {
            this.location = l;
            return this;
        }
        public Builder isMovable(Boolean iM){
            this.isMovable = iM;
            return this;
        }
        public Builder isListable(Boolean iL, SalesPerson sP, Broker b, Date listDate, String listDescription, int listPrice, String listStatus, Date soldDate, String soldPrice, String virtualTours, Date closingDate) {
            if (iL == true) {
                this.salesPerson = sP;
                this.broker = b;
                this.isListable = iL;
                this.listDate = listDate;
                this.listDescription = listDescription;
                this.listPrice = "$" + listPrice;
                this.listStatus = listStatus;
                this.soldDate = soldDate;
                this.soldPrice = soldPrice;
                this.virtualTour = virtualTours;
                this.closingDate = closingDate;
                this.mlsId = UUID.randomUUID();
            }
            else {
                this.id = UUID.randomUUID();
                this.broker = null;
                this.salesPerson = null;
                this.listDate = null;
                this.listDescription = "N/A";
                this.listPrice = "N/A";
                this.listStatus = "N/A";
                this.soldDate = null;
                this.soldPrice = null;
                this.virtualTour = "N/A";
                this.closingDate = null;
            }
                return this;
            }

        public Builder additionalInformation(ArrayList<String>  aD) {
            ArrayList<AdditionalInfo> list = new ArrayList<>();
            for (int i = 0; i < aD.size(); i++) {
                if(aD.get(i) == "hasattic"){
                    list.add(AdditionalInfo.HASATTIC);
                }
                else if(aD.get(i) == "hasbarbequearea"){
                    list.add(AdditionalInfo.HASBARBECUEAREA);
                }
                else if(aD.get(i) == "hasbasemenet"){
                    list.add(AdditionalInfo.HASBASEMENT);
                }
                else if(aD.get(i) == "hasceilingfan"){
                    list.add(AdditionalInfo.HASCEILINGFAN);
                }
                else if(aD.get(i) == "hasdeck"){
                    list.add(AdditionalInfo.HASDECK);
                }
                else if(aD.get(i) == "hasdock"){
                    list.add(AdditionalInfo.HASDOCK);
                }
                else if(aD.get(i) == "hasdoorman"){
                    list.add(AdditionalInfo.HASDOORMAN);
                }
                else if(aD.get(i) == "hasdoublepanewindows"){
                    list.add(AdditionalInfo.HASDOUBLEPANEWINDOWS);
                }
                else if(aD.get(i) == "haselevator") {
                    list.add(AdditionalInfo.HASELEVATOR);
                }
                else if(aD.get(i) == "haslawn"){
                    list.add(AdditionalInfo.HASLAWN);
                }
                else if(aD.get(i) == "haspatio"){
                    list.add(AdditionalInfo.HASPATIO);
                }
                else if(aD.get(i) == "haspond"){
                    list.add(AdditionalInfo.HASPOND);
                }
                else if(aD.get(i) == "haspool"){
                    list.add(AdditionalInfo.HASPOOL);
                }
                else if(aD.get(i) == "hasporch"){
                    list.add(AdditionalInfo.HASPORCH);
                }
                else if(aD.get(i) == "hassauna"){
                    list.add(AdditionalInfo.HASSAUNA);
                }
                else if(aD.get(i) == "hassecuritysystem"){
                    list.add(AdditionalInfo.HASSECURITYSYSTEM);
                }
                else if(aD.get(i) == "haswetbar"){
                    list.add(AdditionalInfo.HASWETBAR);
                }
                else if(aD.get(i) == "hasfireplace"){
                    list.add(AdditionalInfo.HASFIREPLACE);
                }
                else if(aD.get(i) == "hasgarden"){
                    list.add(AdditionalInfo.HASGARDEN);
                }
                else if(aD.get(i) == "hasgatedentry"){
                    list.add(AdditionalInfo.HASGATEDENTRY);
                }
                else if(aD.get(i) == "hashottubspa"){
                    list.add(AdditionalInfo.HASHOTTUBSPA);
                }
                else {
                    throw new IllegalArgumentException(aD.get(i) + "is an invalid input");
                }
            }
            this.additionalInformation = list;

            return this;
        }

        public Builder buildingStyle(String  bD){
                if(bD == "agricultural"){
                    this.buildingStyle = Style.AGRICULTURAL;
                }
                else if(bD == "condominium"){
                    this.buildingStyle = Style.CONDOMINIUM;
                }
                else if(bD == "cooperative"){
                    this.buildingStyle = Style.COOPERATIVE;
                }
                else if(bD == "detached"){
                    this.buildingStyle = Style.DETACHED;
                }
                else if(bD == "duplex"){
                    this.buildingStyle = Style.DUPLEX;
                }
                else if(bD == "freehold"){
                    this.buildingStyle = Style.FREEHOLD;
                }
                else if(bD == "multifamily"){
                    this.buildingStyle = Style.MULTIFAMILY;
                }
                else if(bD == "multigenerational"){
                    this.buildingStyle = Style.MULTIGENERATIONAL;
                }
                else if(bD == "newconstruction") {
                    this.buildingStyle = Style.NEWCONSTRUCTION;
                }
                else if(bD == "recreational"){
                    this.buildingStyle = Style.RECREATIONAL;
                }
                else if(bD == "vacation"){
                    this.buildingStyle = Style.VACATION;
                }
                else if(bD == "semidetached"){
                    this.buildingStyle = Style.SEMIDETACHED;
                }
                else if(bD == "stackedtownhouse"){
                    this.buildingStyle = Style.STACKEDTOWNHOUSE;
                }
                else {
                    throw new IllegalArgumentException(bD + "is an invalid input");
                }

            return this;
        }

        public Structure build(){
            Structure building = new Structure(this.listPrice,this.listDate,this.listDescription,this.listStatus,this.mlsId,this.broker,this.salesPerson,this.closingDate,this.isListable,this.id,soldDate,soldPrice,virtualTour);

            building.bedrooms = this.bedrooms;
            building.bathrooms = this.bathrooms;
            building.heatingType = this.heatingType;
            building.propertyType = this.propertyType;
            building.builtYear = this.builtYear;
            building.location = this.location;
            building.owner = this.owner;
            building.exteriorType = this.exteriorType;
            building.additionalInformation = this.additionalInformation;
            building.buildingStyle = this.buildingStyle;
            building.isMovable = this.isMovable;
            building.lotSize = this.lotSize;
            if(this.id != null){
                building.storage.put(this.id,building);
            }
            if(this.mlsId != null) {
                Singleton si = Singleton.getInstance();
                si.mlsUpdate(this.mlsId,building);
            }
            return building;
        }

    }
}

