package ca.joseph.a2;

import java.util.UUID;
/**
 *  Overly Simplified Multiple Listing Service Record Each MLS record contains a universally unique id and,
 *  the address and the price of the real estate property.
 */
public class MultipleListingService {
    private UUID id;
    private String address;
    private int price;

    /**
     * to instantiate the class MultipleListingService.
     */
    public MultipleListingService(){

    }

    /**
     * Get the ID of the property.
     * @return the UUID of the property.
     */
    public UUID getId() {
        return this.id;
    }

    /**
     * Get the address of the property.
     * @return the address of the property.
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Get the price of the property.
     * @return the price of the property.
     */
    public int getPrice() {
        return this.price;
    }

    /**
     * Set the price of the property.
     * @param price of the property.
     */
    public void setId(int price){
        this.price = price;
    }

    /**
     * Set the address of the property.
     * @param address of the property.
     */
    public void setAddress(String address){
        this.address = address;
    }

    /**
     * Set the price of the property.
     * @param price of the property.
     */
    public void setPrice(int price){
        this.price = price;
    }

    /**
     * Builder design pattern to facilitate construction of an MLS record.
     */
    public static class Builder {
        private UUID id;
        private String address;
        private int price;

        /**
         *to instantiate the Builder class and give it a unique id.
         * @param id to set the id of the property.
         */
        public Builder(UUID id){
            this.id = id;
        }

        /**
         *to get the address of the listing.
         * @param address of the property.
         * @return the Builder object.
         */
        public Builder locatedAt(String address){
            this.address = address;
            return this;
        }

        /**
         *to get the price of the listing.
         * @param price of the property.
         * @return the Builder object.
         */
        public Builder pricedAt(int price){
            this.price = price;
            return this;
        }

        /**
         *to create an object that contains a listing's
         * id,address and price.
         * @return MultipleListingService object.
         */
        public MultipleListingService build(){
            MultipleListingService mls = new MultipleListingService();
            mls.id = this.id;
            mls.price = this.price;
            mls.address = this.address;
            return mls;
        }
    }
}