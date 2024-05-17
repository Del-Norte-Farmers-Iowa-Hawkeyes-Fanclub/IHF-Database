package com.nighthawk.spring_portfolio.mvc.character;

import java.util.Random;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double weight;
    private Double height;
    private Integer cash;
    private String name;
    private Integer age;
    private Boolean basketball;

    public Character(Double weight, Double height, Integer cash, String name, Integer age, Boolean basketball) {
        this.weight = weight;
        this.height = height;
        this.cash = cash;
        this.name = name;
        this.age = age;
        this.basketball = basketball;
    }
    public int getAge(){
        return age;
    }
    public Double getWeight(){
        return weight;
    }
    public static Double generateWeight(){
        Random random = new Random();
        Double generatedWeight = 5.5 + random.nextDouble() * (9.5 - 5.5);
        generatedWeight = Math.round(generatedWeight * 100.0) / 100.0;
        return generatedWeight;
    }
    public void setWeight(Double newWeight) {
        this.weight = newWeight;
    }
    public Double getHeight(){
        return height;
    }
    public static Double generateHeight(){
        Random random = new Random();
        Double generatedHeight = 18 + random.nextDouble() * (21 - 18);
        generatedHeight = Math.round(generatedHeight * 100.0) / 100.0;
        return generatedHeight;
    }
    public void setHeight(Double newHeight) {
        this.height = newHeight;
    }
    public int getCash(){
        return cash;
    }
    public void setCash(int newCash) {
        this.cash = newCash;
    }
    public String getName(){
        return name;
    }
    public static String generateName(){
        String[] firstNames = {"John", "Jane", "Michael", "Emily", "William", "Emma"};
        String[] lastNames = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis"};

        Random random = new Random();
        String generatedFirstName = firstNames[random.nextInt(firstNames.length)];
        String generatedLastName = lastNames[random.nextInt(lastNames.length)];

        String generatedName = generatedFirstName + " " + generatedLastName;
        return generatedName;
    }
    public void setName(String newName) {
        this.name = newName;
    }
    public static void main(String[] args){
        Character c1 = new Character(generateWeight(), generateHeight(), 0, generateName(), 0, false);
    }

}
