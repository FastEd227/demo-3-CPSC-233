package trackerprogram;

public class Food {
    String foodName;
    float amount;
    float calories;
    float protein;
    float carbs;
    float fat;

    public Food(String foodName, float amount, float calories, float protein, float fat, float carbs){
        this.foodName = foodName;
        this.amount = amount;
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
        String stringForFile = foodName + "," + amount+","+calories+","+protein+","+fat+","+carbs;



        return stringForFile;

    }






}
