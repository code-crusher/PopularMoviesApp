package github.vatsal.popularmoviesapp.Adapters.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import github.vatsal.popularmoviesapp.R;

public class MovieItemViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.movie_poster)
    public ImageView moviePoster;
    @Bind(R.id.movie_name)
    public TextView movieName;
    @Bind(R.id.movie_sort_typedef)
    public TextView movieSortTypedef;
    @Bind(R.id.CardView)
    public android.support.v7.widget.CardView CardView;

    public MovieItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}