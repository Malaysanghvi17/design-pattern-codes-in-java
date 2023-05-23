package creational_pattern;

import java.util.ArrayList;

abstract class House implements Cloneable{
   private int Houseid;
   private float HouseArea;
   private float HousePrice;

    public void setHouseid(int houseid) {
        Houseid = houseid;
    }

    public void setHouseArea(float houseArea) {
        HouseArea = houseArea;
    }

    public void setHousePrice(float housePrice) {
        HousePrice = housePrice;
    }

//    private List<String> empList;

    public House(){
//        empList = new ArrayList<String>();
    }
}

class TwoBhk extends House{

}

class ThreeBhk extends House{

}

class SampleHouseRegistry extends House{

}

public class prototype_pattern {
    public static void main(String[] args) {

    }
}

//why use tostring method