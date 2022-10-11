package main.Test;

import main.java.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class A3Test {
    @Test
    public void Test1() {
        Singleton si = Singleton.getInstance();
        ArrayList<RealEstate> expected = new ArrayList<>();
        SalesPerson salesPerson = new SalesPerson("john doe","222-342-5424","john@gmail.com");
        Broker broker = new Broker("Gary flake","CENTURY 21 SPECIAL","323-324-7567","Gary@gmail.com");
        ArrayList<String> l2 = new ArrayList<>();
        l2.add("hasattic");
        l2.add("haspatio");
        l2.add("hasbarbequearea");
        Structure home1 = new Structure.Builder("Smith").baths(2).additionalInformation(l2).buildingStyle("detached").exteriorType("brick").beds(3).isListable(true, new SalesPerson("sa","231-231-4234","Smith@gmail.com") , null,null, null, 350000,null,null,null,null, null).build();

        ArrayList<String> additioninfo = new ArrayList<>();
        additioninfo.add("hasattic");
        additioninfo.add("haspatio");
        additioninfo.add("hasbarbequearea");
        Structure home2 = new Structure.Builder("joe").isMovable(false).lotSize("100 x 120").heatingType("gas").location("2734 arcut ave").builtYear(2005).propertyType("detached").isMovable(false).baths(2).beds(3).isListable(true, salesPerson ,broker,new Date(121,6,21), "This house has a wonder backyard",343000,"avaliable",null,null,"http://arata.com/virtualtour", new Date(121,7,12)).build();
        expected.add(home1);
        expected.add(home2);
        assertEquals(expected,si.mlsRead());
        System.out.println(si.mlsRead());
        si.Clear();
    }
    @Test
    public void Test2(){
        Singleton si = Singleton.getInstance();
       Boolean expected = false;
        SalesPerson salesPerson = new SalesPerson("john doe","222-342-5424","john@gmail.com");
        Broker broker = new Broker("Gary flake","CENTURY 21 SPECIAL","323-324-7567","Gary@gmail.com");
        ArrayList<String> l2 = new ArrayList<>();
        l2.add("hasattic");
        l2.add("haspatio");
        l2.add("hasbarbequearea");
        Structure home1 = new Structure.Builder("Smith").baths(2).additionalInformation(l2).buildingStyle("detached").exteriorType("brick").beds(3).isListable(true, new SalesPerson("sa","231-231-4234","Smith@gmail.com") , null,null, null, 232000,null,null,null,null, null).build();
        ArrayList<String> additioninfo = new ArrayList<>();
        additioninfo.add("hasattic");
        additioninfo.add("haspatio");
        additioninfo.add("hasbarbequearea");
        Structure home2 = new Structure.Builder("joe").isMovable(false).lotSize("100 x 120").heatingType("gas").location("2734 arcut ave").builtYear(2005).propertyType("detached").isMovable(false).baths(2).beds(3).isListable(true, salesPerson ,broker,new Date(121,6,21), "This house has a wonder backyard",324000,"avaliable",null,null,"http://arata.com/virtualtour", new Date(121,7,12)).build();
        assertEquals(expected,si.mlsGet(home1.getMlsId()).equals(home2));
        si.Clear();
    }
    @Test
    public void Test3(){
        ArrayList<RealEstate> expected = new ArrayList<>();
        Singleton si = Singleton.getInstance();
        SalesPerson salesPerson = new SalesPerson("john doe","222-342-5424","john@gmail.com");
        Broker broker = new Broker("Gary flake","CENTURY 21 SPECIAL","323-324-7567","Gary@gmail.com");
        ArrayList<String> l2 = new ArrayList<>();
        l2.add("hasattic");
        l2.add("haspatio");
        l2.add("hasbarbequearea");
        Structure home1 = new Structure.Builder("Smith").baths(2).additionalInformation(l2).buildingStyle("detached").exteriorType("brick").beds(3).isListable(true, new SalesPerson("sa","231-231-4234","Smith@gmail.com") , null,null, null, 400000,null,null,null,null, null).build();

        ArrayList<String> additioninfo = new ArrayList<>();
        additioninfo.add("hasattic");
        additioninfo.add("haspatio");
        additioninfo.add("hasbarbequearea");
        Structure home2 = new Structure.Builder("joe").isMovable(false).lotSize("100 x 120").heatingType("gas").location("2734 arcut ave").builtYear(2005).propertyType("detached").isMovable(false).baths(2).beds(3).isListable(true, salesPerson ,broker,new Date(121,6,21), "This house has a wonder backyard",560000,"avaliable",null,null,"http://arata.com/virtualtour", new Date(121,7,12)).build();
        expected.add(home2);
        si.mlsDelete(home1.getMlsId());
        assertEquals(expected,si.mlsRead());
        si.Clear();
    }
    @Test
    public void Test4(){
        Singleton si = Singleton.getInstance();
        ArrayList<RealEstate> expected = new ArrayList<>();
        SalesPerson salesPerson = new SalesPerson("john doe","222-342-5424","john@gmail.com");
        Broker broker = new Broker("Gary flake","CENTURY 21 SPECIAL","323-324-7567","Gary@gmail.com");
        ArrayList<String> l2 = new ArrayList<>();
        l2.add("hasattic");
        l2.add("haspatio");
        l2.add("hasbarbequearea");
        Structure home1 = new Structure.Builder("Smith").baths(2).additionalInformation(l2).buildingStyle("detached").exteriorType("brick").beds(3).isListable(true, new SalesPerson("sa","231-231-4234","Smith@gmail.com") , null,null, null, 535000,null,null,null,null, null).build();

        ArrayList<String> additioninfo = new ArrayList<>();
        additioninfo.add("hasattic");
        additioninfo.add("haspatio");
        additioninfo.add("hasbarbequearea");
        Structure home2 = new Structure.Builder("joe").isMovable(false).lotSize("100 x 120").heatingType("gas").location("2734 arcut ave").builtYear(2005).propertyType("detached").isMovable(false).baths(2).beds(3).isListable(true, salesPerson ,broker,new Date(121,6,21), "This house has a wonder backyard",563000,"avaliable",null,null,"http://arata.com/virtualtour", new Date(121,7,12)).build();
        expected.add(home1);
        si.mlsDelete(home2.getMlsId());
        assertEquals(expected,si.mlsRead());
        si.mlsUpdate(home2.getMlsId(),home2);
        expected.add(home2);
        assertEquals(expected,si.mlsRead());
        si.Clear();

    }
    @Test
    public void Test5(){
        Singleton si = Singleton.getInstance();
        Boolean expected = true;
        SalesPerson salesPerson = new SalesPerson("john doe","222-342-5424","john@gmail.com");
        Broker broker = new Broker("Gary flake","CENTURY 21 SPECIAL","323-324-7567","Gary@gmail.com");
        ArrayList<String> l2 = new ArrayList<>();
        l2.add("hasattic");
        l2.add("haspatio");
        l2.add("hasbarbequearea");
        Structure home1 = new Structure.Builder("Smith").baths(2).additionalInformation(l2).buildingStyle("detached").exteriorType("brick").beds(3).isListable(true, new SalesPerson("sa","231-231-4234","Smith@gmail.com") , null,null, null, 756000,null,null,null,null, null).build();
        ArrayList<String> additioninfo = new ArrayList<>();
        additioninfo.add("hasattic");
        additioninfo.add("haspatio");
        additioninfo.add("hasbarbequearea");
        Structure home2 = new Structure.Builder("joe").isMovable(false).lotSize("100 x 120").heatingType("gas").location("2734 arcut ave").builtYear(2005).propertyType("detached").isMovable(false).baths(2).beds(3).isListable(true, salesPerson ,broker,new Date(121,6,21), "This house has a wonder backyard",453000,"avaliable",null,null,"http://arata.com/virtualtour", new Date(121,7,12)).build();
        assertEquals(expected,si.mlsGet(home1.getMlsId()).equals(home1));
        si.Clear();
    }


}