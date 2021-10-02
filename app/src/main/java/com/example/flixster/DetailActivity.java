package com.example.flixster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.TextView;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.flixster.models.Movie;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.parceler.Parcels;

import okhttp3.Headers;

public class DetailActivity extends YouTubeBaseActivity {

    private static final String YOUTUBE_API_KEY = "AIzaSyD4wzfwUIZJDC2MGO7b1-afGTRmMbORAd4";
    private static final String VIDEO_URL = "https://api.themoviedb.org/3/movie/%d/videos?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";

    TextView dtvTitle;
    RatingBar drbRating;
    TextView dtvOverview;
    TextView tvDate;
    TextView tvAge;
    TextView tvVoteCount;
    YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        dtvTitle = findViewById(R.id.dtvTitle);
        drbRating = findViewById(R.id.drbRating);
        dtvOverview = findViewById(R.id.dtvOverview);
        youTubePlayerView = findViewById(R.id.player);
        tvDate = findViewById(R.id.tvDate);
        tvAge = findViewById(R.id.tvAge);
        tvVoteCount = findViewById(R.id.tvVoteCount);

        String title = getIntent().getStringExtra("title");
        Movie movie = Parcels.unwrap(getIntent().getParcelableExtra("movie"));
        dtvTitle.setText(movie.getTitle());
        dtvOverview.setText(movie.getOverview());
        drbRating.setRating((float)movie.getVote());

        tvDate.setText("Release Date: " + movie.getReleaseDate());
        if(movie.getAgeRating() == false)
        {
            tvAge.setText("Appropriate for Children");
        }
        else
        {
            tvAge.setText("Not Appropriate for Children");
        }

        tvVoteCount.setText(movie.getVoteCount() + " Votes");

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(String.format(VIDEO_URL, movie.getMovieID()), new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                try {
                    JSONArray results = json.jsonObject.getJSONArray("results");
                    if(results.length() == 0)
                    {
                        return;
                    }

                    String youtubeKey = results.getJSONObject(0).getString("key");
                    Log.d("DetailActivity", youtubeKey);
                    
                    initializeYoutube(youtubeKey);

                } catch (JSONException e) {
                    Log.e("DetailActivity", "JSON Parsing Failed");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {

            }
        });
    }

    private void initializeYoutube(String youtubeKey) {
        youTubePlayerView.initialize(YOUTUBE_API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.cueVideo(youtubeKey);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.e("DetailActivity", "Error Initializing Youtube Player");
            }
        });
    }
}