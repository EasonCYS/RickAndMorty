package io.github.ytam.rickandmorty.ui.main.pageobject

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.hamcrest.Matchers

object BasePage : PageObject {
    override fun checkTextMatch(resourceId: Int, matchingText: String) {
        onView(withId(resourceId))
            .check(ViewAssertions.matches(ViewMatchers.withText(matchingText)))
    }

    override fun checkViewDisplayed(resourceId: Int) {
        onView(withId(resourceId))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    override fun checkViewDisplayedByIdAndText(resourceId: Int, text: String) {
        onView(
            Matchers.allOf(
                withId(resourceId), ViewMatchers.withText(text)
            )
        )
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    override fun clickById(resourceId: Int) {
        onView(withId(resourceId))
            .perform(ViewActions.click())
    }

    override fun clickByIdAndText(resourceId: Int, text: String) {
        onView(
            Matchers.allOf(
                withId(resourceId), ViewMatchers.withText(text)
            )
        ).perform(ViewActions.click())
    }
}


