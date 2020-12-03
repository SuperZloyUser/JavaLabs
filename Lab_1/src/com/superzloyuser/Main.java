package com.superzloyuser;

import com.superzloyuser.entities.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        var testList = new ArrayList<Animal>();

        testList.add(new Animal("DFG", 567));
        testList.add(new Mammal("ASD", 321, "QWE", 123));
        testList.add(new Bird("ZXC", 321, "QWE", 123));
        testList.add(new ClovenHoofed("ABC", 666, "ABC", 666, "ABC", 4));
        testList.add(new Animal());
        testList.add(new Animal());
        testList.add(new Animal());

        boolean flag = true;

        while(flag){
            System.out.println("Choose option:\n1 - Add\n2 - Delete\n3 - Clear\n4 - Show\n5 - Compare\n0 - Exit\n");
            Scanner in = new Scanner(System.in);
            System.out.print("Input a number: ");

            try {

                var option = in.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("Input class name:");
                        var className = in.next();
                        switch (className) {
                            case "Animal":
                                var tempSpecies = in.next();
                                var tempTest = in.nextInt();
                                testList.add(new Animal(tempSpecies, tempTest));
                                break;
                            case "Mammal":
                                tempSpecies = in.next();
                                tempTest = in.nextInt();
                                var tempSubspecies = in.next();
                                var tempSubTest = in.nextInt();
                                testList.add(new Mammal(tempSpecies, tempTest, tempSubspecies, tempSubTest));
                                break;
                            case "ClovenHoofed":
                                tempSpecies = in.next();
                                tempTest = in.nextInt();
                                tempSubspecies = in.next();
                                tempSubTest = in.nextInt();
                                var tempName = in.next();
                                var tempLegs = in.nextInt();
                                testList.add(new ClovenHoofed(tempSpecies, tempTest, tempSubspecies, tempSubTest, tempName, tempLegs));
                                break;
                            case "Bird":
                                tempSpecies = in.next();
                                tempTest = in.nextInt();
                                tempSubspecies = in.next();
                                tempSubTest = in.nextInt();
                                testList.add(new Bird(tempSpecies, tempTest, tempSubspecies, tempSubTest));
                                break;
                            default:
                                System.out.println("Invalid class name!");
                                continue;
                        }
                        break;
                    case 2:
                        System.out.println("Input element number:");
                        var numForDel = in.nextInt();
                        try {
                            testList.remove(numForDel - 1);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                        testList.clear();
                        break;
                    case 4:
                        for (Animal animal : testList) {
                            System.out.println((testList.indexOf(animal) + 1) + ") " + animal.toString());
                        }
                        break;
                    case 5:
                        if (testList.size() > 1) {
                            System.out.println("Enter the number of the first element: ");
                            var firstEl = in.nextInt();

                            System.out.println("Enter the number of the second element: ");
                            var secondEl = in.nextInt();

                            try {
                                if (testList.get(firstEl).equals(testList.get(secondEl)))
                                    System.out.println("Objects are equivalent!");
                                else
                                    System.out.println("Objects are not equivalent!");
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        break;
                    case 0:
                        flag = false;
                        break;
                }
            }
            catch (Exception e){
                System.out.println("Неверный формат ввода!\n");
            }
        }
    }
}
