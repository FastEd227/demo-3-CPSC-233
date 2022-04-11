package trackerprogram;
import java.io.*;

import java.util.*;

public class InputGathering {

    static Scanner userInput = new Scanner(System.in);
    public static String getUserInput(String message){
        System.out.println(message);
        String input = userInput.nextLine();
        input = input.replaceAll("\s+","");
//        System.out.println("THis is the input: " +input);
        return input;
    }



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

    public static float[] theTwoD(String foodInfo){
        String[] stringFoodInfo = foodInfo.split(",");
        float[] finalizedFoodInfo = new float[stringFoodInfo.length];
        for(int i = 0; i < stringFoodInfo.length; i++) {
            finalizedFoodInfo[i] = Float.parseFloat(stringFoodInfo[i]);
        }
        return finalizedFoodInfo;
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

    public static boolean checkIfInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    public static boolean checkIfFloat(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (i = 0; i < length; i++) {
            char c = str.charAt(i);
            if ((c < '0' || c > '9') && c != '.') {
                return false;
            }
        }

        return true;
    }
}
