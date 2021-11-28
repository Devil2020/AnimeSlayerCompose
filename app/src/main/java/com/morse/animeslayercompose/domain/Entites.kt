package com.morse.animeslayercompose.domain

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

/* Generic Item Classes */

@Keep
data class AnimeItem(
    @SerializedName("airing_start")
    val airingStart: String? = null, // 2020-12-06T15:10:00+00:00
    @SerializedName("continuing")
    val continuing: Boolean? = null, // false
    @SerializedName("episodes")
    val episodes: Int? = null, // 16
    @SerializedName("genres")
    val genres: List<Genre>? = null,
    @SerializedName("image_url")
    val imageUrl: String? = null, // https://cdn.myanimelist.net/images/anime/1000/110531.jpg
    @SerializedName("kids")
    val kids: Boolean? = null, // false
    @SerializedName("licensors")
    val licensors: List<String>? = null,
    @SerializedName("mal_id")
    val malId: Int? = null, // 40028
    @SerializedName("members")
    val members: Int? = null, // 1123762
    @SerializedName("producers")
    val producers: List<Producer>? = null,
    @SerializedName("r18")
    val r18: Boolean? = null, // false
    @SerializedName("score")
    var score: Double? = null, // 8.99
    @SerializedName("source")
    val source: String? = null, // Manga
    @SerializedName("synopsis")
    val synopsis: String? = null, // Gabii Braun and Falco Grice have been training their entire lives to inherit one of the seven titans under Marley's control and aid their nation in eradicating the Eldians on Paradis. However, just as all seems well for the two cadets, their peace is suddenly shaken by the arrival of Eren Yeager and the remaining members of the Survey Corps.Having finally reached the Yeager family basement and learned about the dark history surrounding the titans, the Survey Corps has at long last found the answer they so desperately fought to uncover. With the truth now in their hands, the group set out for the world beyond the walls.In Shingeki no Kyojin: The Final Season, two utterly different worlds collide as each party pursues its own agenda in the long-awaited conclusion to Paradis' fight for freedom.[Written by MAL Rewrite]
    @SerializedName("title")
    val title: String? = null, // Shingeki no Kyojin: The Final Season
    @SerializedName("type")
    val type: String? = null, // TV
    @SerializedName("url")
    val url: String? = null // https://myanimelist.net/anime/40028/Shingeki_no_Kyojin__The_Final_Season
) {
    @Keep
    data class Genre(
        @SerializedName("mal_id")
        val malId: Int? = null, // 1
        @SerializedName("name")
        val name: String? = null, // Action
        @SerializedName("type")
        val type: String? = null, // anime
        @SerializedName("url")
        val url: String? = null // https://myanimelist.net/anime/genre/1/Action
    )

    @Keep
    data class Producer(
        @SerializedName("mal_id")
        val malId: Int? = null, // 569
        @SerializedName("name")
        val name: String? = null, // MAPPA
        @SerializedName("type")
        val type: String? = null, // anime
        @SerializedName("url")
        val url: String? = null // https://myanimelist.net/anime/producer/569/MAPPA
    )
}

@Keep
data class TopItem(
    @SerializedName("end_date")
    val endDate: Any?, // null
    @SerializedName("image_url")
    val imageUrl: String, // https://cdn.myanimelist.net/images/manga/1/157897.jpg?s=f03b5f8bfeb0b0962b7d5e7cb9a8d0d3
    @SerializedName("mal_id")
    val malId: Int, // 2
    @SerializedName("members")
    val members: Int, // 426254
    @SerializedName("rank")
    val rank: Int, // 1
    @SerializedName("score")
    val score: Double, // 9.39
    @SerializedName("start_date")
    val startDate: String, // Aug 1989
    @SerializedName("title")
    val title: String, // Berserk
    @SerializedName("type")
    val type: String, // Manga
    @SerializedName("url")
    val url: String, // https://myanimelist.net/manga/2/Berserk
    @SerializedName("volumes")
    val volumes: Any? // null
)

