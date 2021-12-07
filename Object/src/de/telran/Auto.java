package de.telran;

public class Auto {

    public String name;
    public int year;
    public String color;

    public Auto(String name, int year, String color) {
        this.name = name;
        this.year = year;
        this.color = color;
    }

    @Override
    public boolean equals(Object o2) {
        if (!(o2 instanceof Auto))   //не является экземпляром этого класса или его наследником
            return false;

        Auto auto2 = (Auto) o2;    //у класса обджект таких полей нет

        return (year == auto2.year
                && name.equals(auto2.name)
                && color.equals(auto2.color));
    }
    @Override
    public String toString(){
        return  "the name: " + name + ", the year: " + year + ", the color: " + color;
    }
}

