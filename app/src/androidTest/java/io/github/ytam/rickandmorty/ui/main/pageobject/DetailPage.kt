package io.github.ytam.rickandmorty.ui.main.pageobject

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import io.github.ytam.rickandmorty.R
import io.github.ytam.rickandmorty.ui.main.data.Character

object DetailPage: PageObject by BasePage{
    // page attributes
    private const val episodeId = R.id.tvCharacterNumberOfEpisodes
    private const val speciesId = R.id.tvCharacterSpecies
    private const val statusViewId = R.id.tvCharacterStatus
    private const val genderId = R.id.tvCharacterGender
    private const val originLocationId = R.id.tvCharacterOriginLocation
    private const val lastLocationId = R.id.tvCharacterLastLocation
    val navigateBackView = onView(ViewMatchers.withContentDescription("Navigate up"))


    fun verifyCharacter(testCharacter: Character){
        checkTextMatch(episodeId, "Number of episodes: " + testCharacter.episode)
        checkTextMatch(speciesId, "Species: " + testCharacter.species)
        checkTextMatch(statusViewId, "Status: " + testCharacter.status)
        checkTextMatch(genderId, "Gender: " + testCharacter.gender)
        checkTextMatch(originLocationId, "Origin location: " + testCharacter.origin)
        checkTextMatch(lastLocationId, "Last known location: " + testCharacter.location)
    }

    fun navigateBackToSearch() {
        navigateBackView.perform(ViewActions.click())
    }
}


