package me.kaliber.rngExpansion

import kotlin.math.min
import kotlin.math.max
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
        return "1.1.1"
    }

    override fun getIdentifier(): String {
        return "rng"
    }

    override fun onRequest(p: OfflinePlayer, input: String): String? {
        when {
            input == "random" -> return (0..Int.MAX_VALUE).random().toString()

            input.toIntOrNull() != null -> {
                return (input.toInt()..Int.MAX_VALUE).random().toString()
            }

            input.contains(',') -> {
                val args = input.split(',')
                if (args[0].toIntOrNull() == null || args[1].toIntOrNull() == null) return null
                
                val min = min(args[0].toInt(), args[1].toInt())
                val max = max(args[0].toInt(), args[1].toInt())
                
                return (min..max).random().toString()
            }
        }
        return null
    }

}
