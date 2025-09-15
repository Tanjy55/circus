package circus;

import circus.stuff.Equipment;
import circus.stuff.Cage;
import circus.stuff.Cannon;
import circus.stuff.Ladder;

import circus.animal.Animal;
import circus.animal.Duck;
import circus.animal.Elephant;
import circus.animal.Parrot;
import circus.animal.Tiger;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


import java.util.ArrayList;
import java.util.Arrays;

public class Circus {
    private static Animal[] animals = {
            new Duck("Drake"),
            new Parrot("Polly"),
            new Tiger("Tai Lung")
    };
    private static Equipment[] equipments = {
            new Ladder(50),
            new Cannon(5),
            new Cannon(100)
    };

    private static void makeAnimalsTalk() {
        for (Animal a : animals) {
            System.out.println(a);
            System.out.println(a.speak());
        }
    }

    private static int calculateAssetValue(Asset[] assets) {
        int total = 0;
        for (Asset a : assets) {
            if (a.getValue() <= 5) {
                System.out.println("Ignoring low value item: " + a.getValue());
                continue;
            }
            total += a.getValue();
            System.out.println("Adding item value: " + a.getValue());
        }
        return total;
    }

    private static void printAllAnimals(ArrayList<Animal> animalArrayList) {
        for (Animal a : animalArrayList) {
            System.out.println(a);
        }
    }

    private static void printCircusSize(ArrayList<Animal> animalArrayList) {
        System.out.println("number of animals: " + animalArrayList.size());
    }

    private static Animal findAnimal(ArrayList<Animal> animalArrayList, String candidate) {
        for (Animal a : animalArrayList) {
            if (a.name == candidate) {
                return a;
            }
        }
        return null;
    }

    public static void main(String[] args) {
//        System.out.println("number of animals in our circus: " + animals.length);
//
//        animals[3] = new Duck("Louie");
//        System.out.println("number of animals in our circus: " + animals.length);
//        makeAnimalsTalk();
//        System.out.println("Total value of animals " + calculateAssetValue(animals));
//        System.out.println("Total value of equipments " + calculateAssetValue(equipments));
        ArrayList<Animal> animalArrayList = new ArrayList<>(Arrays.asList(animals));
//        printAllAnimals(animalArrayList);
//        printCircusSize(animalArrayList);
        animalArrayList.add(new Duck("fsdehu"));

//        printAllAnimals(animalArrayList);
//        System.out.println("number of animals: " + animalArrayList.size());

        Elephant dunbo = new Elephant("junbo");
        animalArrayList.add(dunbo);
        printCircusSize(animalArrayList);

        Animal candidateAnimal = findAnimal(animalArrayList, "junbo");

        System.out.println("Junbo is in position: "
                + animalArrayList.indexOf(candidateAnimal));

        System.out.println("Before sorting: ");
        printAllAnimals(animalArrayList);
        animalArrayList.sort(Animal.AnimalNameComaparator);
        System.out.println("After sorting: ");
        printAllAnimals(animalArrayList);


        animalArrayList.add(new Tiger("Sherkhan"));
        animalArrayList.add(new Parrot("popper"));

        Duck louie = new Duck("louie");
        Elephant strongOne = new Elephant("StrongOne");
        animalArrayList.add(strongOne);

        printAllAnimals(animalArrayList);

        Cage<Duck> duckCage = new Cage<>();
        Duck duck = new Duck("maccy");
        duckCage.lockUp(duck);
        Parrot parrot = new Parrot("lol");
        Cage<Parrot> parrotCage = new Cage<>();
        parrotCage.lockUp(parrot);

        ArrayList<Cage> cages = new ArrayList<>();
        cages.add(duckCage);
        cages.add(parrotCage);

        for (
                Cage c : cages) {
            c.release();
        }
    }
}