@Keep
data class SearchItem(
    @SerializedName("airing")
    val airing: Boolean, // false
    @SerializedName("end_date")
    val endDate: String, // 2006-06-15T00:00:00+00:00
    @SerializedName("episodes")
    val episodes: Int, // 11
    @SerializedName("image_url")
    val imageUrl: String, // https://cdn.myanimelist.net/images/anime/7/82756.jpg?s=af5b6f86f533257886aa8d8fa4914f5c
    @SerializedName("mal_id")
    val malId: Int, // 13503
    @SerializedName("members")
    val members: Int, // 269
    @SerializedName("rated")
    val rated: String, // PG-13
    @SerializedName("score")
    val score: Int, // 0
    @SerializedName("start_date")
    val startDate: String, // 2006-04-06T00:00:00+00:00
    @SerializedName("synopsis")
    val synopsis: String, // The TV adaptation of the ONA series. Unlike the ONA, which has 10 episodes, this series has 11 episodes.
    @SerializedName("title")
    val title: String, // Cofun Gal no Coffy (TV)
    @SerializedName("type")
    val type: String, // TV
    @SerializedName("url")
    val url: String // https://myanimelist.net/anime/13503/Cofun_Gal_no_Coffy_TV
)

@Keep
data class RecommendedItem(
    @SerializedName("image_url")
    val imageUrl: String, // https://cdn.myanimelist.net/images/anime/5/82890.jpg?s=b8b3b76d7d72c1730859e6e0f7a88dd7
    @SerializedName("mal_id")
    val malId: Int, // 32615
    @SerializedName("recommendation_count")
    val recommendationCount: Int, // 7
    @SerializedName("recommendation_url")
    val recommendationUrl: String, // https://myanimelist.net/recommendations/anime/32615-40028
    @SerializedName("title")
    val title: String, // Youjo Senki
    @SerializedName("url")
    val url: String // https://myanimelist.net/anime/32615/Youjo_Senki
)

/* Different Item Classes */

// 1 - Response for api https://api.jikan.moe/v3/schedule .
@Keep
data class ScheduleAnimeResponse(
    @SerializedName("request_cache_expiry")
    val requestCacheExpiry: Int, // 31805
    @SerializedName("request_cached")
    val requestCached: Boolean, // true
    @SerializedName("request_hash")
    val requestHash: String, // request:anime:b716caa2f73812e089a24ff0fa7cf43505f62362
    @SerializedName("monday")
    val monday: List<AnimeItem>? = null,
    @SerializedName("tuesday")
    val tuesday: List<AnimeItem>? = null,
    @SerializedName("wednesday")
    val wednesday: List<AnimeItem>? = null,
    @SerializedName("thursday")
    val thursday: List<AnimeItem>? = null,
    @SerializedName("friday")
    val friday: List<AnimeItem>? = null,
    @SerializedName("saturday")
    val saturday: List<AnimeItem>? = null,
    @SerializedName("sunday")
    val sunday: List<AnimeItem>? = null,
    @SerializedName("other")
    val other: List<AnimeItem>? = null,
    @SerializedName("unknown")
    val unknown: List<AnimeItem>? = null,
)


// 2 - Response for api https://api.jikan.moe/v3/season/2021/winter .
@Keep
data class SeasonAnimeResponse(
    @SerializedName("request_cache_expiry")
    val requestCacheExpiry: Int, // 31805
    @SerializedName("request_cached")
    val requestCached: Boolean, // true
    @SerializedName("request_hash")
    val requestHash: String, // request:anime:b716caa2f73812e089a24ff0fa7cf43505f62362
    @SerializedName("season_name")
    val seasonName: String,
    @SerializedName("season_year")
    val seasonYear: Int,
    @SerializedName("anime")
    val anime: List<AnimeItem>
)


// 3 to 7 - Response for api https://api.jikan.moe/v3/top/anime/0/movie | https://api.jikan.moe/v3/top/anime/0/tv | https://api.jikan.moe/v3/top/anime/0/upcoming | https://api.jikan.moe/v3/top/anime/0/airing | https://api.jikan.moe/v3/top/manga/0/manga .
@Keep
data class TopResponse(
    @SerializedName("request_cache_expiry")
    val requestCacheExpiry: Int, // 31805
    @SerializedName("request_cached")
    val requestCached: Boolean, // true
    @SerializedName("request_hash")
    val requestHash: String, // request:anime:b716caa2f73812e089a24ff0fa7cf43505f62362
    @SerializedName("top")
    val top: List<TopItem>? = null
)


