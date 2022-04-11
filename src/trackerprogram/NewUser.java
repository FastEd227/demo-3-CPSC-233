package trackerprogram;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class NewUser {


    public static String getUserInfo() {
        //this function is used to get the user information

        //screen input
        System.out.println("You are a new user");


        String[] userInfo = new String[5];

        userInfo[0] = InputGathering.getUserInput("Please input your name: ");
        userInfo[1] = InputGathering.getUserInput("Please input your age: ");
        userInfo[2] = InputGathering.getUserInput("Please input your height: ");
        userInfo[3] = InputGathering.getUserInput("Please input your weight: ");
        userInfo[4] = getGoals();



        System.out.println("You're name is " + userInfo[0] +
                " You're age is " + userInfo[1] +
                " You're height is " + userInfo[2] +
                " You're weight is " + userInfo[3] +
                ". You want to " + userInfo[4]);

        String userInfoCorrect = InputGathering.getUserInput("Is this correct? ");

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
        return "you haven't done this yet :)";


        //where userInfor = [name, age, height, weight]

        //this be made simple to start and then become harder as we go and finish our code
        //for the time being just start with height, weight and ***exercise/eating
        //just create something that is in the



    }

    public static String getGoals(){
        //do you want to lose weight, gain weight
        String goal = "";
        String [] goalTypes = {"loseweight","gainweight"};
        goal = InputGathering.errorCheckUserInput("Do you want to lose or gain weight?",goalTypes);
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
}
