package me.kaliber.expansions.rng

class WeightedNumberHandler {

    private val list = mutableListOf<Int>()

    fun add(weightedNumber: WeightedNumber) {
        val (number, weight) = weightedNumber

        if (weight <= 0 || list.contains(number)) return
        for (i in 1..weight) {
            list.add(number)
        }
    }

    fun random(): Int? {
        return list.randomOrNull()
    }

}
