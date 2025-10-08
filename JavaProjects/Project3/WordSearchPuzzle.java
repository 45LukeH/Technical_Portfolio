import java.util.Stack;

public class WordSearchPuzzle implements WordSearchInterface {

    private char[][] puzzle;
    private int size;
    private static Direction[] directions = {Direction.N, Direction.E, 
                                             Direction.S, Direction.W, 
                                             Direction.NE, 
                                             Direction.SE, 
                                             Direction.SW, 
                                             Direction.NW};


    /*
     * Returns a completed Stack<Cell> that represents a found
     * word in the puzzle where the bottom of the Stack represents
     * the beginning of the word and the top of the Stack represents 
     * the end of the word. Each cell in the Stack holds the row and
     * column of the letter that the Cell represents. Returns null 
     * if the word cannot be found in the puzzle.
     */
    @Override
    public Stack<Cell> findWord(String word) {
        boolean result = false;
        Stack<Cell> positions = new Stack<>();

        for(int i=0; !result && i<puzzle.length; i++){
            for(int j=0; !result && j<puzzle.length; j++){
                if(Character.toUpperCase(puzzle[i][j]) == 
                    Character.toUpperCase(word.charAt(0))) {
                    StringBuilder temp = new StringBuilder();
                    positions.push(new Cell(i, j));
                    temp.append(Character.toUpperCase(puzzle[i][j]));
                    puzzle[i][j] = Character.toUpperCase(puzzle[i][j]);
                    if(solve(i, j, temp, word, positions)){
                        result = true;
                        break;
                    }
                    puzzle[i][j] = Character.toLowerCase(puzzle[i][j]);
                    positions.pop();
                }
            }
        }
        if(result){
            for(Cell c: positions){
                puzzle[c.row()][c.col()] = 
                    Character.toLowerCase(puzzle[c.row()][c.col()]);
            }
            return positions;
        } else {
            return null;
        }
    }

    /*
     * Returns whether or not `wordToFind` exists in the puzzle. 
     * `current` should be a prefix of `wordToFind`. The `solve` 
     * method should start at (`row, col`) and determine if the 
     * rest of the letters missing from `current` can be found 
     * in a path so that `current` equals `wordToFind`.
     */
    private boolean solve(int row, int col, StringBuilder current, 
                            String wordToFind, Stack<Cell> positions){
        // TODO: implement this method
        // base case - if word is found, return true and end method
        if (current.toString().equalsIgnoreCase(wordToFind)) {
            return true;
        }
        // recursive chunk of the method, try to move in every possible direction to find next letter
        for (Direction direction : directions) {
            int newRow = nextRow(row, direction);
            int newCol = nextCol(col, direction);
            // now, check if new row/col is valid
            if (isValid(newRow, newCol)) {
                //make sure the new letter forms a prefix too
                if (isPrefix(current.toString() + puzzle[newRow][newCol], wordToFind)) {
                    // if its valid, add it to the stack, append the letter to sequence, and mark
                    // the letter off so it cannot be reused
                    positions.push(new Cell(newRow, newCol));
                    current.append(Character.toUpperCase(puzzle[newRow][newCol]));
                    puzzle[newRow][newCol] = Character.toUpperCase(puzzle[newRow][newCol]);
                    // call the method to check if the word is formed
                    if (solve(newRow, newCol, current, wordToFind, positions)) {
                        return true;
                    }
                    // if the word isnt found in the path it takes, backtrack and try new directiins
                    // restore the letters to lowercase, remove the last character used in the sequence(we're
                    // backtracking because the letter doesnt work), and take it out of the stack
                    puzzle[newRow][newCol] = Character.toLowerCase(puzzle[newRow][newCol]);
                    current.deleteCharAt(current.length() - 1);
                    positions.pop();
                }
            }
        }
        // will only occur if a valid path is not found
        return false;
    }

    /*
     * Returns whether or not the cell at (row, col) is in bounds 
     * and the letter there has not yet been used when searching
     * for the current word.
     */
    private boolean isValid(int row, int col){
        boolean result = false;
        if((row >= 0) && (col >= 0) 
            && (row < puzzle.length) && (col < puzzle[0].length) 
            && Character.isLowerCase(puzzle[row][col])){
                result = true;
            }
        return result;
    }

    /*
     * Returns the index of the next row in the given direction.
     * Also accounts for rows wrapping around the puzzle.
     */
    private int nextRow(int row, Direction direction){
        int result = row;
        if(direction == Direction.N || direction == Direction.NE || 
            direction == Direction.NW){
            result = (row - 1 + size)%size;
        }
        if(direction == Direction.S || direction == Direction.SE || 
            direction == Direction.SW){
            result = (row + 1)%size;
        }
        return result;
    }

    /*
     * Returns the index of the next column in the given direction.
     * Also accounts for columns wrapping around the puzzle.
     */
    private int nextCol(int col, Direction direction){
        int result = col;
        if(direction == Direction.E || direction == Direction.NE || 
            direction == Direction.SE){
            result = (col + 1)%size;
        }
        if(direction == Direction.W || direction == Direction.NW || 
            direction == Direction.SW){
            result = (col - 1 + size)%size;
        }
        return result;
    }

    /*
     * Returns if `check` is a prefix of `against`.
     * This method assumes 
     * isPrefix(check.substring(0,check.length-1), against) is true.
     * Thus, it is important to call isPrefix every time a new letter 
     * is added to the Stack.
     */
    private boolean isPrefix(String check, String against){
        boolean result = true;
        if(check.length() > against.length()){
            result = false;
        } else {
            char c1 = Character.toUpperCase(check.charAt(check.length()-1));
            char c2 = Character.toUpperCase(against.charAt(check.length()-1));
            return c1 == c2;
        }       

        return result;

    }

    /*
     * Initializes a new puzzle based on the given `puzzle` array and `n`, 
     * which represents the number of rows and columns in the array.
     */
    @Override
    public void initialize(char[][] puzzle, int n) {
        // TODO: Implement this method
        // initialize size and puzzle
        this.size = n;
        this.puzzle = new char[n][n];
        // iterate through and make a copy with arraycopy()
        // https://www.geeksforgeeks.org/system-arraycopy-in-java/
        for (int i = 0; i < n; i++) {
            System.arraycopy(puzzle[i], 0, this.puzzle[i], 0, n);
        }
    }

    /*
     * Returns a deep copy of the puzzle array. It's important to return
     * a deep copy here as edits to clone puzzles shouldn't affect the
     * original puzzle.
     */
    @Override
    public char[][] getPuzzle() {
        // TODO: Implement this method
        // initialize a copy that can be cloned
        char [][] copy = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j ++) {
                // i ran into problems because i stupidly ran through a 1d array
                // also, I was not converting the arrray copy to lowercase
                copy[i][j] = Character.toLowerCase(puzzle[i][j]);
            }
        }
        return copy;
    }    
}
