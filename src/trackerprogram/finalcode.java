package trackerprogram;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import trackerprogram.MainMenu;

import java.io.*;

import java.util.*;
import java.util.List;


public class finalcode {

//program is procedural
//    static functions launched from main
//
    static Scanner userInput = new Scanner(System.in);
    public static final String NEW = "new";
    public static final String OLD = "old";
    public static final String addfood = "addfood";
    public static final String food = "foodeaten";
    public static final String exercise = "exercisecompleted";
    public static final String nutrition = "checknutrition";
    public static final String weekly = "checkweeklyprogress";
    public static final String monthly = "checkmonthlyprogress";
    public static final String overall = "checkoverallprogress";
    public static final String quit = "quit";


    public static String errorCheckUserInput(String prompt, String[] arr){
        while(true){
            String input = getUserInput(prompt);

            for(int i = 0; i < arr.length; i++){
                if(input.equals(arr[i])){
                    return input;
                }
            }
            System.out.print("The inputs can only be ");
            for(int i = 0; i < arr.length; i++){
                System.out.print(arr[i] + "  ");
            }
            System.out.println(" ");
        }
    }


    public static String getUserInput(String message){
        System.out.println(message);
        String input = userInput.nextLine();
        input = input.replaceAll("\s+","");
//        System.out.println("THis is the input: " +input);
        return input;
    }

    public static void main(String[] args){




//        MainMenu.startMainMenu();
//
//        ArrayList<float[]> allFoodInfo = new ArrayList<float[]>();
//        ArrayList<String> foodNames = new ArrayList<String>();
//        ArrayList<float[]> userFoodInfo = new ArrayList<>();
//        userFunction();
//        userInterface(allFoodInfo,foodNames,userFoodInfo);
//        //gotta make more sense but use a while loop once completed and functional
////        userFile();
////        readingFoodFiles(allFoodInfo,foodNames);


    }




    public static void userFunction(){
        //is user new? or old
        //if old, ask for user name
        //pull up doc on use (this can be done later)
        //use while loop at top, then blow through function

        String userType = "";


        //txt.toUpperCase()
        //txt.toLowerCase()
        //if not in array, restart loop
        String[] newOld = {NEW,OLD};
        userType = errorCheckUserInput("Are you a new or old user?", newOld);



//        while (!userType.equals(NEW) && !userType.equals(OLD)){
//            System.out.println("Please input user type");
//            userType = getUserInput("Are you a new or old user? ").toLowerCase();
//            System.out.println("this is a " + userType);
//
//        }


        if (userType.equals(NEW)){
            //System.out.println("fuck yeah");

            getUserInfo();
        }
//        System.out.println("You can only be a new or old user." +
//                "Please input valid input. 'new' or 'old' ");

        //if new run getUserInfo

        //this will be used to essentially print everything, the nice thing is that we can just roll through
        //and hit print(all functions)
    }





