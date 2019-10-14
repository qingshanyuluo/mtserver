package com.xiaobawang.mtserver.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "placeInfo")
public class PlaceInfo {

    @Column(name = "placename")
    private String placename;

    @Column(name = "placelocation")
    private String placelocation;

    @Column(name = "placetype")
    private String placetype;

    @Column(name = "identitylevel")
    private String identitylevel;

    @Column(name = "map")
    private String map;

    @Column(name = "content")
    private String content;

    @Id
    @Column(name = "placeid")
    private Integer placeid;

    @Column(name = "placeimage")
    private String placeimage;
//数据库更新信息

    private String lng;

    private String lat;

    private String placeCname;

    private String placeEname;

    private String CoverPath;

    private int distance;

    public String getPlaceimage() {
        return placeimage;
    }

    public void setPlaceimage(String placeimage) {
        this.placeimage = placeimage;
    }

    public String getPlacename() {
        return placename;
    }

    public void setPlacename(String placename) {
        this.placename = placename;
    }

    public String getPlacelocation() {
        return placelocation;
    }

    public void setPlacelocation(String placelocation) {
        this.placelocation = placelocation;
    }

    public String getPlacetype() {
        return placetype;
    }

    public void setPlacetype(String placetype) {
        this.placetype = placetype;
    }

    public String getIdentitylevel() {
        return identitylevel;
    }

    public void setIdentitylevel(String identitylevel) {
        this.identitylevel = identitylevel;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPlaceid() {
        return placeid;
    }

    public void setPlaceid(Integer placeid) {
        this.placeid = placeid;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getPlaceCname() {
        return placeCname;
    }

    public void setPlaceCname(String placeCname) {
        this.placeCname = placeCname;
    }

    public String getPlaceEname() {
        return placeEname;
    }

    public void setPlaceEname(String placeEname) {
        this.placeEname = placeEname;
    }

    public String getCoverPath() {
        return CoverPath;
    }

    public void setCoverPath(String coverPath) {
        CoverPath = coverPath;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
