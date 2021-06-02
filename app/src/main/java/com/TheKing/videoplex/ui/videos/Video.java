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
    Date Release_Date;
    long Viewcount;
    long Likes;
    long Dislikes;
    String URL;
    String Length;
    ArrayList<String> Genre;
    String Quality;
    String Country;
    String Language;
    ArrayList<String> Director;
    ArrayList<String> Producer;
    String Publisher;
    Date Upload_Date;
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

    public Date getRelease_Date() {
        return Release_Date;
    }

    public void setRelease_Date(Date release_Date) {
        Release_Date = release_Date;
    }

    public long getViewcount() {
        return Viewcount;
    }

    public void setViewcount(long viewcount) {
        Viewcount = viewcount;
    }

    public long getLikes() {
        return Likes;
    }

    public void setLikes(long likes) {
        Likes = likes;
    }

    public long getDislikes() {
        return Dislikes;
    }

    public void setDislikes(long dislikes) {
        Dislikes = dislikes;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getLength() {
        return Length;
    }

    public void setLength(String length) {
        Length = length;
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

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public Date getUpload_Date() {
        return Upload_Date;
    }

    public void setUpload_Date(Date upload_Date) {
        Upload_Date = upload_Date;
    }

    public ArrayList<String> getRating() {
        return Rating;
    }

    public void setRating(ArrayList<String> rating) {
        Rating = rating;
    }
}

/*
            "ID" : "1",
            "Title" : "Biye | বিয়ে ",
            "Category": "Natok",
            "Thumbnail_URL": "",
            "Artist_ID": ["1","2"],
            "Release_Date":"29-05-2020",
            "Viewcount" : 8912631,
            "Likes" : 146000,
            "Dislikes" : 10000,
            "URL" : "https://www.youtube.com/watch?v=tVwf4AMxHos" ,
            "Length" : "00-40-46",
            "Genre" : [],
            "Quality" : "1080p60",
            "Country" : "Bangladesh",
            "Language" : "Bangla",
            "Director" : ["Jakaria Showkhin"],
            "Producer" : ["Kachi Ahmed"],
            "Publisher": "Eagle Premier Station",
            "Upload_Date" : "29-05-2020",
            "Rating":[]
 */