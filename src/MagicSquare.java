public class MagicSquare {

    /**
     *
     * @param array2d
     * @return the sum of the first row in array2d.
     */
    public static int calculateCheckSum(int[][] array2d) {
        int sum = 0;
        for(int col: array2d[0]){
            sum += col;
        }
        return sum;
    }

    /**
     *
     * @param array2d
     * @param checkSum
     * @return whether the sum of each row in array2d is equal to checkSum or not.
     *         Because we have already determined the sum of the first row
     *         via the method 'calculateCheckSum', this method can begin
     *         iterating from the second row.
     */
    public static boolean magicRows(int[][] array2d, int checkSum) {
        int sum = 0;
        for(int row = 0; row < array2d.length; row++){
            sum = 0;
            for(int col = 0; col < array2d[row].length; col++){
                sum += array2d[row][col];
            }
            if(sum != checkSum){
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param array2d
     * @param checkSum
     * @return whether the sum of each column in array2d is equal to checkSum or not.
     */
    public static boolean magicColumns(int[][] array2d, int checkSum) {

        for (int col = 0; col < array2d[0].length; col++){
            int sum = 0;
            for (int row = 0; row < array2d.length; row++){
                sum += array2d[row][col];
            }
            if (sum != checkSum){
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param array2d
     * @param checkSum
     * @return whether the sum of each of the two main diagonals is equal to checkSum or not.
     */
    public static boolean magicDiagonals(int[][] array2d, int checkSum) {
        int diagonal1 = 0;
        int diagonal2 = 0;

        for(int row = 0; row < array2d.length; row++){
            diagonal1 += array2d[row][row];
        }

        for(int row = 0; row < array2d.length; row++){
            diagonal2 += array2d[row][array2d.length-row-1];
        }

        if(diagonal1 == checkSum && diagonal2 == checkSum){
            return true;
        }
        return false;

    }

    /**
     *
     * @param array2d
     * @return whether array2d is magic or not.
     */
    public static boolean isMagic(int[][] array2d) {
        int checkSum = calculateCheckSum(array2d);
        boolean row = magicRows(array2d, checkSum);
        boolean col = magicColumns(array2d, checkSum);
        boolean diagonals = magicDiagonals(array2d,checkSum);

        if(row == true && col == true && diagonals ==true){
            return true;
        }
        return false;

    }

}
