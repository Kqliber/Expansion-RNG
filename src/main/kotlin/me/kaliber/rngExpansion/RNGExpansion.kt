package me.kaliber.rngExpansion

import org.bukkit.OfflinePlayer
import me.clip.placeholderapi.expansion.PlaceholderExpansion

class RNGExpansion : PlaceholderExpansion() {

    override fun canRegister(): Boolean {
        return true
    }

    override fun getAuthor(): String {
        return "Kaliber"
    }

    override fun getVersion(): String {
        return "1.0.3"
    }

    override fun getIdentifier(): String {
        return "rng"
    }

    override fun onRequest(p: OfflinePlayer, input: String): String? {
        when {
            input == "random" -> return (1..Int.MAX_VALUE).random().toString()

            input.contains(',') -> {

                val args = input.split(',')
                var min = args[0].toIntOrNull()
                var max = args[1].toIntOrNull()

                if(min != null && max != null) {
                    if (min > max){
                        min += max
                        max = min-max
                        min -= max
                    }
                    return(min..max).random().toString()
                }
            }

            input.toIntOrNull() != null -> {
                return(input.toInt()..Int.MAX_VALUE).random().toString()
            }
        }
        return null
    }

}
