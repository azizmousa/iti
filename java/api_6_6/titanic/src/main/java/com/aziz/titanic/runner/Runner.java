package com.aziz.titanic.runner;

import joinery.DataFrame;
import tech.tablesaw.api.Table;

import java.io.IOException;
import java.util.Objects;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String [] args){
        try{
            // Explore data with tablewas library
            Table titanic = Table.read().csv(Runner.class.getClassLoader().getResource("dataset/titanic.csv"));
            System.out.println(titanic.structure().printAll());
            System.out.println(titanic.summary().toString());
            System.out.println(titanic.column("survived").summary().toString());

            // Explore data with joinery library
            System.out.println("joinery Dataframe Object:");
            DataFrame<Object> df = DataFrame.readCsv(Objects.requireNonNull(Runner.class
                    .getClassLoader().getResourceAsStream("dataset/titanic.csv")));
            System.out.println(df.toString());
            System.out.println("Joinery DataFrame Summary");
            System.out.println(df.describe().toString());
            System.out.println("Joinery DataFrame Columns");
            System.out.println(df.columns().toString());
            System.out.println("Number of pClasses = " + df.col("pclass").stream().distinct().count());
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
