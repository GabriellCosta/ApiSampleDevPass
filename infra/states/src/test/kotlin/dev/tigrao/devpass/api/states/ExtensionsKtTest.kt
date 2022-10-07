package dev.tigrao.devpass.api.states

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
        val result = "String".toErrorResultDomain()

        assertTrue(result.isError())
    }

    @Test
    fun toErrorResultDomain_returnErrorDomainData() {

    }
}
