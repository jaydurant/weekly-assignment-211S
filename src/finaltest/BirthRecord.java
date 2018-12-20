package finaltest;

import java.time.*;

public class BirthRecord {
    public enum Gender { MALE, FEMALE };

    private String name;
    private LocalDateTime birthday;
    private double weight, height;
    private Gender gender;
    private boolean multiple;
        // true if baby was born as part of twins, triplets, etc.
        // false otherwise
    
    public BirthRecord(String name, LocalDateTime birthday, double weight, double height, boolean multiple, Gender gender) {
        this.name = name;
        this.birthday = birthday;
        this.weight = weight;
        this.height = height;
        this.multiple = multiple;
        this.gender = gender;
    }

    public boolean isMultiple() {
        return multiple;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getDateTime() {
        return birthday;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setMultiple(boolean multiple) {
        this.multiple = multiple;
    }
    
    @Override
    public String toString() {
        return "BirthRecord " + 
                "[name=" + name + 
                ", birthday=" + birthday + 
                ", weight=" + weight + 
                ", height=" + height +
                ", gender=" + gender + 
                ", multiple=" + multiple + "]";
    }
}
