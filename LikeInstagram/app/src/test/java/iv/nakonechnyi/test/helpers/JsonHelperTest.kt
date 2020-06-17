package iv.nakonechnyi.test.helpers

import iv.nakonechnyi.test.BaseTest
import org.junit.Assert.assertEquals
import org.junit.Test

class JsonHelperTest: BaseTest(){

    @Test
    fun testStaticMethodFromJsonHelperThatParsedObjectContainsAllInformationFromJson(){
        val posts = JsonHelper.fromJson(json)

        assertEquals(posts, posts)
    }

}