import java.util.*;
import java.io.*;
public class Examples {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("How much loops do you want: ");
        int numOfLoops = scan.nextInt();
        String message = "Hello World.";
        for (int i = 1; i <= numOfLoops; i++){
            if (i == 11 || i == 12 || i == 13){
                System.out.println(i + "th " + message);
            } else if (i % 10 == 1){
                System.out.println(i + "st " + message);
                } else if (i % 10 == 2){
                    System.out.println(i + "nd " + message);
                } else if (i % 10 == 3){
                    System.out.println(i + "rd " + message);
                } else {
                    System.out.println(i + "th " + message);
                }
        }
        try {
        FileOutputStream fs = new FileOutputStream("Hello Worlds.txt");
        PrintWriter pw = new PrintWriter(fs);
        pw.write("Let's go!!!!");
        pw.close();
        fs.close();
        } catch (FileNotFoundException fnf){
            System.out.println("File not found.");
        } catch (IOException io){
            System.out.println("An IO exception");
        }
    }
}
