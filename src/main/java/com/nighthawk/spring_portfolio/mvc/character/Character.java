package com.nighthawk.spring_portfolio.mvc.character;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
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
    private static final AtomicLong idGenerator = new AtomicLong(1);

    public Character() {
    }

    public Character(Double weight, Double height, Integer cash, String name, Integer age, Boolean basketball) {
        this.id = idGenerator.getAndIncrement();
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
        String[] firstNames = {"Jimmy", "Kobe", "Shaq", "Chris", "Ja", "LeBron", "DeMarcus", "Anthony", "Klay", "Carmelo"};
        String[] lastNames = {"Paul", "Bryant", "Thompson", "James", "Morant", "Davis", "Cousins", "Butler", "Edwards", "Anthony"};

        Random random = new Random();
        String generatedFirstName = firstNames[random.nextInt(firstNames.length)];
        String generatedLastName = lastNames[random.nextInt(lastNames.length)];

        String generatedName = generatedFirstName + " " + generatedLastName;
        return generatedName;
    }
    public void setName(String newName) {
        this.name = newName;
    }
    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", weight=" + weight +
                ", height=" + height +
                ", cash=" + cash +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", basketball=" + basketball +
                '}';
    }

    public static void main(String[] args){
        Character c1 = new Character(generateWeight(), generateHeight(), 0, generateName(), 0, false);
        System.out.println(c1);
    }

} 
