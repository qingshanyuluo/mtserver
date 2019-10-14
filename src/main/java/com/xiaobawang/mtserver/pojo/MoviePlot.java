package com.xiaobawang.mtserver.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movieplot")
public class MoviePlot {
    @Id
    @Column(name = "placeid")
    private Integer placeid;

    @Column(name = "movieid")
    private Integer movieid;

    @Column(name = "placecname")
    private String placecname;

    @Column(name = "placelocation")
    private String placelocation;

    @Column(name = "placeimg")
    private String placeimg;

    @Column(name = "placeename")
    private String placeename;

    public Integer getPlaceid() {
        return placeid;
    }

    public void setPlaceid(Integer placeid) {
        this.placeid = placeid;
    }

    public Integer getMovieid() {
        return movieid;
    }

    public void setMovieid(Integer movieid) {
        this.movieid = movieid;
    }

    public String getPlacecname() {
        return placecname;
    }

    public void setPlacecname(String placecname) {
        this.placecname = placecname;
    }

    public String getPlacelocation() {
        return placelocation;
    }

    public void setPlacelocation(String placelocation) {
        this.placelocation = placelocation;
    }

    public String getPlaceimg() {
        return placeimg;
    }

    public void setPlaceimg(String placeimg) {
        this.placeimg = placeimg;
    }

    public String getPlaceename() {
        return placeename;
    }

    public void setPlaceename(String placeename) {
        this.placeename = placeename;
    }
}
