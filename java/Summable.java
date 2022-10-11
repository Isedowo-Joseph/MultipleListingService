package main.java;
import java.util.ArrayList;
import java.util.Date;

public interface Summable {
    public Enum getPropertyType();
    public int getBuiltYear();
    public String getOwner();
    public ArrayList<AdditionalInfo> getAdditionalInformation();
    public Style  getBuildingStyle();
    public String getLocation();
}
