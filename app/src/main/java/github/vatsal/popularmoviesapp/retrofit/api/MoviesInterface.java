package github.vatsal.popularmoviesapp.retrofit.api;

import github.vatsal.popularmoviesapp.BuildConfig;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MoviesInterface {

    String POSTFIX = BuildConfig.MOBDB_API_KEY;

    @GET("3/movie/popular?api_key=" + POSTFIX)
    Call<MoviesResponseModel> getPopularMovies();
}
