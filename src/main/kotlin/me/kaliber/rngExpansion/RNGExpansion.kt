package me.kaliber.rngExpansion

import me.clip.placeholderapi.expansion.PlaceholderExpansion
import org.bukkit.OfflinePlayer

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

    override fun onRequest(p: OfflinePlayer, identifier: String): String {
        when {
            identifier == "random" -> return (1..Int.MAX_VALUE).random().toString()

            identifier.contains("min:", ignoreCase = true) && identifier.contains("max:", ignoreCase = true) -> {
                val min = identifier.substringAfter("min:").substringBefore("_").toIntOrNull()
                val max = identifier.substringAfter("max:").toIntOrNull()
                val random = (max?.let { min?.rangeTo(it) })?.random()
                return random.toString()
            }
        }
        return ""
    }
}
