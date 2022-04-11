package trackerprogram;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static trackerprogram.InputGathering.errorCheckUserInput;
import static trackerprogram.InputGathering.getUserInput;
import static trackerprogram.User.*;

public class Testrun1 {

    @FXML
    private MenuItem newUser;

    @FXML
    private MenuItem exisitingUser;

    @FXML
    private MenuItem quit;

    @FXML
    private MenuItem addToGlobalFood;

    @FXML
    private MenuItem addToGlobalExercise;

    @FXML
    private MenuItem showGlobalFood;

    @FXML
    private MenuItem showGlobalExercise;

    @FXML
    private MenuItem about;

    @FXML
    private TextArea addFoodDay;

    @FXML
    private TextArea addFoodMonth;

    @FXML
    private TextArea addFoodYear;

    @FXML
    private TextArea addFoodAmount;

    @FXML
    private TextArea addFoodCalories;

    @FXML
    private TextArea addFoodProtein;

    @FXML
    private TextArea addFoodFat;

    @FXML
    private TextArea addFoodCarbs;

    @FXML
    private Button addFoodButton;

    @FXML
    private TextArea addExerciseDay;

    @FXML
    private TextArea addExerciseMonth;

    @FXML
    private TextArea addExerciseYear;

    @FXML
    private TextArea addExerciseCalories;

    @FXML
    private Button addExerciseButton;

    @FXML
    private TextArea checkFoodStartDay;

    @FXML
    private TextArea checkFoodStartMonth;

    @FXML
    private TextArea checkFoodStartYear;

    @FXML
    private TextArea checkFoodEndDay;

    @FXML
    private TextArea checkFoodEndMonth;

    @FXML
    private TextArea checkFoodEndYear;

    @FXML
    private TextArea checkFoodDailyMeals;

    @FXML
    private Button checkFoodTotalButton;

    @FXML
    private Button checkFoodDailyButton;

    @FXML
    private TextArea checkExerciseStartDay;

    @FXML
    private TextArea checkExerciseStartMonth;

    @FXML
    private TextArea checkExerciseStartYear;

    @FXML
    private TextArea checkExerciseEndDay;

    @FXML
    private TextArea checkExerciseEndMonth;

    @FXML
    private TextArea checkExerciseEndYear;

    @FXML
    private TextArea checkExerciseDailyHours;

    @FXML
    private Button checkExerciseTotalButton;

    @FXML
    private Button checkExerciseDailyButton;

    @FXML
    private Button loadUser;

    @FXML
    private Button checkProgress;

    @FXML
    private TextArea detailsDisplay;

    @FXML
    private TextArea boxForUserName;

    @FXML
    private Label leftStatusLabel;

    public static String userName = null;

    private static ArrayList<UserFood> userFood;
    private static ArrayList<UserExercise> userExercise;
    Stage tony = new Stage();







    public void loadUser(ActionEvent event) throws IOException {
        String userNameMock = boxForUserName.getText();

        File userFile = new File(userNameMock);
        //TODO GET TO WORK!! the already exist part
        if (!userFile.exists()) {
            switchToNewUser(event);
        } else {
//            System.out.println("poggers");
            userName = userNameMock;
        }
        userFood = readingUserFoodFiles(userName);
        userExercise =readingUserExerciseFiles(userName);






    }

    public void addFood(ActionEvent event){
        String daDay = addFoodDay.getText();
        String daMonth = addFoodMonth.getText();
        String daYear = addFoodYear.getText();
        String daCalories = addFoodCalories.getText();
        String daProtein = addFoodProtein.getText();
        String daCarbs = addFoodCarbs.getText();
        String daFat = addFoodFat.getText();

        if(InputGathering.checkIfInteger(daDay) && InputGathering.checkIfInteger(daMonth) && InputGathering.checkIfInteger(daYear) && InputGathering.checkIfFloat(daCalories) && InputGathering.checkIfFloat(daProtein) && InputGathering.checkIfFloat(daCarbs) && InputGathering.checkIfFloat(daFat)){
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

            userFood.add(newItem);

        } else {
            leftStatusLabel.setText("This is not a correct amount that is accepted");
        }


    }

