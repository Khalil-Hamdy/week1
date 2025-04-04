package org.example


/*
fun isValidIPv4(address: String?): Boolean {
    return true
}
*/


fun isValidIPv4(address: String?): Boolean {
    if (address == null) return false
    if (address.trim() != address) return false
    val parts = address.split(".")
    if (parts.size != 4) return false

    for (part in parts) {
        if (!part.all { it.isDigit() }) return false
        if (part != "0" && part.startsWith("0")) return false
        val number = part.toIntOrNull() ?: return false
        if (number !in 0..255) return false
    }

    return true
}
