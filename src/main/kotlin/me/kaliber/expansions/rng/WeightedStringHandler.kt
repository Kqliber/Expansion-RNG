package me.kaliber.expansions.rng

class WeightedStringHandler {

    private val list = mutableListOf<String>()

    fun add(weightedNumber: WeightedString) {
        val (value, weight) = weightedNumber

        if (weight <= 0 || list.contains(value)) return
        for (i in 1..weight) {
            list.add(value)
        }
    }

    fun random(): String? {
        return list.randomOrNull()
    }

}
