package 剑指offer_2.数组中出现次数超过一半的数字;

public class Solution {

    public int majorityElement(int[] nums) {
        int suspect = 0, votes = 0;
        for (int num : nums) {
            if (votes == 0) {
                suspect = num;
            }
            int currVote = num == suspect ? 1 : -1;
            votes += currVote;
        }

        return suspect;
    }
}
