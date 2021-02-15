# Expansion-RNG
### Generate random numbers using PlaceholderAPI
----

**Downloading the expansion:**
* Manually: 
  * Download the expansion from the [Ecloud](https://api.extendedclip.com/expansions/rng/)
  * Place the .jar file inside of the `/plugins/PlaceholderAPI/expansions/` folder
* In-game command:
  > /papi ecloud download RNG
----

**Placeholders:**
```
%rng_random% - Returns a random number between 1 and 2147483647.
%rng_<minimum>,<maximum>% - Returns a random number between the two boundaries.
```
**Note**: the minimum and maximum values can utilise bracket placeholders with `{}`.  
*Example: `%rng_{player_health},{player_exp}%`*  
