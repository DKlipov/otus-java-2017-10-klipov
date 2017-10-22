package ru.otus;

import org.json.simple.JSONObject;

import java.util.*;

/**
 * Created by tully.
 *
 * Example for L01.1
 *
 *
 * javac ru.otus.Main.java
 * java -cp . ru.otus.Main.java (из target classes)
 *
 * mvn help:effective-pom
 * To start the application:
 * mvn package
 * java -cp ./target/L01.1.1-maven.jar ru.otus.l0111.Main
 * java -jar ./target/L01.1.1-maven.jar //java.lang.NoClassDefFoundError: com/google/common/collect/Lists
 * java -cp ./target/L01.1.1-maven.jar;C:\Users\vitaly.chibrikov\.m2\repository\com\google\guava\guava\23.0\guava-23.0.jar ru.otus.l0111.Main
 *
 * To unzip the jar:
 * 7z x -oJAR ./target/L01.1.1-maven.jar
 * unzip -d JAR ./target/L01.1.1-maven.jar
 *
 * To build:
 * mvn package
 * mvn clean compile
 * mvn assembly:single
 * mvn clean compile assembly:single
 */
public class Main {

    public static void main(String... args) {
        System.out.println("Hello world");
        JSONObject a=new JSONObject();
        a.put("par1","val1");
        a.put("par2","val2");
        System.out.println(a.toJSONString());
    }

}