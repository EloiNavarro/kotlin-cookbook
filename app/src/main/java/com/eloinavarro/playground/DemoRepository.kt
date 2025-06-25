package com.eloinavarro.playground

import kotlinx.coroutines.delay
import kotlin.random.Random

object DemoRepository {
    private fun getRandomId(): Int = Random.nextInt(from = 1, until = 60)
    private val data = listOf(
        User(getRandomId(), "cellguard"),
        User(getRandomId(), "reservedneck"),
        User(getRandomId(), "dunbirdsafety"),
        User(getRandomId(), "mudorlop"),
        User(getRandomId(), "thankssownder"),
        User(getRandomId(), "tealvigorous"),
        User(getRandomId(), "fourthtrunk"),
        User(getRandomId(), "kookyvulnerable"),
        User(getRandomId(), "wordretirement"),
        User(getRandomId(), "thousandassist"),
        User(getRandomId(), "boinkenunciate"),
        User(getRandomId(), "antiquewar"),
        User(getRandomId(), "immigranthart"),
        User(getRandomId(), "drawersegghead"),
        User(getRandomId(), "glassjudgmental"),
        User(getRandomId(), "notablehide"),
        User(getRandomId(), "jelliedpharmacist"),
        User(getRandomId(), "confusedfiggy"),
        User(getRandomId(), "cigarettevaulting"),
        User(getRandomId(), "vealsoutheasterly"),
        User(getRandomId(), "cableconfidence"),
        User(getRandomId(), "detailedraid"),
        User(getRandomId(), "nowherearches"),
        User(getRandomId(), "highlightapproval"),
        User(getRandomId(), "increasedprincess"),
        User(getRandomId(), "runnerbasis"),
        User(getRandomId(), "mizzenmastsample"),
        User(getRandomId(), "sullenhurricane"),
        User(getRandomId(), "suteharmonious"),
        User(getRandomId(), "assuremourner"),
        User(getRandomId(), "dividerssever"),
        User(getRandomId(), "viperdiamond"),
        User(getRandomId(), "ventureugh"),
        User(getRandomId(), "spritsaillace"),
        User(getRandomId(), "kayakermanrope"),
        User(getRandomId(), "grumpyhardtofind"),
        User(getRandomId(), "sardonicclams"),
        User(getRandomId(), "attentionopen"),
        User(getRandomId(), "islandsshame"),
        User(getRandomId(), "frivolousrannoch"),
        User(getRandomId(), "blitzenlegacy"),
        User(getRandomId(), "shadowpolitics"),
        User(getRandomId(), "mentionvarious"),
        User(getRandomId(), "motionlessprospect"),
        User(getRandomId(), "oceanbutterfat"),
        User(getRandomId(), "hyundaifume"),
        User(getRandomId(), "hutgym"),
        User(getRandomId(), "famouskill"),
        User(getRandomId(), "unadvisedwallow"),
        User(getRandomId(), "secondarydeserted")
    )

    suspend fun getUserDetails(id:Int): User? {
        delay(1000L)
        return data.find { it.id == id }
    }
}