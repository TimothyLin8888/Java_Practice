import java.io.*;
import java.util.*;
public class Grades {
    public static void main(String[] args) {
        //reads the grades.txt to grab the names and grades on every line
        // creates list to hold onto the names and grades each
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> grades = new ArrayList<>();
        try{
            File file = new File("grades.txt");
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()){
                String data = scan.nextLine();
                // made a try and catch to determine if it is a string or an int
                //If error then it is a string
                try {
                    int num = Integer.parseInt(data);
                    grades.add(num);
                } catch (NumberFormatException nfe){
                    names.add(data);
                }
            }
            scan.close();
            System.out.println("Average " + average(grades));
            System.out.println("Highest Grade:");
            System.out.println(highestGrade(names,grades));
            System.out.println("Lowest Grade:");
            System.out.println(lowestGrade(names,grades));
        } catch (FileNotFoundException fnf){
            System.out.println("File not found");
        }
    }
    public static double average(ArrayList<Integer> grades){
        double total = 0;
        for (int i = 0; i < grades.size(); i++){
            total += grades.get(i);
        }
        return total / grades.size();
    }
    public static String highestGrade(ArrayList<String> names, ArrayList<Integer> grades){
        int currentHighest = 0;
        int highestIndex = 0;
        for (int i = 0; i < grades.size(); i++){
            if (grades.get(i) > currentHighest){
                currentHighest = grades.get(i);
                highestIndex = i;
            }
        }
        String returnString = "Student: " + names.get(highestIndex) + "\nGrade: " + grades.get(highestIndex);
        return returnString;
    }
    public static String lowestGrade(ArrayList<String> names, ArrayList<Integer> grades){
        int currentHighest = 100000;
        int highestIndex = 0;
        for (int i = 0; i < grades.size(); i++){
            if (grades.get(i) < currentHighest){
                currentHighest = grades.get(i);
                highestIndex = i;
            }
        }
        String returnString = "Student: " + names.get(highestIndex) + "\nGrade: " + grades.get(highestIndex);
        return returnString;
    }
}
