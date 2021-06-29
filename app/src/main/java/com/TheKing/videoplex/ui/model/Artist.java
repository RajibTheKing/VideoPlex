package com.TheKing.videoplex.ui.model;
import java.util.ArrayList;
import java.util.Date;

public class Artist {
    ArrayList<Artist_Data> ArtistData;

    public ArrayList<Artist_Data> getArtistData() {
        return ArtistData;
    }

    public void setArtistData(ArrayList<Artist_Data> artistData) {
        ArtistData = artistData;
    }

    public String toString() {

        String result = "";
        for(int i = 0; i<ArtistData.size(); i++){
            Artist_Data data = ArtistData.get(i);
            String curr = String.format("{ID:%s,Name:%s,Gender:%s,Birthdate:%s,Nationality:%s}",
                    data.ID, data.Name, data.Gender, data.Birthdate.toString(), data.Nationality);
            result = result + curr + "\n";


        }
        return result;
    }


}
