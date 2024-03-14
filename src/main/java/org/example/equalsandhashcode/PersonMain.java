package org.example.equalsandhashcode;

import java.util.HashMap;
import java.util.Map;

public class PersonMain {

    public static void main(String... args){
        Map<PersonV1, Integer> personsV1Map = new HashMap();
        PersonV1 personV1 = new PersonV1(2);
        personsV1Map.put(personV1, 4);
        personV1.setId(1);// this change does not affect the key into the map because we can not mutate
        //a key into a map
        personsV1Map.put(personV1, 5);
        personV1.setId(0);

        System.out.println(personsV1Map);
        System.out.println(personsV1Map.size());
        System.out.println(personsV1Map.get(personV1));
    }
}
