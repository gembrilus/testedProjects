package iv.nakonechnyi.test

import iv.nakonechnyi.test.data.Message
import iv.nakonechnyi.test.data.Post
import iv.nakonechnyi.test.data.Profile

open class BaseTest {

    protected val json = """[
        {
            "user": {
            "logo": "user.jpg",
            "name": "Minoko",
            "place": "Mars",
            "url": "https://instagram.com"
        },
            "photos": [
            "1/1.jpg",
            "1/2.jpg",
            "1/3.jpg"
            ],
            "linked": [
            {
                "logo": "user.jpg",
                "name": "milena_trump",
                "place": "Mars",
                "url": "https://instagram.com"
            },
            {
                "logo": "user.jpg",
                "name": "vasya_pupkin",
                "place": "Mars",
                "url": "https://instagram.com"
            },
            {
                "logo": "user.jpg",
                "name": "kitaygora",
                "place": "Mars",
                "url": "https://instagram.com"
            },
            {
                "logo": "user.jpg",
                "name": "gubka_bob",
                "place": "Mars",
                "url": "https://instagram.com"
            },
            {
                "logo": "user.jpg",
                "name": "jobs_steave",
                "place": "Mars",
                "url": "https://instagram.com"
            },
            {
                "logo": "user.jpg",
                "name": "baba_jaga",
                "place": "Mars",
                "url": "https://instagram.com"
            }
            ],
            "message": {
            "text": "Beautiful nature!!!"
        },
            "timestamp": "01-02-2000 10:10:30"
        },
        {
            "user": {
            "logo": "user.jpg",
            "name": "Krokus",
            "place": "Sakura-city",
            "url": "https://instagram.com"
        },
            "photos": [
            "2/1.jpg",
            "2/2.jpg",
            "2/3.jpg"
            ],
            "linked": [
            {
                "logo": "user.jpg",
                "name": "milena_trump",
                "place": "Mars",
                "url": "https://instagram.com"
            },
            {
                "logo": "user.jpg",
                "name": "vasya_pupkin",
                "place": "Mars",
                "url": "https://instagram.com"
            },
            {
                "logo": "user.jpg",
                "name": "kitaygora",
                "place": "Mars",
                "url": "https://instagram.com"
            },
            {
                "logo": "user.jpg",
                "name": "gubka_bob",
                "place": "Mars",
                "url": "https://instagram.com"
            },
            {
                "logo": "user.jpg",
                "name": "jobs_steave",
                "place": "Mars",
                "url": "https://instagram.com"
            },
            {
                "logo": "user.jpg",
                "name": "baba_jaga",
                "place": "Mars",
                "url": "https://instagram.com"
            }
            ],
            "message": {
            "text": "Very nice!"
        },
            "timestamp": "03-11-2000 15:10:45"
        }
    ]"""

    protected val posts: List<Post> = listOf(
        Post(
            Profile("user.jpg","Minoko", "Mars","https://instagram.com"),
            listOf(
                "1/1.jpg",
                "1/2.jpg",
                "1/3.jpg"
            ),
            listOf(
                Profile("user.jpg","milena_trump", "Mars","https://instagram.com"),
                Profile("user.jpg","vasya_pupkin", "Mars","https://instagram.com"),
                Profile("user.jpg","kitaygora", "Mars","https://instagram.com"),
                Profile("user.jpg","gubka_bob", "Mars","https://instagram.com"),
                Profile("user.jpg","jobs_steave", "Mars","https://instagram.com"),
                Profile("user.jpg","baba_jaga", "Mars","https://instagram.com")
            ),
            Message("Beautiful nature!!!"),
            "01-02-2000 10:10:30"
        ),
        Post(
            Profile("user.jpg","Krokus", "Sakura-city","https://instagram.com"),
            listOf(
                "2/1.jpg",
                "2/2.jpg",
                "2/3.jpg"
            ),
            listOf(
                Profile("user.jpg","milena_trump", "Mars","https://instagram.com"),
                Profile("user.jpg","vasya_pupkin", "Mars","https://instagram.com"),
                Profile("user.jpg","kitaygora", "Mars","https://instagram.com"),
                Profile("user.jpg","gubka_bob", "Mars","https://instagram.com"),
                Profile("user.jpg","jobs_steave", "Mars","https://instagram.com"),
                Profile("user.jpg","baba_jaga", "Mars","https://instagram.com")
            ),
            Message("Very nice!"),
            "03-11-2000 15:10:45"
        )
    )

    protected val posts2: List<Post> = listOf(
        Post(
            Profile("user.jpg","Minoko", "Mars","https://instagram.com"),
            listOf(
                "1/1.jpg",
                "1/2.jpg",
                "1/3.jpg"
            ),
            listOf(
                Profile("user.jpg","milena_trump", "Mars","https://instagram.com"),
                Profile("user.jpg","vasya_pupkin", "Mars","https://instagram.com")
            ),
            Message("Beautiful nature!!!"),
            "01-02-2000 10:10:30"
        )
    )
}