package 剑指offer_2.翻转单词顺序;

public class Solution {

    public String reverseWords(String s) {
        s = s.trim();

        int i = s.length() - 1, j = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            //找到单词左边界
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            // 添加单词
            sb.append(s.substring(i + 1, j + 1));
            // 添加空格
            sb.append(" ");

            //跳过单词左边空格
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            //j与i归位，重复流程
            j = i;
        }

        return sb.toString().trim();
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        int row = 0;
        while (row <= matrix.length - 2) {
            int column = 0;
            while (column <= matrix[0].length - 2) {
                int tempRow = row;
                int tempColumn = column;
                int temp = matrix[tempRow][tempColumn];
                tempRow++;
                tempColumn++;
                while (tempColumn < matrix[0].length && tempRow < matrix.length) {
                    if (matrix[tempRow][tempColumn] == temp) {
                        tempRow++;
                        tempColumn++;
                    } else {
                        return false;
                    }
                }

                column++;
            }
            row++;
        }


        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {36, 59, 71, 15, 26, 82, 87},
                {56, 36, 59, 71, 15, 26, 82},
                {15, 0, 36, 59, 71, 15, 26}};
        System.out.println(isToeplitzMatrix(matrix));
    }
}
