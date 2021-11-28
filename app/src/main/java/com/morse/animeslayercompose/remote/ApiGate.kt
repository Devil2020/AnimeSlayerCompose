package com.morse.retrofit.core

import com.morse.animeslayercompose.domain.*
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.QueryName

interface ApiGate {

    @GET ("season/{year}/{season}")
    fun getSeasonAnime(@QueryName season: String,@QueryName year: String) : Flow<SeasonAnimeResponse>

    @GET ("schedule")
    fun getScheduleAnime () : Flow<ScheduleAnimeResponse>

    @GET ("top/anime/{pageIndex}/movie")
    fun getTopAnimesMovies (pageIndex : Int) : Flow<TopResponse>

    @GET ("top/anime/{pageIndex}/tv")
    fun getTopAnimesTV (pageIndex : Int) : Flow<TopResponse>

    @GET ("top/anime/{pageIndex}/upcoming")
    fun getTopAnimesUpcoming (pageIndex : Int) : Flow<TopResponse>

    @GET ("top/manga/{pageIndex}/manga")
    fun getTopManga (pageIndex : Int) : Flow<TopResponse>

    @GET ("top/anime/{pageIndex}/airing")
    fun getTopAnimesAiring (pageIndex : Int) : Flow<TopResponse>

    @GET ("anime/{animeId}")
    fun getAnimeDetail (@QueryName animeId : Int) : Flow<AnimeDetailResponse>

    @GET ("manga/{mangaId}")
    fun getMangaDetail (@QueryName mangaId : Int) : Flow<MangaDetailsResponse>

    @GET ("anime/{animeId}/characters_staff")
    fun getAnimeCharacters (@QueryName animeId : Int) : Flow<CharactersResponse>

    @GET ("anime/{animeId}/recommendations")
    fun getAnimeRecommendaion (@QueryName animeId : Int) : Flow <RecommendationResponse>

    @GET ("search/anime?q={animeName}&page={page}")
    fun searchAboutAnimeWithName (@QueryName animeName : String , @QueryName page : Int) : Flow<SearchResponse>

    @GET ("search/manga?q={managaName}&page={page}")
    fun searchAboutMangaWithName (@QueryName managaName : String, @QueryName page : Int) : Flow<SearchResponse>

}

