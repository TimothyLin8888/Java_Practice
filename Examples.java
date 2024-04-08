import java.util.*;
import java.io.*;
public class Examples {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("How much loops do you want: ");
        int numOfLoops = scan.nextInt();
        String message = "Hello World.";
        String numberedMessage;
        try {
            FileOutputStream fs = new FileOutputStream("Hello Worlds.txt");
            PrintWriter pw = new PrintWriter(fs);
        for (int i = 1; i <= numOfLoops; i++){
            String stringNumber = String.valueOf(i);
            stringNumber = stringNumber.substring(Math.max(stringNumber.length() - 2, 0));
            int newI = Integer.parseInt(stringNumber);
            if (newI == 11 || newI == 12 || newI == 13){
                numberedMessage = i + "th " + message;
            } else if (i % 10 == 1){
                numberedMessage = i + "st " + message;
                } else if (i % 10 == 2){
                numberedMessage = i + "nd " + message;
                } else if (i % 10 == 3){
                numberedMessage = i + "rd " + message;
                } else {
                numberedMessage = i + "th " + message;
                }
            
        pw.write(numberedMessage + "\n");
        }
        pw.close();
        fs.close();
    } catch (FileNotFoundException fnf){
        System.out.println("File not found.");
    } catch (IOException io){
        System.out.println("An IO exception");
        
    }
}
}
