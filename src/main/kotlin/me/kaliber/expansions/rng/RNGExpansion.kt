package me.kaliber.expansions.rng

import org.bukkit.OfflinePlayer
import me.clip.placeholderapi.expansion.PlaceholderExpansion

class RNGExpansion : PlaceholderExpansion()
{

    private val handler = RNGPlaceholderHandler()

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
        return "1.3.4"
    }

    override fun getIdentifier(): String
    {
        return "rng"
    }

    override fun onRequest(player: OfflinePlayer?, identifier: String): String?
    {
        return handler.handle(player, identifier)
    }
}
