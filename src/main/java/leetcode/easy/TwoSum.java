package leetcode.easy;

import Common.PrintHelper;
import org.junit.Test;

public class TwoSum {
    @Test
    public void test() {
        int[] input = {2, 7, 11, 15};
        int target = 9;
        int[] output = twoSum(input, target);
        PrintHelper.printArray(output);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if ((nums[i]+nums[j]) == target){
                    arr[0] = i;
                    arr[1] = j;
                    return  arr;
                }
            }
        }
        return arr;
    }
}
