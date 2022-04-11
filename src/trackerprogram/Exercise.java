package trackerprogram;

public class Exercise {

        String exerciseName;
        float amount;
        float calories;


        public Exercise(String exerciseName, float amount, float calories){
            this.exerciseName = exerciseName;
            this.amount = amount;
            this.calories = calories;



        }
        @Override
        public String toString(){
            return convertToFileString();

        }

        public String convertToFileString(){
            String stringForFile = exerciseName + "," + amount+","+calories;



            return stringForFile;

        }






    }

