package org.example.solid.liskovsubsti;

import java.util.List;

public class MainLS {

    private static void printConcept(ClinicalConcept clinicalConcept){
        System.out.println(clinicalConcept);
    }

    private static void printConcepts(List<ClinicalConcept> clinicalConcepts){
        clinicalConcepts.stream().forEach(System.out::println);
    }


    public static void main(String[] args) {
        ClinicalConcept clinicalConcept = new ClinicalConcept();
        Allergy allergy = new Allergy();

        printConcept(clinicalConcept);
        printConcept(allergy);

        System.out.println("Print a list::");
        printConcepts(List.of(clinicalConcept, allergy));
    }
}
