package 剑指offer_2.扑克牌中的顺子;

import java.util.HashSet;
import java.util.Set;

public class Solution {


    /**
     * max-min<5
     *
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {
        Set<Integer> dic = new HashSet<Integer>();
        int max = 0, min = 14;
        for (int num : nums) {
            //大小王跳过即可
            if (num == 0) {
                continue;
            }

            max = Math.max(max, num); // 最大牌
            min = Math.min(min, num); // 最小牌

            // 若有重复，提前返回 false
            if (dic.contains(num)) {
                return false;
            }
            dic.add(num); // 添加此牌至 Set
        }
        return max - min < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }
}
