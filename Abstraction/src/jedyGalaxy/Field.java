package jedyGalaxy;

public class Field {
    private int[][] matrix;

    public Field(int[][] matrix) {
        this.matrix = matrix;
        this.setFieldValues();
    }

    private void setFieldValues() {
        int value = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                matrix[r][c] = value++;
            }
        }
    }

    public int getLength() {
        return this.matrix.length;
    }

    public int getDimensionLength(int dimension) {
        return this.matrix[dimension].length;
    }

    public void setCell(int row, int col, int newValue) {
        this.matrix[row][col] = newValue;
    }

    public long getCell(int row, int col) {
        return this.matrix[row][col];
    }
}
