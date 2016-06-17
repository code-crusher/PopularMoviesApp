package github.vatsal.popularmoviesapp.retrofit.api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by
 * --Vatsal Bajpai under
 * --AppyWare on
 * --17/06/16 at
 * --3:16 PM in
 * --PopularMoviesApp
 */
public class MoviesResponseModel implements Serializable {

    private Integer page;

    private List<MoviesResponseModelItem> results = new ArrayList<MoviesResponseModelItem>();

    private Integer totalResults;

    private Integer totalPages;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<MoviesResponseModelItem> getResults() {
        return results;
    }

    public void setResults(List<MoviesResponseModelItem> results) {
        this.results = results;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }
}
