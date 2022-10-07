package dev.tigrao.devpass.domain

import okhttp3.ResponseBody
import retrofit2.HttpException
import retrofit2.Response

enum class ListApiMock {
    EMPTY {
        override fun getResult(): String {
            return "[]"
        }
    },
    SUCCESS {
        override fun getResult(): String {
            return "[{\n" +
                    "      \"id\":250,\n" +
                    "      \"url\":\"https:\\/\\/www.tvmaze.com\\/shows\\/250\\/kirby-buckets\",\n" +
                    "      \"name\":\"Kirby Buckets\",\n" +
                    "      \"type\":\"Scripted\",\n" +
                    "      \"language\":\"English\",\n" +
                    "      \"genres\":[\n" +
                    "         \"Comedy\"\n" +
                    "      ],\n" +
                    "      \"status\":\"Ended\",\n" +
                    "      \"runtime\":30,\n" +
                    "      \"averageRuntime\":30,\n" +
                    "      \"premiered\":\"2014-10-20\",\n" +
                    "      \"ended\":\"2017-02-02\",\n" +
                    "      \"officialSite\":\"http:\\/\\/disneyxd.disney.com\\/kirby-buckets\",\n" +
                    "      \"schedule\":{\n" +
                    "         \"time\":\"07:00\",\n" +
                    "         \"days\":[\n" +
                    "            \"Monday\",\n" +
                    "            \"Tuesday\",\n" +
                    "            \"Wednesday\",\n" +
                    "            \"Thursday\",\n" +
                    "            \"Friday\"\n" +
                    "         ]\n" +
                    "      },\n" +
                    "      \"rating\":{\n" +
                    "         \"average\":null\n" +
                    "      },\n" +
                    "      \"weight\":62,\n" +
                    "      \"network\":{\n" +
                    "         \"id\":25,\n" +
                    "         \"name\":\"Disney XD\",\n" +
                    "         \"country\":{\n" +
                    "            \"name\":\"United States\",\n" +
                    "            \"code\":\"US\",\n" +
                    "            \"timezone\":\"America\\/New_York\"\n" +
                    "         },\n" +
                    "         \"officialSite\":null\n" +
                    "      },\n" +
                    "      \"webChannel\":{\n" +
                    "         \"id\":83,\n" +
                    "         \"name\":\"DisneyNOW\",\n" +
                    "         \"country\":{\n" +
                    "            \"name\":\"United States\",\n" +
                    "            \"code\":\"US\",\n" +
                    "            \"timezone\":\"America\\/New_York\"\n" +
                    "         },\n" +
                    "         \"officialSite\":null\n" +
                    "      },\n" +
                    "      \"dvdCountry\":null,\n" +
                    "      \"externals\":{\n" +
                    "         \"tvrage\":37394,\n" +
                    "         \"thetvdb\":278449,\n" +
                    "         \"imdb\":\"tt3544772\"\n" +
                    "      },\n" +
                    "      \"image\":{\n" +
                    "         \"medium\":\"https:\\/\\/static.tvmaze.com\\/uploads\\/images\\/medium_portrait\\/1\\/4600.jpg\",\n" +
                    "         \"original\":\"https:\\/\\/static.tvmaze.com\\/uploads\\/images\\/original_untouched\\/1\\/4600.jpg\"\n" +
                    "      },\n" +
                    "      \"summary\":\"<p>The single-camera series that mixes live-action and animation stars Jacob Bertrand as the title character. <b>Kirby Buckets<\\/b> introduces viewers to the vivid imagination of charismatic 13-year-old Kirby Buckets, who dreams of becoming a famous animator like his idol, Mac MacCallister. With his two best friends, Fish and Eli, by his side, Kirby navigates his eccentric town of Forest Hills where the trio usually find themselves trying to get out of a predicament before Kirby's sister, Dawn, and her best friend, Belinda, catch them. Along the way, Kirby is joined by his animated characters, each with their own vibrant personality that only he and viewers can see.<\\/p>\",\n" +
                    "      \"updated\":1658519538,\n" +
                    "      \"_links\":{\n" +
                    "         \"self\":{\n" +
                    "            \"href\":\"https:\\/\\/api.tvmaze.com\\/shows\\/250\"\n" +
                    "         },\n" +
                    "         \"previousepisode\":{\n" +
                    "            \"href\":\"https:\\/\\/api.tvmaze.com\\/episodes\\/1051658\"\n" +
                    "         }\n" +
                    "      }\n" +
                    "   }]"
        }
    },
    GENERIC_ERROR {
        override fun getResult(): String {
            throw Exception("Generic Error")
        }
    },
    UNAUTHORIZED {
        override fun getResult(): String {
            throw HttpException(
                Response.error<String>(
                    401, ResponseBody.create(null, "")
                )
            )
        }
    };

    abstract fun getResult(): String
}