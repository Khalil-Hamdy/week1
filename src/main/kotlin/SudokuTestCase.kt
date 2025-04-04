package org.example

fun runCheckSudoku() {
    check(
        "invalid sudoku should return false as have a char",
        isValidSudoku(
            arrayOf(
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
        ), false
    )

    check(
        "valid sudoku should return true", isValidSudoku(
            arrayOf(
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
        ), true
    )

    check(
        "duplicate in row should return false", isValidSudoku(
            arrayOf(
                arrayOf('5', '3', '3', '-', '7', '-', '-', '-', '-'),
                arrayOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
                arrayOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
                arrayOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
                arrayOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
                arrayOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
                arrayOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
                arrayOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
                arrayOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
            )
        ), false
    )

    check(
        "duplicate in column should return false", isValidSudoku(
            arrayOf(
                arrayOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
                arrayOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
                arrayOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
                arrayOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
                arrayOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
                arrayOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
                arrayOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
                arrayOf('5', '-', '-', '4', '1', '9', '-', '-', '5'),
                arrayOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
            )
        ), false
    )

    check(
        "duplicate in 3x3 box should return false", isValidSudoku(
            arrayOf(
                arrayOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
                arrayOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
                arrayOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
                arrayOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
                arrayOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
                arrayOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
                arrayOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
                arrayOf('-', '-', '-', '4', '1', '9', '9', '-', '5'),
                arrayOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
            )
        ), false
    )

    check(
        "partially filled but valid sudoku should return true", isValidSudoku(
            arrayOf(
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
        ), true
    )

    check(
        "empty sudoku should return true",
        isValidSudoku(Array(9) { Array(9) { '-' } }),
        true
    )

    check(
        "sudoku with invalid character should return false",
        isValidSudoku(Array(9) { Array(9) { 'X' } }),
        false
    )

    check(
        "sudoku with incorrect dimensions should return false",
        isValidSudoku(Array(8) { Array(9) { '-' } }),
        false
    )

    check(
        "sudoku with all identical numbers should return false",
        isValidSudoku(Array(9) { Array(9) { '5' } }), false
    )

    check(
        "sudoku with only one filled number should return true",
        isValidSudoku(Array(9) {
            if (it == 0) arrayOf('5', '-', '-', '-', '-', '-', '-', '-', '-') else Array(9) { '-' }
        }), true
    )

    check(
        "valid 4x4 sudoku should return true", isValidSudoku(
            arrayOf(
                arrayOf('1', '2', '-', '4'),
                arrayOf('3', '4', '1', '2'),
                arrayOf('4', '1', '2', '3'),
                arrayOf('2', '3', '4', '1')
            )
        ), true
    )

    check(
        "invalid 4x4 sudoku should return false", isValidSudoku(
            arrayOf(
                arrayOf('1', '2', '-', '4'),
                arrayOf('3', '4', '1', '2'),
                arrayOf('4', '1', '2', '3'),
                arrayOf('2', '3', '2', '1') // duplicate
            )
        ), false
    )

    check(
        "2x2 sudoku should return false (invalid size)", isValidSudoku(
            arrayOf(
                arrayOf('1', '2'),
                arrayOf('5', '3')
            )
        ), false
    )
}