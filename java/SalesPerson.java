package main.java;

public class SalesPerson {
    private String name;
    private String phoneNumber;
    private String email;

    public SalesPerson(String name, String phoneNumber, String email){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;

    }

    public SalesPerson(SalesPerson sP) {
        this.name = sP.name;
        this.phoneNumber = sP.phoneNumber;
        this.email = sP.email;
    }

    @Override
    public String toString(){
        String s = "SalesPerson name: " + this.name + "\n" +
                   "SalesPerson phoneNumber: " + this.phoneNumber + "\n" +
                   "SalesPerson email: " + this.email;
        return s;
    }

}
