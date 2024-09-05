package Calculator;

public class Calculations {
    int [] nums = {4,3,2,6,4};
    System.out.println(mean(nums));
    Statistics stats = new Statistics();
    
}

public static int mean(int[] nums){
    int total = 0;
    for (int i = 0; i < nums.length; i++){
        total += nums[i];
    }
    return total / nums.length;
}