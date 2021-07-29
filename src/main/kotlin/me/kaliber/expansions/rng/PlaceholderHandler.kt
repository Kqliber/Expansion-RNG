package me.kaliber.expansions.rng

import me.clip.placeholderapi.PlaceholderAPI
import org.bukkit.OfflinePlayer
import org.bukkit.Bukkit
import kotlin.math.max
import kotlin.math.min

internal class RNGPlaceholderHandler
{

    // will keep track of the last random number generated for the %rng_last_generated% placeholder
    private var lastNumber = 0

    internal fun handle(player: OfflinePlayer?, identifier: String): String?
    {

        // sets input to allow for bracket placeholders to be randomized
        val input = PlaceholderAPI.setBracketPlaceholders(player, identifier)

        return when
        {
            // returns a random number from 1-2147483647
            input == "random" ->
            {
                val number = (1..Int.MAX_VALUE).random()
                lastNumber = number
                number.toString()
            }

            // returns the last generated number from this expansion
            input == "last_generated" -> lastNumber.toString()

            // returns a random online player's name
            input == "online_player" ->
            {
                val online = Bukkit.getOnlinePlayers()
                if (online.isEmpty())
                {
                    return null
                }
                online.random().name
            }

            // returns a random number that are being inputted between ','
            input.contains(',') ->
            {
                val list = input.split(',')
                val (first, second) = list.map(String::convertToInt)

                if (first == null || second == null)
                {
                    return list.random()
                }

                val min = min(first, second)
                val max = max(first, second)

                val number = (min..max).random()
                lastNumber = number
                number.toString()
            }
            else -> null
        }
    }

}
