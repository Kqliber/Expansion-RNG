package me.kaliber.rngExpansion

import org.bukkit.OfflinePlayer
import me.clip.placeholderapi.expansion.PlaceholderExpansion

class RNGExpansion: PlaceholderExpansion() {

    override fun canRegister(): Boolean {
        return true
    }

    override fun getAuthor(): String {
        return "Kaliber"
    }

    override fun getVersion(): String {
        return "1.0"
    }

    override fun getIdentifier(): String {
        return "rng"
    }

    companion object {
        const val minimum = "min:"
        const val maximum = "max:"
    }

    override fun onRequest(p: OfflinePlayer, identifier: String): String {
        when {
            identifier == "random" -> return (1..Int.MAX_VALUE).random().toString()

            identifier.contains(minimum, ignoreCase = true) && identifier.contains(maximum, ignoreCase = true) -> {
                val min = identifier.substringAfter(minimum).substringBefore('_').toIntOrNull()
                val max = identifier.substringAfter(maximum).toIntOrNull()
                if (min != null && max != null) {
                    return (min..max).random().toString()
                }
            }
        }
        return ""
    }
}
