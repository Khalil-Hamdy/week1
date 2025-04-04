import org.example.isValidSudoku
import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

 class SudokuKtTest{
     @Test
     fun `invalid sudoku should return false as have a char`() {
         // Given: A correctly filled Sudoku grid with no duplicates
         val board = arrayOf(
             arrayOf('A', '3', '-', '-', '7', '-', '-', '-', '-'),
             arrayOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
             arrayOf('-', 'C', '8', '-', '-', '-', '-', '6', '-'),
             arrayOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
             arrayOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
             arrayOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
             arrayOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
             arrayOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
             arrayOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
         )

         // When: The function is called
         val result = isValidSudoku(board)

         // Then: It should return true
         assertFalse(result)
     }

     @Test
     fun `valid sudoku should return true`() {
         // Given: A correctly filled Sudoku grid with no duplicates
         val board = arrayOf(
             arrayOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
             arrayOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
             arrayOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
             arrayOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
             arrayOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
             arrayOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
             arrayOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
             arrayOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
             arrayOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
         )

         // When: The function is called
         val result = isValidSudoku(board)

         // Then: It should return true
         assertTrue(result)
     }

     @Test
     fun `invalid sudoku with duplicate in row should return false`() {
         // Given: A Sudoku grid where a row contains duplicates
         val board = arrayOf(
             arrayOf('5', '3', '3', '-', '7', '-', '-', '-', '-'), // Duplicate '3'
             arrayOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
             arrayOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
             arrayOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
             arrayOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
             arrayOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
             arrayOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
             arrayOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
             arrayOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
         )

         // When: The function is called
         val result = isValidSudoku(board)

         // Then: It should return false
         assertFalse(result)
     }

     @Test
     fun `invalid sudoku with duplicate in column should return false`() {
         // Given: A Sudoku grid where a column contains duplicates
         val board = arrayOf(
             arrayOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
             arrayOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
             arrayOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
             arrayOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
             arrayOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
             arrayOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
             arrayOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
             arrayOf('5', '-', '-', '4', '1', '9', '-', '-', '5'), // Duplicate '5' in column
             arrayOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
         )

         // When: The function is called
         val result = isValidSudoku(board)

         // Then: It should return false
         assertFalse(result)
     }

     @Test
     fun `invalid sudoku with duplicate in 3x3 box should return false`() {
         // Given: A Sudoku grid where a 3x3 subgrid contains duplicates
         val board = arrayOf(
             arrayOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
             arrayOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
             arrayOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
             arrayOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
             arrayOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
             arrayOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
             arrayOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
             arrayOf('-', '-', '-', '4', '1', '9', '9', '-', '5'), // Duplicate '9' in box
             arrayOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
         )

         // When: The function is called
         val result = isValidSudoku(board)

         // Then: It should return false
         assertFalse(result)
     }

     @Test
     fun `partially filled but valid sudoku should return true`() {
         // Given: A valid Sudoku with some empty cells ('-')
         val board = arrayOf(
             arrayOf('-', '3', '-', '-', '7', '-', '-', '-', '-'),
             arrayOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
             arrayOf('-', '-', '8', '-', '-', '-', '-', '6', '-'),
             arrayOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
             arrayOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
             arrayOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
             arrayOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
             arrayOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
             arrayOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
         )

         // When: The function is called
         val result = isValidSudoku(board)

         // Then: It should return true
         assertTrue(result)
     }

     @Test
     fun `empty sudoku should return true`() {
         // Given: A 9x9 grid filled only with '-'
         val board = Array(9) { Array(9) { '-' } }

         // When: The function is called
         val result = isValidSudoku(board)

         // Then: It should return true
         assertTrue(result)
     }

     @Test
     fun `sudoku with invalid character should return false`() {
         // Given: A Sudoku grid with invalid characters
         val board = Array(9) { Array(9) { 'X' } }

         // When: The function is called
         val result = isValidSudoku(board)

         // Then: It should return false
         assertFalse(result)
     }

     @Test
     fun `sudoku with incorrect dimensions should return false`() {
         // Given: A grid that is correct dimensions
         val board = Array(8) { Array(9) { '-' } }

         // When: The function is called
         val result = isValidSudoku(board)

         // Then: It should return false
         assertFalse(result)
     }

     @Test
     fun `sudoku with all identical numbers should return false`() {
         // Given: A Sudoku grid with all '5's
         val board = Array(9) { Array(9) { '5' } }

         // When: The function is called
         val result = isValidSudoku(board)

         // Then: It should return false
         assertFalse(result)
     }

     @Test
     fun `sudoku with only one filled number should return true`() {
         // Given: A Sudoku grid with only one number filled
         val board = Array(9) { Array(9) { '-' } }
         board[0] = board[0].apply { set(0, '5') }

         // When: The function is called
         val result = isValidSudoku(board)

         // Then: It should return true
         assertTrue(result)
     }

     @Test
     fun `Given a valid 4x4 sudoku When checked Then should return true`() {
         // Given: Valid 4x4 Sudoku table
         val board: Array<Array<Char>> = arrayOf(
             arrayOf('1', '2', '-', '4'),
             arrayOf('3', '4', '1', '2'),
             arrayOf('4', '1', '2', '3'),
             arrayOf('2', '3', '4', '1')
         )

         // When: Validate the table
         val result = isValidSudoku(board)

         // Then: The result must be true because the table is valid.
         assertTrue(result)
     }

     @Test
     fun `Given an invalid 4x4 sudoku When checked Then should return false`() {
         // Given: Invalid Sudoku table due to duplicate number '2'
         val board: Array<Array<Char>> = arrayOf(
             arrayOf('1', '2', '-', '4'),
             arrayOf('3', '4', '1', '2'),
             arrayOf('4', '1', '2', '3'),
             arrayOf('2', '3', '2', '1') //  تكرار الرقم '2'
         )

         // When: Validate the table
         val result = isValidSudoku(board)

         // Then: The result must be false because there is a duplicate.
         assertFalse(result)
     }

     @Test
     fun `Given an valid 2x2 sudoku When checked Then should return false`() {
         val board: Array<Array<Char>> = arrayOf(
             arrayOf('1', '2'),
             arrayOf('5', '3')
         )

         // When: Validate the table
         val result = isValidSudoku(board)

         // Then: return false because size must be >=3
         assertFalse(result)
     }

 }