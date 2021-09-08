package 剑指offer_2.顺时针打印矩阵;

public class Solution_1 {

    /**
     * 模拟法
     *
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int rows = matrix.length;
        int columns = matrix[0].length;

        int[][] done = new int[rows][columns];
        int total = rows * columns;
        int[] res = new int[total];

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directIndex = 0;
        int row = 0, colum = 0;
        for (int i = 0; i < total; i++) {
            res[i] = matrix[row][colum];
            done[row][colum] = 1;

            int nextRow = row + directions[directIndex][0];
            int nextColumn = colum + directions[directIndex][1];
            // 行溢出或者行遍历结束或者列溢出或者列遍历结束或者下一个节点已经遍历过
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || done[nextRow][nextColumn] == 1) {
                directIndex = (directIndex + 1) % 4;
            }
            row += directions[directIndex][0];
            colum += directions[directIndex][1];
        }

        return res;
    }
}
