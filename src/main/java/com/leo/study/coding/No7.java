package com.leo.study.coding;

/**
 * 请编写一个算法，若N阶方阵中某个元素为0，则将其所在的行与列清零。
 * <p>
 * 给定一个N阶方阵int[][](C++中为vector<vector><int>>)mat和矩阵的阶数n，
 * 请返回完成操作后的int[][]方阵(C++中为vector<vector><int>>)，
 * 保证n小于等于300，矩阵中的元素为int范围内。
 *
 * @author chao.li@quvideo.com
 * @date 2019/12/12 16:51
 */
public class No7 {
    public int[][] clearZero(int[][] mat, int n) {
        boolean[] rowFlags = new boolean[n];
        boolean[] colFlags = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    rowFlags[i] = true;
                    colFlags[j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (rowFlags[i]) {
                cleanRow(mat, i, n);
            }
            if (colFlags[i]) {
                cleanColumn(mat, i, n);
            }
        }
        return mat;
    }

    private void cleanRow(int[][] mat, int row, int n) {
        for (int i = 0; i < n; i++) {
            mat[row][i] = 0;
        }
    }

    private void cleanColumn(int[][] mat, int column, int n) {
        for (int i = 0; i < n; i++) {
            mat[i][column] = 0;
        }
    }
}
