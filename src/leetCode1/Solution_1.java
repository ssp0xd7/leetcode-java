package leetCode1;

/**
 * Created by Kevin_Mit on 2017/3/14.
 */
public class Solution_1 {

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        for(int i: Solution_1.twoSum(nums,target)){
            System.out.println(i);
        }
     }
}
