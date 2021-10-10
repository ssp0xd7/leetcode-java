package 剑指offer_2.数组中数字出现的次数;

public class Solution {

    public int[] singleNumbers(int[] nums) {
        int x=0,y=0;
        int n=0,m=1;
        for(int num:nums){
            n^=num;

            //n=x^y
        }
        while((n & m) == 0){
            m <<= 1;
            //循环左移，找到第一个不相等的数位，即可以用这一位区分x和y
        }
        for(int num:nums){
            if((num&m) == 0){
                x^=num;
            }else{
                y^=num;
            }
        }
        return new int[]{x,y};
    }
}