    public void addExercise(ActionEvent event){
        String daDay = addExerciseDay.getText();
        String daMonth = addExerciseMonth.getText();
        String daYear = addExerciseYear.getText();
        String daCalories = addExerciseCalories.getText();

        if(InputGathering.checkIfInteger(daDay) && InputGathering.checkIfInteger(daMonth) && InputGathering.checkIfInteger(daYear) && InputGathering.checkIfFloat(daCalories)){
            int day = Integer.parseInt(daDay);
            int month = Integer.parseInt(daMonth);
            int year = Integer.parseInt(daYear);
            float calories = Float.parseFloat(daCalories);
            UserExercise newItem = new UserExercise(day,month,year,calories);
            String writeableNewItem = newItem.toString();
            InputGathering.writingToFile("./"+userName+"/workoutInfo.txt",writeableNewItem);

            userExercise.add(newItem);
        } else {
            leftStatusLabel.setText("This is not a correct amount that is accepted");
        }


    }

    public void checkFoodTotal(ActionEvent event){
        float caloricIntake = 0;
        float fatIntake = 0;
        float proteinIntake = 0;
        float carbsIntake = 0;


        for (int i = 0; i < userFood.size(); i++) {
            UserFood foodEaten = userFood.get(i);
            caloricIntake = caloricIntake + foodEaten.calories;
            fatIntake = fatIntake + foodEaten.fat;
            proteinIntake = proteinIntake + foodEaten.protein;
            carbsIntake = carbsIntake + foodEaten.carbs;



        }


        String totalCalories = "Your total calories is: " + caloricIntake;
        String totalFat = "Your total fat is: " + fatIntake + " grams";
        String totalProtein = "Your total protein is: " + proteinIntake + " grams";
        String totalCarbs = "Your total carbs is: " + carbsIntake + " grams";

        detailsDisplay.setText(totalCalories + "\n" + totalProtein + "\n" + totalFat + "\n" + totalCarbs);







    }

    public void checkFoodAverage(ActionEvent event){

        float caloricIntake = 0;
        float fatIntake = 0;
        float proteinIntake = 0;
        float carbsIntake = 0;
        int averageAmount = 0;
        int dailyAmount = 0;

        for (int i = 0; i < userFood.size(); i++) {
            UserFood foodEaten = userFood.get(i);
            caloricIntake = caloricIntake + foodEaten.calories;
            fatIntake = fatIntake + foodEaten.fat;
            proteinIntake = proteinIntake + foodEaten.protein;
            carbsIntake = carbsIntake + foodEaten.carbs;
            averageAmount++;


        }


        if(InputGathering.checkIfInteger(checkFoodDailyMeals.getText())){
            dailyAmount = Integer.parseInt(checkFoodDailyMeals.getText());
            String totalCalories = "Your total calories is: " + (caloricIntake / averageAmount)*dailyAmount;
            String totalFat = "Your total fat is: " + (fatIntake / averageAmount)*dailyAmount + " grams";
            String totalProtein = "Your total protein is: " + (proteinIntake / averageAmount)*dailyAmount + " grams";
            String totalCarbs = "Your total carbs is: " + (carbsIntake / averageAmount)*dailyAmount + " grams";

            detailsDisplay.setText(totalCalories + "\n" + totalProtein + "\n" + totalFat + "\n" + totalCarbs);
        } else {
            leftStatusLabel.setText("This is not a correct amount that is accepted");
        }




    }

    public void checkExerciseTotal(ActionEvent event){
        float caloricIntake = 0;

        for (int i = 0; i < userExercise.size(); i++) {
            UserExercise exerciseDone = userExercise.get(i);
            caloricIntake = caloricIntake + exerciseDone.calories;
        }
        String totalCalories = "Your total calories burned is: " + caloricIntake;
        detailsDisplay.setText(totalCalories);



    }

    public void checkExerciseAverage(ActionEvent event){
        float caloricIntake = 0;
        float averageAmount = 0;
        for (int i = 0; i < userExercise.size(); i++) {
            UserExercise exerciseDone = userExercise.get(i);
            caloricIntake = caloricIntake + exerciseDone.calories;
            averageAmount++;

        }
        if(InputGathering.checkIfFloat(checkExerciseDailyHours.getText())){
            Float averageDaily = Float.parseFloat(checkExerciseDailyHours.getText());
            String totalCalories = "Your average calories burned per hour is: " + (caloricIntake / averageAmount)*averageDaily;


            detailsDisplay.setText(totalCalories);
        } else {
            leftStatusLabel.setText("This is not a correct amount that is accepted");
        }


    }

    public void switchToNewUser(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("newUser.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        tony.setTitle("Add New User");


        //Students edit here to set up the scene
        tony.setScene(scene);
        tony.show();
    }
}
