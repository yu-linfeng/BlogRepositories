package com.coderbuff.sword.s13;

/**
 * Description:
 * 机器人的运动范围
 * 2019-06-18
 * Created with OKevin.
 */
public class Solution {
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows <= 0 || cols <= 0) {
            return 0;
        }
        boolean[] visited = new boolean[rows * cols];
        int count = movingCountCore(threshold, rows, cols, 0, 0, visited);
        return count;
    }

    private int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        int count = 0;
        if (check(threshold, rows, cols, row, col, visited)) {
            visited[row * cols + col] = true;
            /**
             * 当前访问到了(i, j)坐标，此时则继续访问(i - 1, j)、(i, j - 1)、(i + 1, j)、(i, j + 1)
             */
            count = 1 + movingCountCore(threshold, rows, cols, row - 1, col, visited) + movingCountCore(threshold, rows, cols, row, col-1, visited) + movingCountCore(threshold, rows, cols, row + 1, col, visited) + movingCountCore(threshold, rows, cols, row + 1, col, visited);
        }
        return count;
    }

    private boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        //横坐标与纵坐标的数位和相加小于阈值，且没有访问过
        if (row >= 0 && row < rows && col >= 0 && col < cols && (getDigitSum(row) + getDigitSum(col) <= threshold) && !visited[row * cols + col]) {
            return true;
        }
        return false;
    }

    /**
     * 计算数位和
     * 例如：85的数位和为8+5=13
     * 计算过程：
     * 85 % 10 = 5（个位）
     * 85 / 10 = 8（移除个位）
     * 8 % 10 = 8（十位）
     * 5 + 8 = 13
     * @param number 数字
     * @return 数位和
     */
    private int getDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }
}
