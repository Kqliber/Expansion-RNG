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

    override fun onRequest(p: OfflinePlayer, arg: String): String? {
        when {
            arg == "random" -> return (1..Int.MAX_VALUE).random().toString()

            arg.contains(minimum, ignoreCase = true) && arg.contains(maximum, ignoreCase = true) -> {
                val min = arg.substringAfter(minimum).substringBefore('_').toIntOrNull()
                val max = arg.substringAfter(maximum).toIntOrNull()
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
