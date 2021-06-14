package com.aziz.titanic.runner;

import tech.tablesaw.api.Table;

import java.io.IOException;

public class Runner {
    public static void main(String [] args){
        try{
            Table titanic = Table.read().csv(Runner.class.getClassLoader().getResource("dataset/titanic.csv"));
            System.out.println(titanic.structure().printAll());
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
