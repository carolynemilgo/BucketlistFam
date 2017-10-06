package com.example.carol.bucketlistfam;

/**
 * Created by carol on 10/5/17.
 */



import org.parceler.Parcel;
@Parcel
public class Event {

    private String text;
    private String retweeted;
    private String name;
    private int followers;
    private String imageUrl;
    private int retweets;
    private String pushId;
    String index;

    public Event(String text,  String name,  String imageUrl) {
        this.text = text;

        this.name = name;

        this.imageUrl = getLargeImageUrl(imageUrl);

        this.index = "not_specified";
    }

    public Event() {}

    public String getText() {
        return text;
    }

    public String getName() {
        return name;
    }



    public String getImageUrl() {
        return imageUrl;
    }



    public String getLargeImageUrl(String imageUrl) {
        String largeImageUrl = imageUrl.replace("_normal","");
        return largeImageUrl;
    }
//
//    public String getPushId() {
//        return pushId;
//    }
//
//    public void setPushId(String pushId) {
//        this.pushId = pushId;
//    }
//
//    public String getIndex() {
//        return index;
//    }
//
//    public void setIndex(String index) {
//        this.index = index;
//    }
}
