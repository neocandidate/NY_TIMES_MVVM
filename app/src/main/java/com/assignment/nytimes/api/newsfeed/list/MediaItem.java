package com.assignment.nytimes.api.newsfeed.list;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MediaItem {

    @SerializedName("copyright")
    private String copyright;

    @SerializedName("media-metadata")
    private List<MediaMetadataItem> mediaMetadata;

    @SerializedName("subtype")
    private String subtype;

    @SerializedName("caption")
    private String caption;

    @SerializedName("type")
    private String type;

    @SerializedName("approved_for_syndication")
    private int approvedForSyndication;

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public List<MediaMetadataItem> getMediaMetadata() {
        return mediaMetadata;
    }

    public void setMediaMetadata(List<MediaMetadataItem> mediaMetadata) {
        this.mediaMetadata = mediaMetadata;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getApprovedForSyndication() {
        return approvedForSyndication;
    }

    public void setApprovedForSyndication(int approvedForSyndication) {
        this.approvedForSyndication = approvedForSyndication;
    }

    @Override
    public String toString() {
        return
                "MediaItem{" +
                        "copyright = '" + copyright + '\'' +
                        ",media-metadata = '" + mediaMetadata + '\'' +
                        ",subtype = '" + subtype + '\'' +
                        ",caption = '" + caption + '\'' +
                        ",type = '" + type + '\'' +
                        ",approved_for_syndication = '" + approvedForSyndication + '\'' +
                        "}";
    }
}