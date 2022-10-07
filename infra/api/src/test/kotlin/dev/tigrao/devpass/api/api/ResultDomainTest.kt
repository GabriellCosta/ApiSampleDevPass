package dev.tigrao.devpass.api.api

import dev.tigrao.devpass.api.states.ResultDomain
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class ResultDomainTest {

    @Test
    fun successOrNull_success_returnData() {

    }

    @Test
    fun successOrNull_error_returnNull() {

    }

    @Test
    fun errorOrNull_success_returnNull() {

    }

    @Test
    fun errorOrNull_error_returnData() {
        val parameter = ResultDomain.Error("String")

        val result = parameter.errorOrNull()

        assertEquals("String", result)
    }
}
