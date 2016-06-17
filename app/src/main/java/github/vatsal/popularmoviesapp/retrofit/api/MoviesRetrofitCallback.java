package github.vatsal.popularmoviesapp.retrofit.api;

import android.app.Activity;
import android.content.Context;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by nuhbye on 07/03/16.
 */
public abstract class MoviesRetrofitCallback<S> implements Callback {
    Activity activity;
    Context context;

    public MoviesRetrofitCallback(Activity activity) {
        this.activity = activity;
    }

    public MoviesRetrofitCallback(Context context) {
        this.context = context;
    }

    @Override
    public void onResponse(Call call, Response response) {
        common();
        onResponseMoviesResponse(call, response);

        Object obj = response.body();
        if (obj != null) {
            S objectResponse = (S) obj;
            onResponseMoviesObject(call, objectResponse);
        }
    }

    @Override
    public void onFailure(Call call, Throwable t) {
        common();
        //onFailureMovies(call, t);
    }

    /**
     * Invoked for a received HTTP response.
     * <p/>
     * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
     * Call {@link Response#isSuccess()} to determine if the response indicates success.
     */
    protected abstract void onResponseMoviesResponse(Call call, Response response);

    /**
     * Invoked for a received HTTP response.
     * <p/>
     * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
     * Call {@link Response#isSuccess()} to determine if the response indicates success.
     */
    protected abstract void onResponseMoviesObject(Call call, S response);

    /**
     * Invoked when a network exception occurred talking to the server or when an unexpected
     * exception occurred creating the request or processing the response.
     */
    //protected abstract void onFailureMovies(Call call, Throwable t);

    /**
     * Invoked everyTime
     */
    protected abstract void common();
}
