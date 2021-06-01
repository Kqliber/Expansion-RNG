package me.kaliber.expansions.rng

// allows for decimals to be inputted
fun String.convertToInt(): Int?
{
    return this.toDoubleOrNull()?.toInt()
}
