package org.example.hashequals;

import java.util.HashMap;
import java.util.Map;

public class HashEqualsMain {

    private static Map<Team, String> teamToString(){
        Map<Team, String> map = new HashMap<>();
        map.put(new Team("Tulua","Finances"),"Paola");
        map.put(new Team("Itagui","Systems"),"Julian");
        map.put(new Team("Itagui","marketing"),"Matias");
        return map;
    }

    private static Map<Team2, String> team2ToString(){
        Map<Team2, String> map = new HashMap<>();
        map.put(new Team2("Tulua","Finances"),"Paola");
        map.put(new Team2("Itagui","Systems"),"Julian");
        map.put(new Team2("Itagui","marketing"),"Matias");
        return map;
    }

    private static Map<String, Integer> updateValueTest(){
        Map<String, Integer>  map = new HashMap<>();
        map.put("Paola",40);
        map.put("Julian",36);
        map.put("Matias",4);
        map.put("Julian",37);// its modified
        map.put("Julian",38);// its modified
        return map;
    }

    public static void main(String[] args) {
        Person p1 = new Person("1116","Julian", 36);
        Person p2 = new Person("1116","Julian", 36);
        boolean isSamePerson = p1.equals(p2);
        System.out.println("is false isSamePerson: "+isSamePerson);// is false because the equals needs to be overriden

        Client c1 = new Client("1116","Julian", 36);
        Client c2 = new Client("1116","Julian", 36);
        boolean isSameClient= c1.equals(c2);
        System.out.println("isSameClient: "+isSameClient);// is true because the equals is overriden

        Team myTeam = new Team("Tulua","Finances");
        String myTeamLeader = teamToString().get(myTeam);
        System.out.println("myTeamLeader => "+myTeamLeader);

        Team2 myTeam2 = new Team2("Tulua","Finances");
        String myTeam2Leader = team2ToString().get(myTeam2);
        System.out.println("myTeam2Leader => "+myTeam2Leader);
        team2ToString().put(myTeam2, "OTHER");
        System.out.println("myTeam2Leader => "+team2ToString().get(myTeam2));

        team2ToString().compute(myTeam2, (key, value) -> value+"OTHER" );
        System.out.println("myTeam2Leader => "+team2ToString().get(myTeam2));


        Team2 myTeam3 = new Team2("Tulua","Finances");
        Map<Team2, String> team3Map  = team2ToString();
        System.out.println("team3Map => "+team3Map);
        team3Map.put(myTeam3, "OTHER");
        System.out.println("team3Map changes => "+team3Map);

        Map<String, Integer> map2 = updateValueTest();
        map2.compute("Julian", (s, integer) -> integer+1);
        System.out.println("Note it's modified 0>"+map2);
    }
}
