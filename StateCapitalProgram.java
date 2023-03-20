import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class StateCapitalProgram {

    public static void main(String[] args) {
        // Part 1: Sorting Arrays
        String[][] statesAndCapitals = {
            {"Alabama", "Montgomery"},
            {"Alaska", "Juneau"},
            {"Arizona", "Phoenix"},
            {"Arkansas", "Little Rock"},
            {"California", "Sacramento"},
            {"Colorado", "Denver"},
            {"Connecticut", "Hartford"},
            {"Delaware", "Dover"},
            {"Florida", "Tallahassee"},
            {"Georgia", "Atlanta"},
            {"Hawaii", "Honolulu"},
            {"Idaho", "Boise"},
            {"Illinois", "Springfield"},
            {"Indiana", "Indianapolis"},
            {"Iowa", "Des Moines"},
            {"Kansas", "Topeka"},
            {"Kentucky", "Frankfort"},
            {"Louisiana", "Baton Rouge"},
            {"Maine", "Augusta"},
            {"Maryland", "Annapolis"},
            {"Massachusetts", "Boston"},
            {"Michigan", "Lansing"},
            {"Minnesota", "St. Paul"},
            {"Mississippi", "Jackson"},
            {"Missouri", "Jefferson City"},
            {"Montana", "Helena"},
            {"Nebraska", "Lincoln"},
            {"Nevada", "Carson City"},
            {"New Hampshire", "Concord"},
            {"New Jersey", "Trenton"},
            {"New Mexico", "Santa Fe"},
            {"New York", "Albany"},
            {"North Carolina", "Raleigh"},
            {"North Dakota", "Bismarck"},
            {"Ohio", "Columbus"},
            {"Oklahoma", "Oklahoma City"},
            {"Oregon", "Salem"},
            {"Pennsylvania", "Harrisburg"},
            {"Rhode Island", "Providence"},
            {"South Carolina", "Columbia"},
            {"South Dakota", "Pierre"},
            {"Tennessee", "Nashville"},
            {"Texas", "Austin"},
            {"Utah", "Salt Lake City"},
            {"Vermont", "Montpelier"},
            {"Virginia", "Richmond"},
            {"Washington", "Olympia"},
            {"West Virginia", "Charleston"},
            {"Wisconsin", "Madison"},
            {"Wyoming", "Cheyenne"}
        };

        System.out.println("===== CS201: Data Structures & Algorithms: Array Sorting and Hashmaps Assignment =====");
        System.out.println("===== WELCOME TO STATE CAPITAL PROGRAM =====");

        // Ask the user to enter a capital for a U.S. state
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a capital for a U.S. state: ");
        String userInput = scanner.nextLine();
        boolean capitalFound = false;

        // Check if the user input is correct
        for (String[] stateAndCapital : statesAndCapitals) {
            if (userInput.equalsIgnoreCase(stateAndCapital[1])) {
                System.out.println("Correct! " + stateAndCapital[0] + " is the state with the capital " + userInput + ".");
                capitalFound = true;
                break;
            }
        }

        if (!capitalFound) {
            System.out.println("Incorrect capital entered.");
        }

        // Display the current contents of the array
        System.out.println("Current contents of the array:");
        for (String[] stateAndCapital : statesAndCapitals) {
            System.out.println(stateAndCapital[0] + " - " + stateAndCapital[1]);
        }

        // Sort the array by capital using bubble sort
        for (int i = 0; i < statesAndCapitals.length - 1; i++) {
            for (int j = 0; j < statesAndCapitals.length - i - 1; j++) {
                if (statesAndCapitals[j][1].compareToIgnoreCase(statesAndCapitals[j + 1][1]) > 0) {
                    String[] temp = statesAndCapitals[j];
                    statesAndCapitals[j] = statesAndCapitals[j + 1];
                    statesAndCapitals[j + 1] = temp;
                }
            }
        }

        // Prompt the user to enter answers for all the state capitals

        int correctCount = 0;
        for (String[] stateAndCapital : statesAndCapitals) {
            System.out.print("What is the capital of " + stateAndCapital[0] + "? ");
            String userAnswer = scanner.nextLine();
            if (userAnswer.equalsIgnoreCase(stateAndCapital[1])) {
                System.out.println("Correct!");
                correctCount++;
            } else {
                System.out.println("Incorrect. The capital of " + stateAndCapital[0] + " is " + stateAndCapital[1] + ".");
            }
        }

        // Display the total correct count
        System.out.println("You got " + correctCount + " out of 50 correct.");

        // Part 2: Sorting & Searching HashMap
        HashMap<String, String> stateCapitalMap = new HashMap<>();
        for (String[] stateAndCapital : statesAndCapitals) {
            stateCapitalMap.put(stateAndCapital[0], stateAndCapital[1]);
        }

        // Display the content of the Map
        System.out.println("Current contents of the Map:");
        for (String state : stateCapitalMap.keySet()) {
            System.out.println(state + " - " + stateCapitalMap.get(state));
        }

        // Sort the map using TreeMap class
        TreeMap<String, String> sortedStateCapitalMap = new TreeMap<>(stateCapitalMap);

        // Prompt the user to enter a state and display the capital for the state
        System.out.print("Enter a state to find its capital: ");
        String state = scanner.nextLine();
        if (sortedStateCapitalMap.containsKey(state)) {
            System.out.println("The capital of " + state + " is " + sortedStateCapitalMap.get(state) + ".");
        } else {
            System.out.println("Invalid state.");
        }
    }
}