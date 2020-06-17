package iv.nakonechnyi.test.helpers

import iv.nakonechnyi.test.BaseTest
import org.junit.Assert.*
import org.junit.Test

class MathHelperTest: BaseTest(){


    @Test
    fun checkStaticFunThatItCalculateCorrectly(){

        val expected = """ and <b><a href="https://instagram.com">3 others</a></b>"""
        val post = posts[0]

        val res = MathHelper.otherLinkedMembersCount(post)

        assertEquals(expected, res)



        val incorrectExpected2 = """ and <b><a href="https://instagram.com">3 others</a></b>"""
        val correctExpected = ""
        val post2 = posts2[0]

        val res2 = MathHelper.otherLinkedMembersCount(post2)

        assertNotEquals(incorrectExpected2, res2)

        assertEquals(correctExpected, res2)

    }


}