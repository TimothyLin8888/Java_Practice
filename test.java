public class test {
    public static void main(String[] args) {
        int i = 12345678;
        String stringNumber = String.valueOf(i);
        stringNumber = stringNumber.substring(Math.max(stringNumber.length() - 2, 0));
        System.out.println(stringNumber);
    }
}