    public static String getUserInfo() {
        //this function is used to get the user information

        //screen input
        System.out.println("You are a new user");


        String[] userInfo = new String[5];

        userInfo[0] = getUserInput("Please input your name: ");
        userInfo[1] = getUserInput("Please input your age: ");
        userInfo[2] = getUserInput("Please input your height: ");
        userInfo[3] = getUserInput("Please input your weight: ");
        userInfo[4] = getGoals();



        System.out.println("You're name is " + userInfo[0] +
                " You're age is " + userInfo[1] +
                " You're height is " + userInfo[2] +
                " You're weight is " + userInfo[3] +
                ". You want to " + userInfo[4]);

        String userInfoCorrect = getUserInput("Is this correct? ");

        if (userInfoCorrect.equals("yes") || userInfoCorrect.equals("Yes")) {
            System.out.println("check mate");
            try {
                File userFolder = new File(userInfo[0]);
                userFolder.mkdir();

//                TODO check if folder exist if (userFile.createNewFile()) {
                    System.out.println("File created: " + userFolder.getName());
                    FileWriter userNewFile =  new FileWriter(userInfo[0]+"/userinfo.txt");
                    userNewFile.write("Name,age,height,weight,goal/progress\n");
                    userNewFile.append(userInfo[0]+","+userInfo[1]+","+userInfo[2] +","+ userInfo[3]+","+userInfo[4]);
                    userNewFile.close();


                File userNewFoodFile =  new File(userInfo[0]+"/foodInfo.txt");
                userNewFoodFile.createNewFile();
                File userNewWorkoutFile =  new File(userInfo[0]+"/workoutInfo.txt");
                userNewWorkoutFile.createNewFile();


//               TODO }  else {
//                    System.out.println("File already exists.");
//                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            return userInfo[0];
        }



        System.out.println(Arrays.toString(userInfo));
        return "you havent done this yet :)";


            //where userInfor = [name, age, height, weight]

            //this be made simple to start and then become harder as we go and finish our code
            //for the time being just start with height, weight and ***exercise/eating
            //just create something that is in the



    }

    public static String userFile(){
        String userName = getUserInput("What is your name? ");
        File userFile = new File(userName);
        if (!userFile.exists()) {
            getUserInfo();
            return getUserInfo();
        } else {
//            System.out.println("poggers");
            return userName;
        }


    }



    public static String getGoals(){
        //do you want to lose weight, gain weight
        String goal = "";
        String [] goalTypes = {"loseweight","gainweight"};
        goal = errorCheckUserInput("Do you want to lose or gain weight?",goalTypes);
        goal.replace(" ","");
        if(goal.equals("loseweight")){
            System.out.println("Large");
            return goal;
        }
        System.out.println("Skinny");
        return goal;






        //similar to above this is what we depend on, if multiple people or just one
        //however this will be designed to set up how we go about doing this, we will have goals set and t
        //then have the program decide
    }

    public static float[] theTwoD(String foodInfo){
        String[] stringFoodInfo = foodInfo.split(",");
        float[] finalizedFoodInfo = new float[stringFoodInfo.length];
        for(int i = 0; i < stringFoodInfo.length; i++) {
            finalizedFoodInfo[i] = Float.parseFloat(stringFoodInfo[i]);
        }
        return finalizedFoodInfo;
    }



    public static void  readingFoodFiles(ArrayList<float[]> allFoodInfo,ArrayList<String> foodNames){
//        ArrayList<float[]> allFoodInfo = new ArrayList<float[]>(); ***for when you can use classes/objects in demo 2
//        ArrayList<String> foodNames = new ArrayList<String>();
        try {
            FileReader file_reader = new FileReader("foodpog.txt");
            BufferedReader buffered_reader = new BufferedReader(file_reader);
            String line = buffered_reader.readLine();
            line = buffered_reader.readLine();


            while (line != null) {
                String[] nameAndInfo = line.split(",",2);
                String foodInfo = nameAndInfo[1];
                float[] foodInfoFloat = theTwoD(foodInfo);
                allFoodInfo.add(foodInfoFloat);
                foodNames.add(nameAndInfo[0]);



//                float[] finalizedFoodInfo = new float[stringFoodInfo.length];
//                for(int i = 0; i < stringFoodInfo.length; i++) {
//                    finalizedFoodInfo[i] = Float.parseFloat(stringFoodInfo[i]);
//                }

                line = buffered_reader.readLine();
            }
//            System.out.println(foodNames.toString());
//            for(int i = 0; i <allFoodInfo.size(); i++){
//                System.out.println(Arrays.toString(allFoodInfo.get(i)));
//            }
        } catch (FileNotFoundException e) {
//Handle error
        } catch (IOException e){

        }
    }

    public static void  readingUserFoodFiles(ArrayList<float[]> userFoodInfo,String userName){
//        ArrayList<float[]> allFoodInfo = new ArrayList<float[]>(); ***for when you can use classes/objects in demo 2
//        ArrayList<String> foodNames = new ArrayList<String>();
        try {
            FileReader file_reader = new FileReader("./"+userName+"/foodinfo.txt");
            BufferedReader buffered_reader = new BufferedReader(file_reader);
            String line = buffered_reader.readLine();
            line = buffered_reader.readLine();


            while (line != null) {
                float[] dateAndData = theTwoD(line);
                userFoodInfo.add(dateAndData);
                String readableUserFood = userFoodInfo.toString();
                System.out.println(readableUserFood);



//                float[] finalizedFoodInfo = new float[stringFoodInfo.length];
//                for(int i = 0; i < stringFoodInfo.length; i++) {
//                    finalizedFoodInfo[i] = Float.parseFloat(stringFoodInfo[i]);
//                }

                line = buffered_reader.readLine();
            }
//            System.out.println(foodNames.toString());
//            for(int i = 0; i <allFoodInfo.size(); i++){
//                System.out.println(Arrays.toString(allFoodInfo.get(i)));
//            }
        } catch (FileNotFoundException e) {
//Handle error
        } catch (IOException e){

        }
    }

    public static void foodconsumed(String userName){
        String day = getUserInput("day: ");
        String month = getUserInput("month: ");
        String year = getUserInput("year: ");
        String calories = getUserInput("Please input the amount of calories: ");
        String protein = getUserInput("Please input the amount of protein(grams): ");
        String carbs = getUserInput("Please input the amount of carbs(grams): ");
        String fat = getUserInput("Please input the amount of fat(gram): ");
        String completeNewFood = day + "," + month + "," + year + "," + calories + "," + protein + "," + carbs + "," + fat;
        writingToFile("./"+userName+"/foodinfo.txt", completeNewFood);

    }

    public static void exercise(String userName){
        String day = getUserInput("day: ");
        String month = getUserInput("month: ");
        String year = getUserInput("year: ");
        String calories = getUserInput("Please input the amount of calories: ");
        String completeNewFood = day + "," + month + "," + year + "," + calories;
        writingToFile("./"+userName+"/workoutinfo.txt", completeNewFood);

    }


    public static void makingFileAdditions(ArrayList<float[]> allFoodInfo,ArrayList<String> foodNames){



    }

    public static boolean findFoodName(ArrayList<String> foodNames,String foodAddition){

        if (!foodNames.contains(foodAddition)) {
            return true;
        }
        System.out.println("Food already added to database");

        return false;
    }

    public static void writingToFile(String fileName,String lineToAppend){
        try{
            FileWriter fw = new FileWriter(fileName, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(lineToAppend);
            bw.newLine();
            bw.close();

        } catch (IOException e){
            System.out.println("yikes bro");
        } finally {
            System.out.println("goood job");
        }
    }

    public static void addingFood(ArrayList<float[]> allFoodInfo,ArrayList<String> foodNames){
        readingFoodFiles(allFoodInfo,foodNames);
        String foodAddition = getUserInput("What type of food would you like to add?");
        if(foodAddition.equals(quit)){

        }
        if(findFoodName(foodNames,foodAddition)) {
            float[] foodInfo = new float[5];
            String amountOfFood = getUserInput("Please input amount of food(if individual then type in grams, if a large object or a meal, type amount of in quantity): ");
            foodInfo[0] = Float.parseFloat(amountOfFood);
            String calories = getUserInput("Please input the amount of calories: ");
            foodInfo[1] = Float.parseFloat(calories);
            String protein = getUserInput("Please input the amount of protein(grams): ");
            foodInfo[2] = Float.parseFloat(protein);
            String carbs = getUserInput("Please input the amount of carbs(grams): ");
            foodInfo[3] = Float.parseFloat(carbs);
            String fat = getUserInput("Please input the amount of fat(gram): ");
            foodInfo[4] = Float.parseFloat(fat);
            String completeNewFood = foodAddition + "," + foodInfo[0] + "," + foodInfo[1] + "," + foodInfo[2] + "," + foodInfo[3] + "," + foodInfo[4];
            writingToFile("foodpog.txt", completeNewFood);
        }

    }





    public static void userInterface(ArrayList<float[]> allFoodInfo,ArrayList<String> foodNames, ArrayList<float[]> userFoodInfo){
        String menuInput = "";
        String [] menuOptions = {addfood,food,exercise,nutrition,weekly,monthly,overall,quit};
        String userName = userFile();
        while(true) {
            menuInput = errorCheckUserInput("What would you like to do?", menuOptions);
            if (menuInput.equals(addfood)) {
                addingFood(allFoodInfo, foodNames);
            }
            if (menuInput.equals(food)) {
                foodconsumed(userName);
            }
            if (menuInput.equals(exercise)) {
                exercise(userName);
            }
            if (menuInput.equals(nutrition)) {
                readingUserFoodFiles(userFoodInfo, userName);
            }
            if (menuInput.equals(weekly)) {

            }
            if (menuInput.equals(monthly)) {

            }
            if (menuInput.equals(overall)) {

            }
            if(menuInput.equals(quit)){
                System.out.println("Good bye!");
                break;
            }
        }

    }

    public static void newFood(){



    }

    public class dailyFood{





        //this is going to be our input of what has been eaten in a day
        //we can make this in the form of calories or food, depending on complexity and what we are
        //required/feel
    }

    public class dailyExercise{
        //we are using this to calculate the calories burned
        //for ease of this and most people not hard tracking the exact calories burned with a workout,
        //we are gonna seperate into c

    }

    public class personalProgress{
        //this will be just a matter of reading the data and doing the progress accordingly
        //we can do daily and monthly
        //need to create a file that run/stores data and that can be called upon

    }

    public class recommendedAction{
        //this can be in the way of food or exercise. Just take the collective data
    }

//
//    data is stored in basic data structures like Arrays/ArrayList/HashSets/HashMaps (not
//    objects), project should not have additional classes/objects outside of using internal java
//    one’s
//
//
//    proper use of public/private functions
//
//
//    proper use of final (constants)
//
//    proper use of static

}
