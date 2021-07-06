package io.github.ytam.rickandmorty.ui.main.pageobject

interface PageObject {
    fun checkTextMatch(resourceId: Int, matchingText: String)
    fun checkViewDisplayed(resourceId: Int)
    fun clickById(resourceId: Int)
    fun clickByIdAndText(resourceId: Int, text: String)
    fun checkViewDisplayedByIdAndText(resourceId: Int, text: String)
}