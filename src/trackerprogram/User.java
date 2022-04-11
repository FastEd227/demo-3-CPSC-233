package trackerprogram;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

import static trackerprogram.InputGathering.checkIfInteger;
import static trackerprogram.InputGathering.getUserInput;

public class User {

    public static final String TOTAL = "total";
//    public static final String TIMEFRAME = "timeframe";
    public static final String AVERAGE = "average";
    public static final String ADDFOOD = "addfood";
    public static final String NUTRITION = "checknutrition";
    public static final String EXERCISE = "checkexercise";
    public static final String ADDEXERCISE = "addexercise";
    public static final String QUIT = "quit";

    public static void main(String[] args){
        boolean userFound = true;

        String username = userFile();
        ArrayList<UserFood> food = readingUserFoodFiles(username);
        ArrayList<UserExercise> exercise =readingUserExerciseFiles(username);
        //dont change above, these run regardless, below put in a main menu


//        addUserFood(food,username);
        //used to add food to user document
//        addUserExercise(exercise,username);
        //used to add exercise to user document
//        exerciseCompleted(exercise);
        //used to check average or total exercise

//        foodConsumed(food);

        String menuInput = "";
        String [] menuOptions = {ADDFOOD,NUTRITION,EXERCISE,ADDEXERCISE,QUIT};
        while(userFound) {
            menuInput = InputGathering.errorCheckUserInput("What would you like to do?", menuOptions);
            if (menuInput.equals(ADDFOOD)) {
                addUserFood(food,username);
            }
            if (menuInput.equals(NUTRITION)) {
                foodConsumed(food);
            }
            if (menuInput.equals(ADDEXERCISE)) {
                addUserExercise(exercise,username);
            }
            if (menuInput.equals(EXERCISE)) {
                exerciseCompleted(exercise);

            }

            if(menuInput.equals(QUIT)){
                System.out.println("Good bye!");
                userFound = false;
            }
        }


        //used to check average or total food consumed

    }

    public static void userMenu(){
        boolean userFound = true;

        String username = userFile();
        ArrayList<UserFood> food = readingUserFoodFiles(username);
        ArrayList<UserExercise> exercise =readingUserExerciseFiles(username);
        //dont change above, these run regardless, below put in a main menu


//        addUserFood(food,username);
        //used to add food to user document
//        addUserExercise(exercise,username);
        //used to add exercise to user document
//        exerciseCompleted(exercise);
        //used to check average or total exercise

//        foodConsumed(food);

        String menuInput = "";
        String [] menuOptions = {ADDFOOD,NUTRITION,EXERCISE,ADDEXERCISE,QUIT};
        while(userFound) {
            menuInput = InputGathering.errorCheckUserInput("What would you like to do?", menuOptions);
            if (menuInput.equals(ADDFOOD)) {
                addUserFood(food,username);
            }
            if (menuInput.equals(NUTRITION)) {
                foodConsumed(food);
            }
            if (menuInput.equals(ADDEXERCISE)) {
                addUserExercise(exercise,username);
            }
            if (menuInput.equals(EXERCISE)) {
                exerciseCompleted(exercise);

            }

            if(menuInput.equals(QUIT)){
                System.out.println("Good bye!");
                userFound = false;
            }
        }
    }

    public static String userFile(){
        String userName = getUserInput("What is your name? ");
        File userFile = new File(userName);
        //TODO GET TO WORK!! the already exist part
        if (!userFile.exists()) {
            NewUser.getUserInfo();
            return NewUser.getUserInfo();
        } else {
//            System.out.println("poggers");
            return userName;
        }


    }

    public static ArrayList<UserFood>  readingUserFoodFiles(String userName){
        ArrayList<UserFood> userFoodInfo = new ArrayList<UserFood>();
        try {
            FileReader file_reader = new FileReader("./"+userName+"/foodinfo.txt");
            BufferedReader buffered_reader = new BufferedReader(file_reader);
            String line = buffered_reader.readLine();


            while (line != null) {
                userFoodInfo.add(convertStringToUserFood(line));




                line = buffered_reader.readLine();
            }

        } catch (FileNotFoundException e) {
//Handle error
        } catch (IOException e){

        }
        return userFoodInfo;
    }


    public static ArrayList<UserFood> addUserFood(ArrayList<UserFood> existingFood,String userName){
        String daDay = InputGathering.getUserInput("What day did you eat this on?");
        String daMonth = InputGathering.getUserInput("What month did you eat this on?");
        String daYear = InputGathering.getUserInput("What year did you eat this on?");
        String daCalories = InputGathering.getUserInput("How many calories did it have?");
        String daProtein = InputGathering.getUserInput("How much protein was in it?");
        String daCarbs = InputGathering.getUserInput("How much carbs was in it?");
        String daFat = InputGathering.getUserInput("How much fat was in it?");


        if(InputGathering.checkIfInteger(daDay) && InputGathering.checkIfInteger(daMonth) && InputGathering.checkIfInteger(daYear) && InputGathering.checkIfFloat(daCalories)){
            int day = Integer.parseInt(daDay);
            int month = Integer.parseInt(daMonth);
            int year = Integer.parseInt(daYear);
            float calories = Float.parseFloat(daCalories);
            float protein = Float.parseFloat(daProtein);
            float fat = Float.parseFloat(daFat);
            float carbs = Float.parseFloat(daCarbs);
            UserFood newItem = new UserFood(day,month,year,calories,protein,fat,carbs);
            String writeableNewItem = newItem.toString();
            InputGathering.writingToFile("./"+userName+"/foodinfo.txt",writeableNewItem);

            existingFood.add(newItem);

        } else {
            System.out.println("This is not a correct amount that is accepted");
        }



//        int day = Integer.parseInt(daDay);
//        int month = Integer.parseInt(daMonth);
//        int year = Integer.parseInt(daYear);
//        float calories = Float.parseFloat(daCalories);
//        float protein = Float.parseFloat(daProtein);
//        float fat = Float.parseFloat(daFat);
//        float carbs = Float.parseFloat(daCarbs);
//        UserFood newItem = new UserFood(day,month,year,calories,protein,fat,carbs);
//        String writeableNewItem = newItem.toString();
//        InputGathering.writingToFile("./"+userName+"/foodinfo.txt",writeableNewItem);
//
//        existingFood.add(newItem);


        return existingFood;


    }

