package uk.co.andrewreed.jira

import kotlinx.coroutines.runBlocking

actual fun runTest(test: suspend () -> Unit) = runBlocking { test() }
