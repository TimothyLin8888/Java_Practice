package Calculator;

import java.util.Arrays;

public class Statistics {
    public static int mean(int[] nums){
        int total = 0;
        for (int i = 0; i < nums.length; i++){
            total += nums[i];
        }
        return total / nums.length;
    }
    public static int median(int[] nums){
        double halfway = nums.length / 2;
        Arrays.sort(nums);
        System.out.println(9/2);
        System.out.println(halfway == (int) halfway);
        if (halfway == (int) halfway){
            int[] twoMidNums = {nums[(int) halfway], nums[(int) (halfway + 1)]};
            return mean(twoMidNums);
        } else {
            return nums[(int) halfway];
        }
    }
    public static void main(String[] args) {
        int[] nums = {4,3,2,6,2,10,6,7,3}; // mean is 4.7777777778, med is 4
        System.out.println(mean(nums));
        System.out.println(median(nums));
    }
}
