package io.github.ytam.rickandmorty.ui.main

import io.github.ytam.rickandmorty.ui.main.testcase.DetailPageTest
import io.github.ytam.rickandmorty.ui.main.testcase.SearchTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    SearchTest::class,
    DetailPageTest::class
    )
class TestSuite