    public static UserFood convertStringToUserFood(String pog){
        String[] parts = pog.split(",");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);
        float calories = Float.parseFloat(parts[3]);
        float protein = Float.parseFloat(parts[4]);
        float fat = Float.parseFloat(parts[5]);
        float carbs = Float.parseFloat(parts[6]);

        return new UserFood(day,month,year,calories,protein,fat,carbs);
    }



    public static ArrayList<UserExercise>  readingUserExerciseFiles(String userName){
        ArrayList<UserExercise> userExerciseInfo = new ArrayList<UserExercise>();
        try {
            FileReader file_reader = new FileReader("./"+userName+"/workoutinfo.txt");
            BufferedReader buffered_reader = new BufferedReader(file_reader);
            String line = buffered_reader.readLine();


            while (line != null) {
                userExerciseInfo.add(convertStringToUserExercise(line));




                line = buffered_reader.readLine();
            }

        } catch (FileNotFoundException e) {
//Handle error
        } catch (IOException e){

        }
        return userExerciseInfo;
    }


    public static ArrayList<UserExercise> addUserExercise(ArrayList<UserExercise> existingExercise,String userName){
        int day = Integer.parseInt(InputGathering.getUserInput("What day did you exercise on?"));
        int month = Integer.parseInt(InputGathering.getUserInput("What month did you exercise on?"));
        int year = Integer.parseInt(InputGathering.getUserInput("What year did you exercise on?"));
        float calories = Float.parseFloat(InputGathering.getUserInput("How many calories did you burn?"));
        UserExercise newItem = new UserExercise(day,month,year,calories);
        String writeableNewItem = newItem.toString();
        InputGathering.writingToFile("./"+userName+"/workoutInfo.txt",writeableNewItem);

        existingExercise.add(newItem);

        return existingExercise;


    }

    public static void foodConsumed(ArrayList<UserFood> food){

        String checkingFood = InputGathering.getUserInput("Would you like to check total or average??");
        float caloricIntake = 0;
        float fatIntake = 0;
        float proteinIntake = 0;
        float carbsIntake = 0;
        int averageAmount = 0;




//        if(checkingFood.equals(TOTAL)) {

            for (int i = 0; i < food.size(); i++) {
                UserFood foodEaten = food.get(i);
                caloricIntake = caloricIntake + foodEaten.calories;
                fatIntake = fatIntake + foodEaten.fat;
                proteinIntake = proteinIntake + foodEaten.protein;
                carbsIntake = carbsIntake + foodEaten.carbs;
                averageAmount++;


            }
            if (checkingFood.equals(TOTAL)) {
                System.out.println("Your total calories is: " + caloricIntake);
                System.out.println("Your total fat is: " + fatIntake + " grams");
                System.out.println("Your total protein is: " + proteinIntake + " grams");
                System.out.println("Your total carbs is: " + carbsIntake + " grams");

            }

            if(checkingFood.equals(AVERAGE)){
                String dailyMeals = InputGathering.getUserInput("How many times a day do you eat?");
                int dailyAmount = Integer.parseInt(dailyMeals);
                System.out.println("Your average calories is: " + (caloricIntake / averageAmount)*dailyAmount);
                System.out.println("Your average fat is: " + (fatIntake / averageAmount)*dailyAmount + " grams");
                System.out.println("Your average protein is: " + (proteinIntake / averageAmount)*dailyAmount + " grams");
                System.out.println("Your average carbs is: " + (carbsIntake / averageAmount)*dailyAmount + " grams");
            }
//        }


    }

    public static UserExercise convertStringToUserExercise(String pog){
        String[] parts = pog.split(",");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);
        float calories = Float.parseFloat(parts[3]);

        return new UserExercise(day,month,year,calories);
    }


    public static void exerciseCompleted(ArrayList<UserExercise> exercise){

        String checkingExercise = InputGathering.getUserInput("Would you like to check total or average??");
        float caloricIntake = 0;
        int averageAmount = 0;



//        if(checkingFood.equals(TOTAL)) {

        for (int i = 0; i < exercise.size(); i++) {
            UserExercise exerciseDone = exercise.get(i);
            caloricIntake = caloricIntake + exerciseDone.calories;
            averageAmount++;


        }
        if (checkingExercise.equals(TOTAL)) {
            System.out.println("Your total calories burned is: " + caloricIntake);
        }

        if(checkingExercise.equals(AVERAGE)){
            System.out.println("Your average calories burned is: " + caloricIntake / averageAmount);

        }
//        }


    }







}
