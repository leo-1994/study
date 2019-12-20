package com.leo.study.coding;

/**
 * 有一副由NxN矩阵表示的图像，这里每个像素用一个int表示，请编写一个算法，在不占用额外内存空间的情况下(即不使用缓存矩阵)，将图像顺时针旋转90度。
 * <p>
 * 给定一个NxN的矩阵，和矩阵的阶数N,请返回旋转后的NxN矩阵,保证N小于等于500，图像元素小于等于256。
 * <p>
 * 测试样例：
 * [[1,2,3],[4,5,6],[7,8,9]],3
 * 返回：[[7,4,1],[8,5,2],[9,6,3]]
 *
 * @author chao.li@quvideo.com
 * @date 2019/12/11 23:20
 */
public class No6 {
    // 1,2,3    7,4,1
    // 4,5,6    8,5,2
    // 7,8,9    9,6,3

    // 1,2,3,4          13,9,5,1
    // 5,6,7,8          14,10,6,2
    // 9,10,11,12       15,11,7,3
    // 13,14,15,16      16,12,8,4
    // 0,0->0,2
    // 0,1->1,2
    // 1,0->0,1
    // 1,1->1,1
    // 2,0->0,0
    // x=y,y=2-x
    public int[][] transformImage(int[][] mat, int n) {
        // write code here
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                rotate(mat, i, j, n);
            }
        }
        return mat;
    }

    private void rotate(int[][] mat, int i, int j, int n) {
        // a->b->c->d->a
        int t = mat[i][j];
        mat[i][j] = mat[n - 1 - j][i];
        mat[n - 1 - j][i] = mat[n - 1 - i][n - 1 - j];
        mat[n - 1 - i][n - 1 - j] = mat[j][n - 1 - i];
        mat[j][n - 1 - i] = t;
    }

    private void swap(int[][] mat, int x1, int y1, int x2, int y2) {
        int t = mat[x1][y1];
        mat[x1][y1] = mat[x2][y2];
        mat[x2][y2] = t;
    }

    public static void main(String[] args) {
//        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        new No6().transformImage(mat, 3);
        int[][] mat = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        new No6().transformImage(mat, 4);
    }
}
