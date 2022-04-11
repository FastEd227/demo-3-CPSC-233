package trackerprogram;

public class UserExercise {
    int day;
    int month;
    int year;
    float calories;

    public UserExercise(int day, int month, int year, float calories){
        this.day = day;
        this.month = month;
        this.year = year;
        this.calories = calories;


    }
    @Override
    public String toString(){
        return convertToFileString();

    }

    public String convertToFileString(){
        String stringForExerciseFile = day + "," + month + "," + year +","+calories;



        return stringForExerciseFile;

    }

}
