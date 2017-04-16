package org.emf.example.driver;

import java.io.File;

import org.emf.example.convertor.Convertor;

public class Driver {
    public static void main(String args[]) throws Exception {
        File model = new File("model/RoyalAndLoyal.uml");
        Convertor convertor = new Convertor();
        try {
           convertor.umlToEcore(model);
            //convertor.umlToGenmodel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }


//        File ecoremodel = new File("model/randL.ecore");
//
//        try {
//
//            convertor.ecoreToUML(ecoremodel);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
