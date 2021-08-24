package com.example.newtrainigproject.model;

import android.widget.ImageView;

import com.google.gson.annotations.SerializedName;

public class RetrofitListModel {
    @SerializedName("name")
    private String CharacterName;
    @SerializedName("realname")
    private String RealName;
    @SerializedName("team")
    private String Team;
    @SerializedName("firstappearance")
    private Integer FirstAppearance;
    @SerializedName("createdby")
    private String CreatedBy;
    @SerializedName("publisher")
    private String Publisher;
    @SerializedName("bio")
    private String Bio;
    @SerializedName("imageurl")
    private String CharacterImage;

    public String getCharacterName() {
        return CharacterName;
    }

    public void setCharacterName(String characterName) {
        CharacterName = characterName;
    }

    public String getRealName() {
        return RealName;
    }

    public void setRealName(String realName) {
        RealName = realName;
    }

    public String getTeam() {
        return Team;
    }

    public void setTeam(String team) {
        Team = team;
    }




    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String createdBy) {
        CreatedBy = createdBy;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public String getBio() {
        return Bio;
    }

    public void setBio(String bio) {
        Bio = bio;
    }

    public String getCharacterImage() {
        return CharacterImage;
    }

    public void setCharacterImage(String characterImage) {
        CharacterImage = characterImage;
    }


    public Integer getFirstAppearance() {
        return FirstAppearance;
    }

    public void setFirstAppearance(Integer firstAppearance) {
        FirstAppearance = firstAppearance;
    }
}
