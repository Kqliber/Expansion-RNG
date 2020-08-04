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
        return "1.0.2"
    }

    override fun getIdentifier(): String {
        return "rng"
    }

    override fun onRequest(p: OfflinePlayer, input: String): String? {
        when {
            input == "random" -> return (1..Int.MAX_VALUE).random().toString()

            input.contains(minimum, ignoreCase = true) && input.contains(maximum, ignoreCase = true) -> {
                val args = input.split('_')
                val min = args[0].substringAfter(minimum).toIntOrNull()
                val max = args[1].substringAfter(maximum).toIntOrNull()
                if (min != null && max != null) {
                    return (min..max).random().toString()
                }
            }
        }
        return null
    }

    companion object {
        const val minimum = "min:"
        const val maximum = "max:"
    }

}
