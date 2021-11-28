package com.morse.retrofit.executor

import com.google.gson.GsonBuilder
import com.morse.animeslayercompose.domain.*
import com.morse.animeslayercompose.remote.FlowCallAdapterFactory
import com.morse.retrofit.core.ApiGate
import kotlinx.coroutines.flow.Flow
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitBuilder {

    private var retrofit: Retrofit? = null

    private fun getInstance(): Retrofit {
        if (retrofit == null) {
            var gson = GsonBuilder().disableHtmlEscaping()
            retrofit = Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create(gson.create()))
                .addCallAdapterFactory(FlowCallAdapterFactory())
                .client(getClientInstance())
                .build()
        }

        return retrofit!!
    }

    public fun getNetworkInteractor(): ApiGate {
        return getInstance()?.create(ApiGate::class.java)
    }

    private fun getClientInstance(): OkHttpClient {

        val loggingInterceptor = HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }
        val okHttp = OkHttpClient.Builder().apply {
            this.readTimeout(30, TimeUnit.SECONDS)
            this.connectTimeout(30, TimeUnit.SECONDS)
            this.writeTimeout(30, TimeUnit.SECONDS)
            this.addInterceptor(loggingInterceptor)
        }
        return okHttp.build()
    }

}

const val DEFAULT_PAGE_INDEX = 0
const val DEFAULT_SEARCH_NAME = "Loffy"

interface RemoteGate {
     fun getSeasonAnimeFromRemote(season: String, year: String): Flow<SeasonAnimeResponse> 

     fun getScheduleAnimeFromRemote(): Flow<ScheduleAnimeResponse> 

     fun getTopAnimeMoviesFromRemote(): Flow<TopResponse>

     fun getTopAnimeTvShowsFromRemote(): Flow<TopResponse> 

     fun getTopAnimeUpComingFromRemote(): Flow<TopResponse>

     fun getTopAnimeAiringFromRemote(): Flow<TopResponse>

     fun getAnimeDetailsFromRemote(animeId: Int): Flow<AnimeDetailResponse> 

     fun getAnimeCharactersFromRemote(animeId: Int): Flow<CharactersResponse> 

     fun getAnimeRecommendationsFromRemote(animeId: Int): Flow<RecommendationResponse> 

     fun getTopMangaFromRemote(): Flow<TopResponse>

     fun getMangaDetailFromRemote(mangaId: Int): Flow<MangaDetailsResponse> 

     fun searchOnMangaFromRemote(mangaName: String): Flow<SearchResponse>

     fun searchOnAnimeFromRemote(animeName: String): Flow<SearchResponse>
     
}

class RetrofitExecutor(
    private val api: ApiGate,
) : RemoteGate {

    override fun getSeasonAnimeFromRemote(season: String, year: String): Flow<SeasonAnimeResponse> {
        return api.getSeasonAnime(season = season, year = year)
    }

    override fun getScheduleAnimeFromRemote(): Flow<ScheduleAnimeResponse> {
        return api.getScheduleAnime()
    }

    override fun getTopAnimeMoviesFromRemote(): Flow<TopResponse> {
        return api.getTopAnimesMovies(DEFAULT_PAGE_INDEX)
    }

    override fun getTopAnimeTvShowsFromRemote(): Flow<TopResponse> {
        return api.getTopAnimesTV(DEFAULT_PAGE_INDEX)
    }

    override fun getTopAnimeUpComingFromRemote(): Flow<TopResponse> {
        return api.getTopAnimesUpcoming(DEFAULT_PAGE_INDEX)
    }

    override fun getTopAnimeAiringFromRemote(): Flow<TopResponse> {
        return api.getTopAnimesAiring(DEFAULT_PAGE_INDEX)
    }

    override fun getAnimeDetailsFromRemote(animeId: Int): Flow<AnimeDetailResponse> {
        return api.getAnimeDetail(animeId = animeId)
    }

    override fun getAnimeCharactersFromRemote(animeId: Int): Flow<CharactersResponse> {
        return api.getAnimeCharacters(animeId)
    }

    override fun getAnimeRecommendationsFromRemote(animeId: Int): Flow<RecommendationResponse> {
        return api.getAnimeRecommendaion(animeId = animeId)
    }

    override fun getTopMangaFromRemote(): Flow<TopResponse> {
        return api.getTopAnimesTV(DEFAULT_PAGE_INDEX)
    }

    override fun getMangaDetailFromRemote(mangaId: Int): Flow<MangaDetailsResponse> {
        return api.getMangaDetail(mangaId = mangaId)
    }

    override fun searchOnMangaFromRemote(mangaName: String): Flow<SearchResponse> {
        return api.searchAboutMangaWithName(DEFAULT_SEARCH_NAME , DEFAULT_PAGE_INDEX)
    }

    override fun searchOnAnimeFromRemote(animeName: String): Flow<SearchResponse> {
        return api.searchAboutAnimeWithName(DEFAULT_SEARCH_NAME , DEFAULT_PAGE_INDEX)
    }
}