// 8 - Response for api https://api.jikan.moe/v3/search/anime?q=Loffy&page=1
@Keep
data class SearchResponse(
    @SerializedName("last_page")
    val lastPage: Int, // 31805
    @SerializedName("request_cache_expiry")
    val requestCacheExpiry: Int, // 31805
    @SerializedName("request_cached")
    val requestCached: Boolean, // true
    @SerializedName("request_hash")
    val requestHash: String, // request:anime:b716caa2f73812e089a24ff0fa7cf43505f62362
    @SerializedName("results")
    val results: List<SearchItem>
)


// 9 - Response for api https://api.jikan.moe/v3/anime/40028
@Keep
data class AnimeDetailResponse(
    @SerializedName("aired")
    val aired: Aired,
    @SerializedName("airing")
    val airing: Boolean, // false
    @SerializedName("background")
    val background: Any?, // null
    @SerializedName("broadcast")
    val broadcast: String, // Mondays at 00:10 (JST)
    @SerializedName("duration")
    val duration: String, // 23 min per ep
    @SerializedName("ending_themes")
    val endingThemes: List<String>,
    @SerializedName("episodes")
    val episodes: Int, // 16
    @SerializedName("favorites")
    val favorites: Int, // 44133
    @SerializedName("genres")
    val genres: List<Genre>,
    @SerializedName("image_url")
    val imageUrl: String, // https://cdn.myanimelist.net/images/anime/1000/110531.jpg
    @SerializedName("licensors")
    val licensors: List<Licensor>,
    @SerializedName("mal_id")
    val malId: Int, // 40028
    @SerializedName("members")
    val members: Int, // 1125924
    @SerializedName("opening_themes")
    val openingThemes: List<String>,
    @SerializedName("popularity")
    val popularity: Int, // 74
    @SerializedName("premiered")
    val premiered: String, // Winter 2021
    @SerializedName("producers")
    val producers: List<Producer>,
    @SerializedName("rank")
    val rank: Int, // 11
    @SerializedName("rating")
    val rating: String, // R - 17+ (violence & profanity)
    @SerializedName("related")
    val related: Related,
    @SerializedName("request_cache_expiry")
    val requestCacheExpiry: Int, // 85946
    @SerializedName("request_cached")
    val requestCached: Boolean, // true
    @SerializedName("request_hash")
    val requestHash: String, // request:anime:929520a76c6b1167b54e1067860ebb44f7d94b3a
    @SerializedName("score")
    val score: Double, // 8.99
    @SerializedName("scored_by")
    val scoredBy: Int, // 631196
    @SerializedName("source")
    val source: String, // Manga
    @SerializedName("status")
    val status: String, // Finished Airing
    @SerializedName("studios")
    val studios: List<Studio>,
    @SerializedName("synopsis")
    val synopsis: String, // Gabii Braun and Falco Grice have been training their entire lives to inherit one of the seven titans under Marley's control and aid their nation in eradicating the Eldians on Paradis. However, just as all seems well for the two cadets, their peace is suddenly shaken by the arrival of Eren Yeager and the remaining members of the Survey Corps. Having finally reached the Yeager family basement and learned about the dark history surrounding the titans, the Survey Corps has at long last found the answer they so desperately fought to uncover. With the truth now in their hands, the group set out for the world beyond the walls. In Shingeki no Kyojin: The Final Season, two utterly different worlds collide as each party pursues its own agenda in the long-awaited conclusion to Paradis' fight for freedom. [Written by MAL Rewrite]
    @SerializedName("title")
    val title: String, // Shingeki no Kyojin: The Final Season
    @SerializedName("title_english")
    val titleEnglish: String, // Attack on Titan Final Season
    @SerializedName("title_japanese")
    val titleJapanese: String, // 進撃の巨人 The Final Season
    @SerializedName("title_synonyms")
    val titleSynonyms: List<String>,
    @SerializedName("trailer_url")
    val trailerUrl: String, // https://www.youtube.com/embed/SlNpRThS9t8?enablejsapi=1&wmode=opaque&autoplay=1
    @SerializedName("type")
    val type: String, // TV
    @SerializedName("url")
    val url: String // https://myanimelist.net/anime/40028/Shingeki_no_Kyojin__The_Final_Season
) {
    @Keep
    data class Aired(
        @SerializedName("from")
        val from: String, // 2020-12-07T00:00:00+00:00
        @SerializedName("prop")
        val prop: Prop,
        @SerializedName("string")
        val string: String, // Dec 7, 2020 to Mar 29, 2021
        @SerializedName("to")
        val to: String // 2021-03-29T00:00:00+00:00
    ) {
        @Keep
        data class Prop(
            @SerializedName("from")
            val from: From,
            @SerializedName("to")
            val to: To
        ) {
            @Keep
            data class From(
                @SerializedName("day")
                val day: Int, // 7
                @SerializedName("month")
                val month: Int, // 12
                @SerializedName("year")
                val year: Int // 2020
            )

            @Keep
            data class To(
                @SerializedName("day")
                val day: Int, // 29
                @SerializedName("month")
                val month: Int, // 3
                @SerializedName("year")
                val year: Int // 2021
            )
        }
    }

    @Keep
    data class Genre(
        @SerializedName("mal_id")
        val malId: Int, // 1
        @SerializedName("name")
        val name: String, // Action
        @SerializedName("type")
        val type: String, // anime
        @SerializedName("url")
        val url: String // https://myanimelist.net/anime/genre/1/Action
    )

    @Keep
    data class Licensor(
        @SerializedName("mal_id")
        val malId: Int, // 102
        @SerializedName("name")
        val name: String, // Funimation
        @SerializedName("type")
        val type: String, // anime
        @SerializedName("url")
        val url: String // https://myanimelist.net/anime/producer/102/Funimation
    )

    @Keep
    data class Producer(
        @SerializedName("mal_id")
        val malId: Int, // 10
        @SerializedName("name")
        val name: String, // Production I.G
        @SerializedName("type")
        val type: String, // anime
        @SerializedName("url")
        val url: String // https://myanimelist.net/anime/producer/10/Production_IG
    )

    @Keep
    data class Related(
        @SerializedName("Adaptation")
        val adaptation: List<Adaptation>,
        @SerializedName("Prequel")
        val prequel: List<Prequel>,
        @SerializedName("Sequel")
        val sequel: List<Sequel>
    ) {
        @Keep
        data class Adaptation(
            @SerializedName("mal_id")
            val malId: Int, // 23390
            @SerializedName("name")
            val name: String, // Shingeki no Kyojin
            @SerializedName("type")
            val type: String, // manga
            @SerializedName("url")
            val url: String // https://myanimelist.net/manga/23390/Shingeki_no_Kyojin
        )

        @Keep
        data class Prequel(
            @SerializedName("mal_id")
            val malId: Int, // 38524
            @SerializedName("name")
            val name: String, // Shingeki no Kyojin Season 3 Part 2
            @SerializedName("type")
            val type: String, // anime
            @SerializedName("url")
            val url: String // https://myanimelist.net/anime/38524/Shingeki_no_Kyojin_Season_3_Part_2
        )

        @Keep
        data class Sequel(
            @SerializedName("mal_id")
            val malId: Int, // 48583
            @SerializedName("name")
            val name: String, // Shingeki no Kyojin: The Final Season Part 2
            @SerializedName("type")
            val type: String, // anime
            @SerializedName("url")
            val url: String // https://myanimelist.net/anime/48583/Shingeki_no_Kyojin__The_Final_Season_Part_2
        )
    }

    @Keep
    data class Studio(
        @SerializedName("mal_id")
        val malId: Int, // 569
        @SerializedName("name")
        val name: String, // MAPPA
        @SerializedName("type")
        val type: String, // anime
        @SerializedName("url")
        val url: String // https://myanimelist.net/anime/producer/569/MAPPA
    )
}


