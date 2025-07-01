package org.example
import java.util.Random

fun main() {
    val rand = Random()
    val answer = rand.nextInt(1,2)
    print("1 or 2? ")
    val guess = readln()?.toInt()
    if(answer == guess) {
        print("You win")
    }
    else {
        print("Try again")
    }
}