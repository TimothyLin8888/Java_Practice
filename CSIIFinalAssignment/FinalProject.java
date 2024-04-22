import java.util.*;
import java.io.*;
public class FinalProject {

    public static Account checkName(
        ArrayList<Account> accounts,
        boolean check,
        Scanner scnr
    ) {
        boolean run = true;
        String accountName = "";
        while (run) {
            try {
                System.out.println("Select your account: ");
                accountName = scnr.nextLine();
                if (accountName.length() == 0) {
                    throw new InputMismatchException("Name can't be an empty string");
                }
                for (Account a : accounts) {
                    if (a.getName().toLowerCase().equals(accountName.toLowerCase())) {
                        System.out.println(a.toString());
                        run = false;
                        return a;
                    }
                }

            } catch (InputMismatchException ime) { //exception handling
                System.out.println(ime.getMessage());
            }
        }
        Account account = new Account("",0,false);
        return account;
    }

public static void writeAccountDetails(Account a){
    try{
    FileOutputStream fs = new FileOutputStream("AccountDetails.csv");
    PrintWriter pw = new PrintWriter(fs);
    pw.write(a.toString());
    pw.close();
    fs.close();
    } catch (FileNotFoundException fnfe){
        System.out.println("File not found.");
    } catch (IOException ioe){
        System.out.println("IO Exception");
    }
}

public static void changeAccountDetails(Account a, Scanner scnr){
    while (true) {
    System.out.print("Would you like to change Name (n)/isPaidMember (p)/age (a)/quit (q) ");
    try{
    String letter = scnr.nextLine();
    if (letter.toLowerCase().equals("n")){
        System.out.print("What name would you like to switch it to? ");
        String name = scnr.nextLine();
        a.setName(name);
    } else if (letter.toLowerCase().equals("p")){
        boolean running = true;
        while (running) {
        System.out.print("Paid member or no? Y/N ");
        String isPaidMember = scnr.nextLine();
        if (isPaidMember.toLowerCase().equals("y")){
            a.setIsPaidMember(true);
            running = false;
        } else if (isPaidMember.toLowerCase().equals("n")){
            a.setIsPaidMember(false);
            running = false;
        } else {
            throw new IllegalArgumentException("Not y or n");
        }
        }
    } else if (letter.toLowerCase().equals("a")){
        System.out.print("What age: ");
        int age = scnr.nextInt();
        a.setAge(age);
        scnr.nextLine();
    } else if (letter.toLowerCase().equals("q")){
        break;
    } else {
        throw new IllegalArgumentException("Not a valid option");
    }
    } catch (InputMismatchException ime){
        System.out.println("Wrong input");
    } catch (IllegalArgumentException iae){
        System.out.println(iae.getMessage());
    }
    }
}
    
public static void main(String[] args) {
    Scanner scnr = new Scanner(System. in);
    boolean check = false;
    boolean run = true;
    ArrayList<Account> accounts = new ArrayList<>();
    try {
        File file = new File("accounts.txt"); //opening accounts.csv
        try (Scanner scan = new Scanner(file)) {
          while (scan.hasNext()) { //this loop should only just put all the accounts into a list
              String line = scan.nextLine();
              String[] lineList = line.split(",");
              //name,ID,isPaidMember,age
              if (!lineList[0].equals("name")) {
                  String name = lineList[0]; //String
                  int ID = Integer.parseInt(lineList[1]); //Int
                  boolean isPaidMember = Boolean.parseBoolean(lineList[2]); //Boolean
                  if (lineList.length == 4){
                  int age = Integer.parseInt(lineList[3]); //Int
                  Account acc = new Account(name, ID, isPaidMember, age); //making Account object
                  accounts.add(acc);
                  } else {
                      Account acc = new Account(name,ID,isPaidMember);
                      accounts.add(acc);
                  }
              }
          }
        } catch (NumberFormatException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
    } catch (FileNotFoundException fnfe) { //catching that exception
        System.out.println("File not found");
    }
    Account a = checkName(accounts, check, scnr);
    while (run) {
    System.out.print("What would you like to do: Print/Change Account Details/Quit (P/C/Q)");
    try{
    String choice = scnr.nextLine();
    if (choice.toLowerCase().equals("p")){
        writeAccountDetails(a);
    } else if (choice.toLowerCase().equals("c")){
        changeAccountDetails(a,scnr);
    } else if (choice.toLowerCase().equals("q")){
        break;
    } else {
        throw new IllegalArgumentException("That is none of the options.");
    }
    } catch (InputMismatchException ime){
        System.out.println("Wrong input.");
    } catch (IllegalArgumentException iae){
        System.out.println(iae.getMessage());
    }
}
}
}
