package 剑指offer_2.数组中重复的数字;

import java.util.HashSet;
import java.util.Set;

public class Solution_1 {

    static class Solution {

        /**
         * hashset
         *
         * @param nums
         * @return
         */
        public int findRepeatNumber(int[] nums) {
            Set<Integer> set = new HashSet<Integer>();
            for (int num : nums) {
                if (set.contains(num)) {
                    return num;
                }
                set.add(num);
            }
            return 0;
        }
    }
}
