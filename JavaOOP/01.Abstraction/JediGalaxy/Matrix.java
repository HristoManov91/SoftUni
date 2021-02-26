package JediGalaxy;

public class Matrix {
    private int[][] matrix;

    public Matrix (int startValue , int x, int y){
        this.matrix = createMatrix(startValue , x , y);
    }

    private int[][] createMatrix(int startValue, int x, int y) {
        int[][] matrix = new int[x][y];
        for (int r = 0; r < x; r++) {
            for (int c = 0; c < y; c++) {
                matrix[r][c] = startValue++;
            }
        }
        return matrix;
    }

    public void evilDestroyCoordinates(int row , int col){
        while (row >= 0 && col >= 0) {
            if (row < matrix.length && col < matrix[row].length) {
                this.matrix[row][col] = 0;
            }
            row--;
            col--;
        }
    }

    public long collectCoordinates(int rowIvo, int colIvo) {
        long sum = 0;
        while (rowIvo >= 0 && colIvo < matrix[1].length) {
            if (rowIvo < matrix.length && colIvo >= 0) {
                sum += matrix[rowIvo][colIvo];
            }
            colIvo++;
            rowIvo--;
        }
        return sum;
    }
}
