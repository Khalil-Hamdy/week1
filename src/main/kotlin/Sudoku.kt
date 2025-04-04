package org.example

import kotlin.math.sqrt


fun isValidSudoku(board: Array<Array<Char>>): Boolean {
    val size = board.size  // N (مثل 4, 9, 16)
    val subgridSize = sqrt(size.toDouble()).toInt()

    // التحقق من أن الجدول مربّع (N×N)
    if (board.any { it.size != size || it.size < 3 }) return false

    // التحقق من الصفوف والأعمدة
    for (i in 0 until size) {
        if (!isValidBlock(board[i].toList())) return false  // التحقق من الصفوف
        if (!isValidBlock(board.map { it[i] })) return false // التحقق من الأعمدة
    }

    // التحقق من المربعات الفرعية (subgrids)
    for (row in 0 until size step subgridSize) {
        for (col in 0 until size step subgridSize) {
            val subgrid = mutableListOf<Char>()
            for (i in 0 until subgridSize) {
                for (j in 0 until subgridSize) {
                    subgrid.add(board[row + i][col + j])
                    if (!board[row + i][col + j].isDigit() && board[row + i][col + j] != '-') return false
                }
            }
            if (!isValidBlock(subgrid)) return false
        }
    }

    return true
}

// دالة فرعية للتحقق من وجود تكرار في أي قائمة
fun isValidBlock(block: List<Char>): Boolean {
    val numbers = block.filter { it != '-' } // استبعاد الخلايا الفارغة
    return numbers.size == numbers.toSet().size // التأكد من عدم وجود تكرار
}