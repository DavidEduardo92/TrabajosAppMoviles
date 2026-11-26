package com.example.dcapi.models;

public class Hero {
    private int id;
    private String name;
    private String realName;
    private String image;
    private String publisher;
    private String alignment;
    private String intelligence;
    private String strength;
    private String speed;
    private String power;
    private String biography;

    public Hero(int id, String name, String realName,
                String image, String publisher,
                String alignment, String intelligence,
                String strength, String speed,
                String power, String biography) {

        this.id = id;
        this.name = name;
        this.realName = realName;
        this.image = image;
        this.publisher = publisher;
        this.alignment = alignment;
        this.intelligence = intelligence;
        this.strength = strength;
        this.speed = speed;
        this.power = power;
        this.biography = biography;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getRealName() { return realName; }
    public String getImage() { return image; }
    public String getPublisher() { return publisher; }
    public String getAlignment() { return alignment; }
    public String getIntelligence() { return intelligence; }
    public String getStrength() { return strength; }
    public String getSpeed() { return speed; }
    public String getPower() { return power; }
    public String getBiography() { return biography; }
}