// 10 - Response for api https://api.jikan.moe/v3/anime/40028/characters_staff
@Keep
data class CharactersResponse(
    @SerializedName("characters")
    val characters: List<Character>,
    @SerializedName("request_cache_expiry")
    val requestCacheExpiry: Int, // 31805
    @SerializedName("request_cached")
    val requestCached: Boolean, // true
    @SerializedName("request_hash")
    val requestHash: String, // request:anime:b716caa2f73812e089a24ff0fa7cf43505f62362
    @SerializedName("staff")
    val staff: List<Staff>
) {
    @Keep
    data class Character(
        @SerializedName("image_url")
        val imageUrl: String? = null, // https://cdn.myanimelist.net/images/characters/14/177967.jpg?s=613b9d9167b4775b2ffbb6385adf5b9d
        @SerializedName("mal_id")
        val malId: Int? = null, // 65407
        @SerializedName("name")
        val name: String? = null, // He Liao, Diao
        @SerializedName("role")
        val role: String? = null, // Main
        @SerializedName("url")
        val url: String? = null, // https://myanimelist.net/character/65407/Diao_He_Liao
        @SerializedName("voice_actors")
        val voiceActors: List<VoiceActor>? = null
    ) {
        @Keep
        data class VoiceActor(
            @SerializedName("image_url")
            val imageUrl: String, // https://cdn.myanimelist.net/r/42x62/images/voiceactors/3/63374.jpg?s=b834d16ead8ec560bcfcbc2da93ae6a2
            @SerializedName("language")
            val language: String, // Japanese
            @SerializedName("mal_id")
            val malId: Int, // 8
            @SerializedName("name")
            val name: String, // Kugimiya, Rie
            @SerializedName("url")
            val url: String // https://myanimelist.net/people/8/Rie_Kugimiya
        )
    }

    @Keep
    data class Staff(
        @SerializedName("image_url")
        val imageUrl: String, // https://cdn.myanimelist.net/images/questionmark_23.gif?s=f7dcbc4a4603d18356d3dfef8abd655c
        @SerializedName("mal_id")
        val malId: Int, // 16373
        @SerializedName("name")
        val name: String, // Imaizumi, Kenichi
        @SerializedName("positions")
        val positions: List<String>,
        @SerializedName("url")
        val url: String // https://myanimelist.net/people/16373/Kenichi_Imaizumi
    )
}


