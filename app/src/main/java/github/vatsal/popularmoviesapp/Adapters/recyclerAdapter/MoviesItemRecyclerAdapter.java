package github.vatsal.popularmoviesapp.Adapters.recyclerAdapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import github.vatsal.popularmoviesapp.Adapters.viewholders.MovieItemViewHolder;
import github.vatsal.popularmoviesapp.MovieDetailsActivity;
import github.vatsal.popularmoviesapp.R;
import github.vatsal.popularmoviesapp.Utils.Constants;
import github.vatsal.popularmoviesapp.retrofit.api.MoviesResponseModelItem;

/**
 * Created by
 * --Vatsal Bajpai
 */

public class MoviesItemRecyclerAdapter extends RecyclerView.Adapter<MovieItemViewHolder> {

    private Context curr_context;
    private Activity curr_activity;
    private List<MoviesResponseModelItem> itemList;

    public MoviesItemRecyclerAdapter(Activity activity, Context context, List<MoviesResponseModelItem> itemList) {
        this.itemList = itemList;
        this.curr_context = context;
        this.curr_activity = activity;
    }

    @Override
    public MovieItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie, null);

        return new MovieItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieItemViewHolder holder, int position) {
        handleCommentsEvents(holder, position);

    }

    private void handleCommentsEvents(MovieItemViewHolder mVHolder, final int position) {

        MoviesResponseModelItem movieItem = itemList.get(position);
        if (movieItem != null) {
            try {

                Picasso.with(curr_context).load("http://image.tmdb.org/t/p/w185" + movieItem.getPosterPath()).into(mVHolder.moviePoster);

                mVHolder.movieName.setText(movieItem.getTitle());
                mVHolder.movieSortTypedef.setText("" + movieItem.getPopularity().intValue());

                mVHolder.CardView.setOnClickListener(new clickHandler(position, movieItem));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class clickHandler implements View.OnClickListener {

        int position;
        MoviesResponseModelItem movieItem;

        public clickHandler(int position, MoviesResponseModelItem movieItem) {
            this.movieItem = movieItem;
            this.position = position;
        }

        @Override
        public void onClick(View v) {
            int id = v.getId();
            switch (id) {
                case R.id.CardView: {

                    Intent intent = new Intent(curr_activity, MovieDetailsActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(Constants.MOVIE_ITEM_KEY, movieItem);
                    intent.putExtras(bundle);
                    curr_activity.startActivity(intent);

                    break;
                }
            }
        }
    }

}

