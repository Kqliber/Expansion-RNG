package me.kaliber.rngExpansion

import kotlin.math.min
import kotlin.math.max
import org.bukkit.OfflinePlayer
import me.clip.placeholderapi.expansion.PlaceholderExpansion

class RNGExpansion : PlaceholderExpansion()
{

    override fun canRegister(): Boolean
    {
        return true
    }

    override fun getAuthor(): String
    {
        return "Kaliber"
    }

    override fun getVersion(): String
    {
        return "1.2"
    }

    override fun getIdentifier(): String
    {
        return "rng"
    }

    private var lastNumber = 0

    override fun onRequest(p: OfflinePlayer, input: String): String?
    {
       return when
       {
            input == "random" ->
            {
                val number = (1..Int.MAX_VALUE).random()
                lastNumber = number
                number.toString()
            }

            input == "last_generated" -> lastNumber.toString()

            input.toIntOrNull() != null ->
            {
                val number = (input.toInt()..Int.MAX_VALUE).random()
                lastNumber = number
                number.toString()
            }

            input.contains(',') ->
            {
                val args = input.split(',')
                if (args[0].toIntOrNull() == null || args[1].toIntOrNull() == null)
                {
                    return null
                }
                
                val min = min(args[0].toInt(), args[1].toInt())
                val max = max(args[0].toInt(), args[1].toInt())

                val number = (min..max).random()
                lastNumber = number
                number.toString()
            }
           else -> null
        }
    }

}
