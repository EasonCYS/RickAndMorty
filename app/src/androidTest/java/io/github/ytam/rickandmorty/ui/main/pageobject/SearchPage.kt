package io.github.ytam.rickandmorty.ui.main.pageobject

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import io.github.ytam.rickandmorty.R

object SearchPage: PageObject by BasePage{

    private const val searchBarId = R.id.search_src_text
    private const val characterNameId = R.id.tvCharacterName
    private const val searchViewId = R.id.characterSearchView

    fun performSearch(text: String){
        onView(withId(searchBarId)).perform(ViewActions.typeText(text), ViewActions.pressImeActionButton())
    }

    fun checkCharacterIdExist(text: String){
        checkViewDisplayedByIdAndText(characterNameId, text)
    }

    fun checkSearchViewIsDisplayed(){
        checkViewDisplayed(searchViewId)
    }

    fun enterDetailPage(characterName: String){
        clickByIdAndText(characterNameId, characterName)
    }
}


