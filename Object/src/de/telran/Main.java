package de.telran;

public class Main {

    public static void main(String[] args) {
        Auto [] autos = getAutopark();

        Auto bentley = new Auto ("Bentley", 2010, "Silver");
        swapAuto(bentley);
        System.out.println(bentley.name);

        System.out.println(containsAuto(autos,bentley));
        String descr = "The description of bentley:\n" + bentley;
        System.out.println(descr);

    }

    public static void swapAuto (Auto auto){
        Auto mersedes = new Auto ("Мерседес", 2010, "Silver");
        auto = mersedes;
    }

    private static Auto[] getAutopark (){
        Auto opel = new Auto ("Opel", 2012, "Grey");
        Auto mazda = new Auto ("Mazda", 2015, "Red");
        Auto bentley = new Auto ("Bentley", 2010, "Silver");

        return new Auto[]{opel, mazda, bentley};

    }

    static boolean containsAuto (Auto[] autos, Auto auto){
        for (int i =0; i < autos.length; i++){
            if (autos[i].equals(auto))
                return true;
        }
        return false;
    }
}