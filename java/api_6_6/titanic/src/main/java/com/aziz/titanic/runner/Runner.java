package com.aziz.titanic.runner;

import joinery.DataFrame;
import tech.tablesaw.api.IntColumn;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;
import tech.tablesaw.columns.Column;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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


            // Dataframe playground:
            List<String> sex = titanic.column("sex").asList().stream().distinct().map(Object::toString)
                    .collect(Collectors.toList());
            System.out.println("Sex Values:");
            StringColumn gender = titanic.column("sex").asStringColumn();
            List<Integer> gender_int = new ArrayList<>();
            for(String s : gender){
                if(s.equals("male"))
                    gender_int.add(0);
                else if(s.equals("female"))
                    gender_int.add(1);
            }


            // convert String sex column to gender integer column
            IntColumn mappedGender = IntColumn.create("mappedGender", gender_int.toArray(
                    new Integer[0]));
            titanic.addColumns(mappedGender);
            System.out.println("add gender integer column");
            System.out.println(titanic.print());
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