// 11 - Response for api https://api.jikan.moe/v3/anime/40028/recommendations
@Keep
data class RecommendationResponse(
    @SerializedName("request_cache_expiry")
    val requestCacheExpiry: Int, // 31805
    @SerializedName("request_cached")
    val requestCached: Boolean, // true
    @SerializedName("request_hash")
    val requestHash: String, // request:anime:b716caa2f73812e089a24ff0fa7cf43505f62362
    @SerializedName("recommendations")
    val recommendations: List<RecommendedItem>? = null
)


// 12 - Response for api https://api.jikan.moe/v3/manga/2
@Keep
data class MangaDetailsResponse(
    @SerializedName("authors")
    val authors: List<Author>,
    @SerializedName("background")
    val background: String, // Berserk won the Award for Excellence at the sixth installment of Tezuka Osamu Cultural Prize in 2002.The series has over 40 million copies in print worldwide and has been published in English by Dark Horse since November 4, 2003. It is also published in Italy, Germany, Spain, France, Brazil, South Korea, Hong Kong, Taiwan, Thailand, Poland, México and Turkey.
    @SerializedName("chapters")
    val chapters: Any?, // null
    @SerializedName("favorites")
    val favorites: Int, // 79987
    @SerializedName("genres")
    val genres: List<Genre>,
    @SerializedName("image_url")
    val imageUrl: String, // https://cdn.myanimelist.net/images/manga/1/157897.jpg
    @SerializedName("mal_id")
    val malId: Int, // 2
    @SerializedName("members")
    val members: Int, // 426367
    @SerializedName("popularity")
    val popularity: Int, // 2
    @SerializedName("published")
    val published: Published,
    @SerializedName("publishing")
    val publishing: Boolean, // true
    @SerializedName("rank")
    val rank: Int, // 1
    @SerializedName("related")
    val related: Related,
    @SerializedName("request_cache_expiry")
    val requestCacheExpiry: Int, // 54186
    @SerializedName("request_cached")
    val requestCached: Boolean, // true
    @SerializedName("request_hash")
    val requestHash: String, // request:manga:b14647e65b60fc2d7016968e186c3f52a50ea28e
    @SerializedName("score")
    val score: Double, // 9.39
    @SerializedName("scored_by")
    val scoredBy: Int, // 200946
    @SerializedName("serializations")
    val serializations: List<Serialization>,
    @SerializedName("status")
    val status: String, // Publishing
    @SerializedName("synopsis")
    val synopsis: String, // Guts, a former mercenary now known as the "Black Swordsman," is out for revenge. After a tumultuous childhood, he finally finds someone he respects and believes he can trust, only to have everything fall apart when this person takes away everything important to Guts for the purpose of fulfilling his own desires. Now marked for death, Guts becomes condemned to a fate in which he is relentlessly pursued by demonic beings. Setting out on a dreadful quest riddled with misfortune, Guts, armed with a massive sword and monstrous strength, will let nothing stop him, not even death itself, until he is finally able to take the head of the one who stripped him—and his loved one—of their humanity. [Written by MAL Rewrite] Included one-shot: Volume 14: Berserk: The Prototype
    @SerializedName("title")
    val title: String, // Berserk
    @SerializedName("title_english")
    val titleEnglish: String, // Berserk
    @SerializedName("title_japanese")
    val titleJapanese: String, // ベルセルク
    @SerializedName("title_synonyms")
    val titleSynonyms: List<String>,
    @SerializedName("type")
    val type: String, // Manga
    @SerializedName("url")
    val url: String, // https://myanimelist.net/manga/2/Berserk
    @SerializedName("volumes")
    val volumes: Any? // null
) {
    @Keep
    data class Author(
        @SerializedName("mal_id")
        val malId: Int, // 1868
        @SerializedName("name")
        val name: String, // Miura, Kentarou
        @SerializedName("type")
        val type: String, // people
        @SerializedName("url")
        val url: String // https://myanimelist.net/people/1868/Kentarou_Miura
    )

    @Keep
    data class Genre(
        @SerializedName("mal_id")
        val malId: Int, // 1
        @SerializedName("name")
        val name: String, // Action
        @SerializedName("type")
        val type: String, // manga
        @SerializedName("url")
        val url: String // https://myanimelist.net/manga/genre/1/Action
    )

    @Keep
    data class Published(
        @SerializedName("from")
        val from: String, // 1989-08-25T00:00:00+00:00
        @SerializedName("prop")
        val prop: Prop,
        @SerializedName("string")
        val string: String, // Aug  25, 1989 to ?
        @SerializedName("to")
        val to: Any? // null
    ) {
        @Keep
        data class Prop(
            @SerializedName("from")
            val from: From,
            @SerializedName("to")
            val to: To
        ) {
            @Keep
            data class From(
                @SerializedName("day")
                val day: Int, // 25
                @SerializedName("month")
                val month: Int, // 8
                @SerializedName("year")
                val year: Int // 1989
            )

            @Keep
            data class To(
                @SerializedName("day")
                val day: Any?, // null
                @SerializedName("month")
                val month: Any?, // null
                @SerializedName("year")
                val year: Any? // null
            )
        }
    }

    @Keep
    data class Related(
        @SerializedName("Adaptation")
        val adaptation: List<Adaptation>,
        @SerializedName("Other")
        val other: List<Other>,
        @SerializedName("Spin-off")
        val spinOff: List<SpinOff>
    ) {
        @Keep
        data class Adaptation(
            @SerializedName("mal_id")
            val malId: Int, // 10218
            @SerializedName("name")
            val name: String, // Berserk: Ougon Jidai-hen I - Haou no Tamago
            @SerializedName("type")
            val type: String, // anime
            @SerializedName("url")
            val url: String // https://myanimelist.net/anime/10218/Berserk__Ougon_Jidai-hen_I_-_Haou_no_Tamago
        )

        @Keep
        data class Other(
            @SerializedName("mal_id")
            val malId: Int, // 92299
            @SerializedName("name")
            val name: String, // Berserk: Shinen no Kami 2
            @SerializedName("type")
            val type: String, // manga
            @SerializedName("url")
            val url: String // https://myanimelist.net/manga/92299/Berserk__Shinen_no_Kami_2
        )

        @Keep
        data class SpinOff(
            @SerializedName("mal_id")
            val malId: Int, // 106677
            @SerializedName("name")
            val name: String, // Berserk: Honoo Ryuu no Kishi
            @SerializedName("type")
            val type: String, // manga
            @SerializedName("url")
            val url: String // https://myanimelist.net/manga/106677/Berserk__Honoo_Ryuu_no_Kishi
        )
    }

    @Keep
    data class Serialization(
        @SerializedName("mal_id")
        val malId: Int, // 2
        @SerializedName("name")
        val name: String, // Young Animal
        @SerializedName("type")
        val type: String, // manga
        @SerializedName("url")
        val url: String // https://myanimelist.net/manga/magazine/2/Young_Animal
    )
}
