import java.util.*;
@FunctionalInterface
interface MyFunctionalInterface {
    int add(int i, int j);
}

public class SAM {
    public static void main(String[] args) {
        MyFunctionalInterface myFunctionalInterface = (i,j) ->i+j;
      int r=  myFunctionalInterface.add(2,3); 
        System.out.println(r);
       


        Map<String,Integer> map = new TreeMap<>();
        map.put("A",56);
        map.put("B",2);
        map.put("C",3);
        map.put("D",4);
        map.put("E",5);
        map.put("F",6);
        map.put("G",7);
        map.put("H",8);

        System.out.println(map);
        System.out.println(map.keySet());

    }
}
