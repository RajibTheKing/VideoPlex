package com.TheKing.videoplex.ui.videos;

import android.provider.ContactsContract;

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
    String Thumbnail_URL;
    ArrayList<String> Artist_ID;
    Date PublishedAt;
    long ViewCount;
    long LikeCount;
    long DislikeCount;
    String URL;
    String Duration;
    ArrayList<String> Genre;
    String Quality;
    String Country;
    String Language;
    ArrayList<String> Director;
    ArrayList<String> Producer;
    String ChannelTitle;
    String UpdatedAt;
    ArrayList<String> Rating;

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

    public String getThumbnail_URL() {
        return Thumbnail_URL;
    }

    public void setThumbnail_URL(String thumbnail_URL) {
        Thumbnail_URL = thumbnail_URL;
    }

    public ArrayList<String> getArtist_ID() {
        return Artist_ID;
    }

    public void setArtist_ID(ArrayList<String> artist_ID) {
        Artist_ID = artist_ID;
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

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
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

    public ArrayList<String> getRating() {
        return Rating;
    }

    public void setRating(ArrayList<String> rating) {
        Rating = rating;
    }
}
