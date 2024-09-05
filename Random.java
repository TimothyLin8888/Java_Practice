public class Random {
   public static void main(String[] args) {
    double randomValue = 0;
    int counter = 0;
    while (randomValue != 1.0){
        randomValue = Math.floor(Math.random() * 2);
        System.out.println(randomValue);
        counter++;
    }
    System.out.println("Attempt " + counter + ", we got " + randomValue);
    System.out.println("That's a " + Math.pow(.5,counter) + "% chance");
   }
}
