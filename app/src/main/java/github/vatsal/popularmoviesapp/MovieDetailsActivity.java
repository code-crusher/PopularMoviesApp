package github.vatsal.popularmoviesapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import github.vatsal.popularmoviesapp.Utils.Constants;
import github.vatsal.popularmoviesapp.retrofit.api.MoviesResponseModelItem;

/**
 * Created by appyware on 03/01/16.
 */
public class MovieDetailsActivity extends AppCompatActivity {

    @Bind(R.id.movie_poster)
    ImageView moviePoster;
    @Bind(R.id.movie_name)
    TextView movieName;
    @Bind(R.id.movie_vote)
    TextView movieVote;
    @Bind(R.id.movie_date)
    TextView movieDate;
    @Bind(R.id.movie_plot)
    TextView moviePlot;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ButterKnife.bind(this);

        MoviesResponseModelItem movieItem = (MoviesResponseModelItem) getIntent().getExtras().getSerializable(Constants.MOVIE_ITEM_KEY);
        init(movieItem);

    }

    private void init(MoviesResponseModelItem movieItem) {

        Picasso.with(getBaseContext()).load("http://image.tmdb.org/t/p/w185" + movieItem.getBackdropPath()).into(moviePoster);
        movieName.setText(movieItem.getTitle());
        movieDate.setText("Released : " + movieItem.getReleaseDate());
        movieVote.setText("Avg Rating : " + movieItem.getVoteAverage());
        moviePlot.setText(movieItem.getOverview());


    }

}

