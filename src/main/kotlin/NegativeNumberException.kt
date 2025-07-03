package org.example

class NegativeNumberException (negativeNumbers: List<Int>) : Exception (
    if (negativeNumbers.size == 1) {
        "Les nombres négatifs ne sont pas autorisés"
    } else {
        "Les nombres négatifs ne sont pas autorisés : ${negativeNumbers.joinToString(", ")}"
    }
)