package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Movie
{
    String backdropPath;
    String posterPath;
    String title;
    String overview;
    double vote;
    int movieID;
    String voteCount;
    boolean ageRating;
    String releaseDate;

    //Parceler Library empty constructor
    public Movie() {}


    public Movie(JSONObject jsonObject) throws JSONException
    {
        backdropPath = jsonObject.getString("backdrop_path");
        posterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        vote = jsonObject.getDouble("vote_average");
        movieID = jsonObject.getInt("id");
        voteCount = jsonObject.getString("vote_count");
        ageRating = jsonObject.getBoolean("adult");
        releaseDate = jsonObject.getString("release_date");
    }

    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException
    {
        List<Movie> movies = new ArrayList<>();
        for(int i = 0; i < movieJsonArray.length(); i++)
        {
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }

        return movies;
    }

    public String getPosterPath()
    {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getBackdropPath()
    {
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdropPath);
    }

    public String getTitle()
    {
        return title;
    }

    public String getOverview()
    {
        return overview;
    }

    public double getVote()
    {
        return vote;
    }

    public int getMovieID() {
        return movieID;
    }

    public String getVoteCount(){
        return voteCount;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public boolean getAgeRating() {
        return ageRating;
    }
}
