package me.kaliber.expansions.rng

import at.helpch.placeholderapi.PlaceholderAPI
import com.hypixel.hytale.server.core.universe.PlayerRef
import com.hypixel.hytale.server.core.universe.Universe
import kotlin.math.max
import kotlin.math.min

internal class RNGPlaceholderHandler
{

    // will keep track of the last random number generated for the %rng_last_generated% placeholder
    private var lastNumber = 0

    internal fun handle(player: PlayerRef?, identifier: String): String?
    {

        // sets input to allow for bracket placeholders to be randomized
        val input = PlaceholderAPI.setBracketPlaceholders(player, identifier)

        return when
        {
            // returns a random number from 1-2147483647
            input == "random" ->
            {
                val number = (1..Int.MAX_VALUE).random()
                returnNum(number)
            }

            // returns the last generated number from this expansion
            input == "last_generated" -> lastNumber.toString()

            // returns a random online player's name
            input == "online_player" ->
            {
                val online = Universe.get().players
                if (online.isEmpty())
                {
                    return null
                }
                online.random().username
            }

            // get a random element from a specified list
            input.startsWith("list:") ->
            {
                val weightHandler = WeightedNumberHandler()

                val list = input.substringAfter("list:").split(',')
                if (input.contains(';'))
                {
                    list.map(::parseWeightedNumber).forEach(weightHandler::add)
                    val number = weightHandler.random() ?: return null

                    return returnNum(number)
                }

                val number = list.mapNotNull(String::convertToInt).random()
                returnNum(number)
            }

            // returns a random number that are being inputted between ','
            input.contains(',') ->
            {
                val (first, second) = input.split(',').map(String::convertToInt)

                if (first == null || second == null)
                {
                    return null
                }

                val min = min(first, second)
                val max = max(first, second)

                val number = (min..max).random()
                returnNum(number)
            }

            else -> null
        }
    }

    private fun parseWeightedNumber(string: String): WeightedNumber
    {
        val number = string.substringBefore(';').convertToInt() ?: 0
        val weight = string.substringAfter(';').convertToInt() ?: 0
        return WeightedNumber(number, weight)
    }

    /**
     * Utility function to set the last generated number, and easily return the number
     */
    private fun returnNum(type: Int): String
    {
        lastNumber = type
        return type.toString()
    }

}
