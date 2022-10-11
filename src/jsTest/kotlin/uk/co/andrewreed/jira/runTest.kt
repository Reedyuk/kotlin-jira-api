package uk.co.andrewreed.jira

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

actual fun runTest(test: suspend () -> Unit) = GlobalScope.promise { test() }.unsafeCast<Unit>()
