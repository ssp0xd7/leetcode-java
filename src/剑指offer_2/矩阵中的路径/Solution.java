package 剑指offer_2.矩阵中的路径;

public class Solution {

    /**
     * DFS+剪枝
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * dfs
     *
     * @param board
     * @param word
     * @param i
     * @param j
     * @param k
     * @return
     */
    public boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        //剪枝
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) {
            return false;
        }

        //提前返回正确结果
        if (k == word.length - 1) {
            return true;
        }
        //标记已访问
        board[i][j] = '\0';

        boolean res =   dfs(board, word, i + 1, j, k + 1) ||  //右
                        dfs(board, word, i - 1, j, k + 1) ||  //左
                        dfs(board, word, i, j + 1, k + 1) ||  //下
                        dfs(board, word, i, j - 1, k + 1);    //上

        //还原
        board[i][j] = word[k];
        return res;
    }
}
