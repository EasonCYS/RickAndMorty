package io.github.ytam.rickandmorty.utils

import androidx.test.espresso.idling.net.UriIdlingResource


object EspressoIdlingResource {

    private const val RESOURCE = "GLOBAL"

    @JvmField val uriIdlingResource = UriIdlingResource(RESOURCE, 5000)

    fun beginLoad(uri: String?) {
        uriIdlingResource.beginLoad(uri)
    }

    fun endLoad(uri: String?) {
        uriIdlingResource.endLoad(uri)
    }
}
