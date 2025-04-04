package org.example

fun runCheckIpv4() {
    check(
        "valid IP should return true",
        isValidIPv4("192.168.0.1"),
        true
    )
    check(
        "IP with 3 segments should return false",
        isValidIPv4("192.168.1"),
        false
    )
    check(
        "IP with 5 segments should return false",
        isValidIPv4("10.0.0.1.5"),
        false
    )
    check(
        "empty IP should return false",
        isValidIPv4(""),
        false
    )
    check(
        "IP with character segment should return false",
        isValidIPv4("192.168.1.a"),
        false
    )
    check(
        "IP with letters only should return false",
        isValidIPv4("abc.def.ghi.jkl"),
        false
    )
    check(
        "IP with segment greater than 255 should return false",
        isValidIPv4("123.456.78.90"),
        false
    )
    check(
        "IP with negative number should return false",
        isValidIPv4("12.34.56.-7"),
        false
    )
    check(
        "IP with leading zeros should return false",
        isValidIPv4("01.2.3.4"),
        false
    )
    check(
        "IP with multiple leading zeros should return false",
        isValidIPv4("1.02.003.4"),
        false
    )
    check(
        "IP with segment 0 should be valid",
        isValidIPv4("0.0.0.0"),
        true
    )
    check(
        "IP with segment 256 should return false",
        isValidIPv4("256.100.100.100"),
        false
    )
    check(
        "IP with segment 999 should return false",
        isValidIPv4("1.1.1.999"),
        false
    )
    check(
        "IP with double dots should return false",
        isValidIPv4("192..168.1.1"),
        false
    )
    check(
        "IP starts with dot should return false",
        isValidIPv4(".192.168.1.1"),
        false
    )
    check(
        "IP ends with dot should return false",
        isValidIPv4("192.168.1.1."),
        false
    )
    check(
        "IP with leading space should return false",
        isValidIPv4(" 192.168.0.1"),
        false
    )
    check(
        "IP with trailing space should return false",
        isValidIPv4("192.168.0.1 "),
        false
    )
    check(
        "IP with middle space should return false",
        isValidIPv4("192.168. 0.1"),
        false
    )
    check(
        "IP with special character should return false",
        isValidIPv4("192.168@0.1"),
        false
    )
    check(
        "IP with Null input should return false",
        isValidIPv4(null),
        false
    )

}