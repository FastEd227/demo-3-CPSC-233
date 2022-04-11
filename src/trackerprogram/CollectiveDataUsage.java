package trackerprogram;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CollectiveDataUsage {

//    ArrayList<Food> food = readingFoodFiles("Exercisepog.txt");
    ArrayList<Exercise> exercise =readingExerciseFiles("Exercisepog.txt");

    public static ArrayList<Exercise>  readingExerciseFiles(String userName){
        ArrayList<Exercise> ExerciseInfo = new ArrayList<Exercise>();
        try {
            FileReader file_reader = new FileReader("Exercisepog.txt");
            BufferedReader buffered_reader = new BufferedReader(file_reader);
            String line = buffered_reader.readLine();


            while (line != null) {
                ExerciseInfo.add(convertStringToExercise(line));




                line = buffered_reader.readLine();
            }

        } catch (FileNotFoundException e) {
//Handle error
        } catch (IOException e){

        }
        return ExerciseInfo;
    }


    public static ArrayList<Food> addFood(ArrayList<Food> Food){
        String name = InputGathering.getUserInput("What is the name of the food?");
        int amount = Integer.parseInt("If it is a meal, type amount of meals. If it is an item, how many grams are there?");
        float calories = Float.parseFloat(InputGathering.getUserInput("How many calories did it have?"));
        float protein = Float.parseFloat(InputGathering.getUserInput("How much protein was in it?"));
        float fat = Float.parseFloat(InputGathering.getUserInput("How much fat was in it?"));
        float carbs = Float.parseFloat(InputGathering.getUserInput("How much carbs was in it?"));
        Food newItem = new Food(name,amount,calories,protein,fat,carbs);
        String writeableNewItem = newItem.toString();
        InputGathering.writingToFile("foodpog.txt",writeableNewItem);

        Food.add(newItem);


        return Food;


    }

    public static Exercise convertStringToExercise(String pog){
        String[] parts = pog.split(",");
        String name = parts[0];
        int amount = Integer.parseInt(parts[1]);
        float calories = Float.parseFloat(parts[2]);

        return new Exercise(name,amount,calories);
    }

    public static ArrayList<Exercise> addExercise(ArrayList<Exercise> Exercise){
        String name = InputGathering.getUserInput("What is the name of the exercise?");
        int amount = Integer.parseInt(InputGathering.getUserInput("How long is a typical session of this exercise?"));
        float calories = Float.parseFloat(InputGathering.getUserInput("How many calories did you burn?"));
        Exercise newItem = new Exercise(name,amount,calories);
        String writeableNewItem = newItem.toString();
        InputGathering.writingToFile("Exercisepog.txt",writeableNewItem);

        Exercise.add(newItem);

        return Exercise;


    }




}
