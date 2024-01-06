class Solution {
    public void rotate(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            int k = 0;
            for (int j = matrix.length - 1; j >= 0; j--) {
                result[i][k++] = matrix[j][i];
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = result[i][j];
            }
        }
    }
}
