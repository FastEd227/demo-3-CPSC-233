package trackerprogram;

public class MainMenu {
    public static final String ADDFOOD = "addfood";
    public static final String NUTRITION = "checknutrition";
    public static final String EXERCISE = "checkexercise";
    public static final String ADDEXERCISE = "addexercise";
    public static final String QUIT = "quit";
    public static final String EXISTING = "existinguser";
    public static final String ADDUSER = "adduser";

    public void mainMenu(){

    }

    public static void startMainMenu(){
        //Make into GUI later pog

        String menuDisplay = "What would you like to do? \n adduser or existinguser";
        String menuSelection = InputGathering.getUserInput(menuDisplay);
//        if(menuSelection.equals(ADDFOOD)){
//            //addFood();
//
//        }
        if(menuSelection.equals(EXISTING)){
            User.userMenu();

        }

        if(menuSelection.equals(ADDUSER)){
            NewUser.getUserInfo();
        }

        System.out.println("You are leaving, good bye!");
//        if(menuSelection.equals(ADDEXERCISE)){
////            System.out.println();
//
//            //addExercise();
//        }

        String menuInput = "";
        String [] menuOptions = {ADDFOOD,NUTRITION,EXERCISE,ADDEXERCISE,QUIT};
//        while(true) {
//            menuInput = InputGathering.errorCheckUserInput("What would you like to do?", menuOptions);
//            if (menuInput.equals(ADDFOOD)) {
//                addUserFood(food,username);
//            }
//            if (menuInput.equals(NUTRITION)) {
//                foodConsumed(food);
//            }
//            if (menuInput.equals(ADDEXERCISE)) {
//                addUserExercise(exercise,username);
//            }
//            if (menuInput.equals(EXERCISE)) {
//                exerciseCompleted(exercise);
//
//            }
//
//            if(menuInput.equals(QUIT)){
//                System.out.println("Good bye!");
//                break;
//            }
//        }
    }



}
