package me.kaliber.expansions.rng

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

    private val handler = RNGPlaceholderHandler()

    override fun onRequest(player: OfflinePlayer, identifier: String): String?
    {
        return handler.handle(player, identifier)
    }
}
