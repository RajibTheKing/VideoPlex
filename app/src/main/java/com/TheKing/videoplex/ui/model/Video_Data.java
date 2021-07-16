package com.TheKing.videoplex.ui.model;

import com.TheKing.videoplex.ui.model.CastObj;
import com.TheKing.videoplex.ui.model.RatingObj;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class Video_Data{
    String ID;
    String Title;
    String Category;
    ArrayList<CastObj> Cast;
    String Thumbnail_URL;

    Date PublishedAt;
    long ViewCount;
    long LikeCount;
    long DislikeCount;
    String URL;
    String Duration;
    ArrayList<String> Genre;
    String Quality;
    ArrayList<String> Country;
    ArrayList<String> Language;
    ArrayList<String> Director;
    ArrayList<String> Producer;
    String ChannelTitle;
    String UpdatedAt;
    ArrayList<RatingObj> Ratings;
    String Year;
    String Released;
    ArrayList<String> Writer;
    String Plot;
    String Poster;
    String IMDBId;
    String BoxOffice;
    ArrayList<String> Production;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public ArrayList<CastObj> getCast() {
        return Cast;
    }

    public void setCast(ArrayList<CastObj> cast) {
        Cast = cast;
    }

    public String getThumbnail_URL() {
        return Thumbnail_URL;
    }

    public void setThumbnail_URL(String thumbnail_URL) {
        Thumbnail_URL = thumbnail_URL;
    }

    public Date getPublishedAt() {
        return PublishedAt;
    }

    public void setPublishedAt(Date publishedAt) {
        PublishedAt = publishedAt;
    }

    public long getViewCount() {
        return ViewCount;
    }

    public void setViewCount(long viewCount) {
        ViewCount = viewCount;
    }

    public long getLikeCount() {
        return LikeCount;
    }

    public void setLikeCount(long likeCount) {
        LikeCount = likeCount;
    }

    public long getDislikeCount() {
        return DislikeCount;
    }

    public void setDislikeCount(long dislikeCount) {
        DislikeCount = dislikeCount;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public ArrayList<String> getGenre() {
        return Genre;
    }

    public void setGenre(ArrayList<String> genre) {
        Genre = genre;
    }

    public String getQuality() {
        return Quality;
    }

    public void setQuality(String quality) {
        Quality = quality;
    }

    public ArrayList<String> getCountry() {
        return Country;
    }

    public void setCountry(ArrayList<String> country) {
        Country = country;
    }

    public ArrayList<String> getLanguage() {
        return Language;
    }

    public void setLanguage(ArrayList<String> language) {
        Language = language;
    }

    public ArrayList<String> getDirector() {
        return Director;
    }

    public void setDirector(ArrayList<String> director) {
        Director = director;
    }

    public ArrayList<String> getProducer() {
        return Producer;
    }

    public void setProducer(ArrayList<String> producer) {
        Producer = producer;
    }

    public String getChannelTitle() {
        return ChannelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        ChannelTitle = channelTitle;
    }

    public String getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        UpdatedAt = updatedAt;
    }

    public ArrayList<RatingObj> getRatings() {
        return Ratings;
    }

    public void setRatings(ArrayList<RatingObj> ratings) {
        Ratings = ratings;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getReleased() {
        return Released;
    }

    public void setReleased(String released) {
        Released = released;
    }

    public ArrayList<String> getWriter() {
        return Writer;
    }

    public void setWriter(ArrayList<String> writer) {
        Writer = writer;
    }

    public String getPlot() {
        return Plot;
    }

    public void setPlot(String plot) {
        Plot = plot;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }

    public String getIMDBId() {
        return IMDBId;
    }

    public void setIMDBId(String IMDBId) {
        this.IMDBId = IMDBId;
    }

    public String getBoxOffice() {
        return BoxOffice;
    }

    public void setBoxOffice(String boxOffice) {
        BoxOffice = boxOffice;
    }

    public ArrayList<String> getProduction() {
        return Production;
    }

    public void setProduction(ArrayList<String> production) {
        Production = production;
    }
}