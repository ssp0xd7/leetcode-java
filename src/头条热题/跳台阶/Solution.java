package 头条热题.跳台阶;

import java.util.*;

public class Solution {

    public int jumpFloor(int target) {
        if (target == 0 || target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return jumpFloor(target - 1) + 1;
    }
}
