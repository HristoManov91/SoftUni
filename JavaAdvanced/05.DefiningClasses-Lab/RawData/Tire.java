package RawData;

import java.util.LinkedHashMap;
import java.util.Map;

public class Tire {
    private Map<Double , Integer> tireInfo;

    public Tire (Map<Double , Integer> tireInfo){
        this.tireInfo = tireInfo;
//                addElements(tireOnePressure , tireOneAge , tireTwoPressure , tireTwoAge ,
//                tireThirdPressure , tireThirdAge , tireFourPressure , tireFourAge);
    }

//    private Map<Double , Integer> addElements
//            (double tireOnePressure , int tireOneAge , double tireTwoPressure , int tireTwoAge ,
//             double tireThirdPressure , int tireThirdAge , double tireFourPressure , int tireFourAge) {
//        Map<Double , Integer> data = new LinkedHashMap<>();
//        tireInfo.put(tireOnePressure , tireOneAge);
//        tireInfo.put(tireTwoPressure , tireTwoAge);
//        tireInfo.put(tireThirdPressure , tireThirdAge);
//        tireInfo.put(tireFourPressure , tireFourAge);
//        return data;
//    }

    public Map<Double, Integer> getTireInfo() {
        return tireInfo;
    }

    public double averagePressure (){
         return this.tireInfo.keySet().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
    }
}
