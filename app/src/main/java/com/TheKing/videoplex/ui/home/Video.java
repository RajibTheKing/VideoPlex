package com.TheKing.videoplex.ui.home;

import java.util.ArrayList;
import java.util.Date;

public class Video {
    ArrayList<Video_Data> VideoData;

    public ArrayList<Video_Data> getVideoData() {
        return VideoData;
    }

    public void setVideoData(ArrayList<Video_Data> videoData) {
        VideoData = videoData;
    }

    public String toString() {

        String result = "";
        for(int i = 0; i<VideoData.size(); i++){
            Video_Data data = VideoData.get(i);
            String curr = String.format("{ID:%s,Category:%s,Title:%s,URL:%s}",
                    data.ID, data.Category, data.Title, data.URL);
            result = result + curr + "\n";


        }
        return result;
    }
}

class Video_Data{
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
    String Country;
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

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
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

class CastObj {
    String actor;
    String actor_id;
    String character;

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getActor_id() {
        return actor_id;
    }

    public void setActor_id(String actor_id) {
        this.actor_id = actor_id;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
}

class RatingObj {
    String Source;
    String Value;

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }
}
