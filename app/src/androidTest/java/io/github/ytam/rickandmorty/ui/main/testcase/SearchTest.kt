package io.github.ytam.rickandmorty.ui.main.testcase

import androidx.test.espresso.IdlingRegistry
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import io.github.ytam.rickandmorty.ui.main.MainActivity
import io.github.ytam.rickandmorty.ui.main.pageobject.SearchPage
import io.github.ytam.rickandmorty.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class SearchTest{

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
    fun testSearch() {
        SearchPage.performSearch("cybor")
        SearchPage.checkCharacterIdExist("Amish Cyborg")
        SearchPage.checkCharacterIdExist("Photography Cyborg")
    }
}


