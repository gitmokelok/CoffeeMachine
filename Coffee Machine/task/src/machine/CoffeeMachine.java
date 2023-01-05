package machine;

import java.util.Scanner;

public class CoffeeMachine {

    private int waterCapacity;
    private int milkCapacity;
    private int beansCapacity;
    private int cupsCapacity;
    private int moneyInTheCounter;

    public CoffeeMachine(){
        waterCapacity = 400;
        milkCapacity = 540;
        beansCapacity = 120;
        cupsCapacity = 9;
        moneyInTheCounter = 550;
    }








    public static void main(String[] args) {

        //One cup of coffee contents
        final int WATER_IN_ML = 200;
        final int MILK_IN_ML = 50;
        final int COFFEE_IN_GRAMS = 15;

        CoffeeMachine cm = new CoffeeMachine();
        //cm.printCoffeeMachineState();


        Scanner scanner = new Scanner(System.in);
        while (true) {
            cm.printCoffeeMachineMenu();
            String userMenuValue = scanner.nextLine();
            switch (userMenuValue) {
                case "buy":
                    cm.printBuyMenu();
                    String buyMenuValue = scanner.nextLine();
                    switch (buyMenuValue) {
                        case "1": //espresso
                            cm.makeEspresso();
                            break;
                        case "2": //latte
                            cm.makeLatte();
                            break;
                        case "3": // cappuccino
                            cm.makeCappuccino();
                            break;
                        case "back":
                            break;
                        default:
                            break;
                    }
                    break;
                case "fill":
                    System.out.println("Write how many ml of water you want to add:");
                    int waterToAdd = scanner.nextInt();
                    System.out.println("Write how many ml of milk you want to add:");
                    int milkToAdd = scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    int beansToAdd = scanner.nextInt();
                    System.out.println("Write how many disposable cups you want to add:");
                    int cupsToAdd = scanner.nextInt();
                    cm.fillIn(waterToAdd, milkToAdd, beansToAdd, cupsToAdd);
                    break;
                case "take":
                    cm.GiveAwayAllMoney();
                    break;
                case "remaining":
                    System.out.println();
                    cm.printCoffeeMachineState();
                    break;
                case "exit":
                    return;
            }

            //m.printCoffeeMachineState();
        }





//        System.out.println("How many cups of coffee you will need:");
//
//        int numberOfCoffeesOrdered = scanner.nextInt();
//
//        long totalWater = WATER_IN_ML * numberOfCoffeesOrdered;
//        long totalMilk = MILK_IN_ML * numberOfCoffeesOrdered;
//        long totalCoffee = COFFEE_IN_GRAMS * numberOfCoffeesOrdered;
//
//        System.out.println(String.format("""
//                                For %d cups of coffee you will need:
//                                %d ml of water
//                                %d ml of milk
//                                %d g of coffee beans""", numberOfCoffeesOrdered,
//                                                        totalWater,
//                                                        totalMilk,
//                                                        totalCoffee));
    }

    private void fillIn(int waterToAdd, int milkToAdd, int beansToAdd, int cupsToAdd) {
        waterCapacity += waterToAdd;
        milkCapacity += milkToAdd;
        beansCapacity += beansToAdd;
        cupsCapacity += cupsToAdd;
    }

    public void makeEspresso() {
        if (checkCapacity(250, 0, 16, 1)) {
            waterCapacity -= 250;
            beansCapacity -= 16;
            moneyInTheCounter += 4;
            cupsCapacity--;
        }
    }

    private boolean checkCapacity(int waterAmount, int milkAmount, int beansAmount, int cupsAmount) {
        if (waterCapacity - waterAmount < 0) {
            System.out.println("Sorry, not enough water!");
            return false;
        }
        if (milkCapacity - milkAmount < 0) {
            System.out.println("Sorry, not enough milk!");
            return false;
        }

        if (beansCapacity - beansAmount < 0) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        }

        if (cupsCapacity - cupsAmount < 0) {
            System.out.println("Sorry, not enough cups!");
            return false;
        }

        System.out.println("I have enough resources, making you a coffee!");
        return true;
    }

    public void makeLatte() {
        if (checkCapacity(350, 75, 20, 1)) {
            waterCapacity -= 350;
            milkCapacity -= 75;
            beansCapacity -= 20;
            moneyInTheCounter += 7;
            cupsCapacity--;
        }
    }

    public void makeCappuccino() {
        if (checkCapacity(200, 100, 12, 1)) {
            waterCapacity -= 200;
            milkCapacity -= 100;
            beansCapacity -= 12;
            moneyInTheCounter += 6;
            cupsCapacity--;
        }
    }

    public void printBuyMenu() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
    }

    public void GiveAwayAllMoney() {
        System.out.println(String.format("""
                I gave you $%d
                """, moneyInTheCounter));
        moneyInTheCounter = 0;
    }

    public void printCoffeeMachineState() {
        System.out.println(String.format("""
                The coffee machine has:
                %d ml of water
                %d ml of milk
                %d g of coffee beans
                %d disposable cups
                $%d of money
                """, waterCapacity, milkCapacity, beansCapacity, cupsCapacity, moneyInTheCounter));
    }

    public void printCoffeeMachineMenu() {
        System.out.println("""
                Write action (buy, fill, take, remaining, exit):""");
    }


}
