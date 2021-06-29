package com.TheKing.videoplex.ui.model;

import java.util.ArrayList;
import java.util.Date;

class Artist_Data{
    String ID;
    String Name;
    String Gender;
    Date Birthdate;
    String Thumbnail_URL;
    ArrayList<String> Photo_URL;
    String Nationality;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public Date getBirthdate() {
        return Birthdate;
    }

    public void setBirthdate(Date birthdate) {
        Birthdate = birthdate;
    }

    public String getThumbnail_URL() {
        return Thumbnail_URL;
    }

    public void setThumbnail_URL(String thumbnail_URL) {
        Thumbnail_URL = thumbnail_URL;
    }

    public ArrayList<String> getPhoto_URL() {
        return Photo_URL;
    }

    public void setPhoto_URL(ArrayList<String> photo_URL) {
        Photo_URL = photo_URL;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
    }
}