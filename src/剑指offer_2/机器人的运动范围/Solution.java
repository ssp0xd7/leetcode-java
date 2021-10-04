package 剑指offer_2.机器人的运动范围;

public class Solution {


    /**
     * DFS + 剪枝
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        int i = 0, j = 0;
        return moving(visited, k, i, j, m, n);
    }

    public int moving(boolean[][] visited, int k, int i, int j, int m, int n) {
        int count = 0;
        //剪枝
        if (i < 0 || j < 0 || i >= m || j >= n || (getDigitSum(i) + getDigitSum(j) > k) || visited[i][j]) {
            return count;
        }
        //标记已访问
        visited[i][j] = true;
        return 1 +
                moving(visited, k, i + 1, j, m, n) +
                moving(visited, k, i - 1, j, m, n) +
                moving(visited, k, i, j + 1, m, n) +
                moving(visited, k, i, j - 1, m, n);
    }

    /**
     * 求数位和
     *
     * @param x
     * @return
     */
    public int getDigitSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }

        return sum;
    }
}
