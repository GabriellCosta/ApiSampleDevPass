package dev.tigrao.devpass.api.api

import dev.tigrao.devpass.api.states.toErrorResultDomain
import dev.tigrao.devpass.api.states.toSuccessResultDomain
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ExtensionsKtTest {

    @Test
    fun toSuccessResultDomain_returnSuccessDomain() {
        val result = "String".toSuccessResultDomain()

        assertTrue(result.isSuccess())
    }

    @Test
    fun toSuccessResultDomain_returnSuccessDomainData() {

    }

    @Test
    fun toErrorResultDomain_returnErrorDomain() {

    }

    @Test
    fun toErrorResultDomain_returnErrorDomainData() {

    }
}
