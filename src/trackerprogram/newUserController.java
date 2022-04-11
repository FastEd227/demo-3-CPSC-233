package trackerprogram;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class newUserController {

    @FXML
    private TextArea newUserDetails;

    @FXML
    private TextArea newName;
    @FXML
    private TextArea newAge;
    @FXML
    private TextArea newHeight;
    @FXML
    private TextArea newWeight;
    @FXML
    private TextArea newGoal;

    public void addNewUser(ActionEvent event){



        String[] userInfo = new String[5];

        userInfo[0] = newName.getText();
        userInfo[1] = newAge.getText();
        userInfo[2] = newHeight.getText();
        userInfo[3] = newWeight.getText();
//        userInfo[4] = getGoals();



        newUserDetails.setText("You're name is " + userInfo[0] +
                " You're age is " + userInfo[1] + "\n" +
                " You're height is " + userInfo[2] + "\n" +
                " You're weight is " + userInfo[3] +
//                ". You want to " + userInfo[4] +
                "\n" + "Is This correct?");





    }

    public void confirmNewUser(ActionEvent event){

            try {
                File userFolder = new File(newName.getText());
                userFolder.mkdir();

//                TODO check if folder exist if (userFile.createNewFile()) {
                System.out.println("File created: " + userFolder.getName());
                FileWriter userNewFile =  new FileWriter(newName.getText()+"/userinfo.txt");
                userNewFile.write("Name,age,height,weight,goal/progress\n");
                userNewFile.append(newName.getText()+","+newAge.getText()+","+newHeight.getText() +","+ newWeight.getText());
                userNewFile.close();


                File userNewFoodFile =  new File(newName.getText()+"/foodInfo.txt");
                userNewFoodFile.createNewFile();
                File userNewWorkoutFile =  new File(newName.getText()+"/workoutInfo.txt");
                userNewWorkoutFile.createNewFile();

                Testrun1.userName = newName.getText();


//               TODO }  else {
//                    System.out.println("File already exists.");
//                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
    }


}

