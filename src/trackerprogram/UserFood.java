package trackerprogram;

public class UserFood {
    int day;
    int month;
    int year;
    float calories;
    float protein;
    float carbs;
    float fat;

    public UserFood(int day, int month, int year, float calories, float protein, float fat, float carbs){
        this.day = day;
        this.month = month;
        this.year = year;
        this.calories = calories;
        this.protein = protein;
        this.carbs = carbs;
        this.fat = fat;



    }
    @Override
    public String toString(){
        return convertToFileString();

    }

    public String convertToFileString(){
        String stringForFile = day + "," + month + "," + year +","+calories+","+protein+","+fat+","+carbs;



        return stringForFile;

    }


}
