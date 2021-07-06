package io.github.ytam.rickandmorty.ui.main.testcase

import androidx.test.espresso.IdlingRegistry
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import io.github.ytam.rickandmorty.ui.main.MainActivity
import io.github.ytam.rickandmorty.ui.main.data.Character
import io.github.ytam.rickandmorty.ui.main.pageobject.DetailPage
import io.github.ytam.rickandmorty.ui.main.pageobject.SearchPage
import io.github.ytam.rickandmorty.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class DetailPageTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
        //TODO: Prepare test data in data source
        IdlingRegistry.getInstance().register(EspressoIdlingResource.uriIdlingResource)
    }

    @After
    fun tearDown() {
        //TODO: Take Screenshot
        //TODO: Delete test data from data source
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.uriIdlingResource)
        activityRule.scenario.close()
    }



    @Test
    fun testEnterDetailPage() {
        // initial test character data, consider to implement data storage for test data
        val testChracter = Character()
        testChracter.name = "Amish Cyborg"
        testChracter.status = "Dead"
        testChracter.episode = "1"
        testChracter.gender = "Male"
        testChracter.origin = "unknown"
        testChracter.location = "Earth (Replacement Dimension)"
        testChracter.species = "Alien"

        // perform search and enter detail page
        SearchPage.performSearch(testChracter.name)
        SearchPage.enterDetailPage(testChracter.name)

        // verify
        DetailPage.verifyCharacter(testChracter)

    }

    @Test
    fun testNavigateBack() {
        val testCharacterName = "Amish Cyborg"
        SearchPage.performSearch(testCharacterName)
        SearchPage.enterDetailPage(testCharacterName)
        DetailPage.navigateBackToSearch()

        // verify
        SearchPage.checkSearchViewIsDisplayed()
    }
}


