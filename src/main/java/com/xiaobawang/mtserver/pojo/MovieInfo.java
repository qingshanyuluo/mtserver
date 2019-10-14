package com.xiaobawang.mtserver.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "movieInfo")
public class MovieInfo {
    @Column(name="movietitle")
    private String movietitle;

    @Column(name="movieimage")
    private String movieimage;

    @Column(name="movietype")
    private String movietype;

    @Column(name="country")
    private String country;

    @Column(name="showtime")
//    @JsonFormat(pattern = "yyyy年MM月dd日 HH:mm:ss")
    private String showtime;

    @Column(name="content")
    private String content;

    @Column(name="map")
    private String map;

    @Id
    @Column(name="movieid")
    private Integer movieid;

    @Column(name = "othername")
    private String othername;

    @Column(name="placenums")
    private Integer placenums;

    public String getMovietitle() {
        return movietitle;
    }

    public void setMovietitle(String movietitle) {
        this.movietitle = movietitle;
    }

    public String getMovieimage() {
        return movieimage;
    }

    public void setMovieimage(String movieimage) {
        this.movieimage = movieimage;
    }

    public String getMovietype() {
        return movietype;
    }

    public void setMovietype(String movietype) {
        this.movietype = movietype;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getShowtime() {
        return showtime;
    }

    public void setShowtime(String showtime) {
        this.showtime = showtime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public Integer getMovieid() {
        return movieid;
    }

    public void setMovieid(Integer movieid) {
        this.movieid = movieid;
    }

    public String getOthername() {
        return othername;
    }

    public void setOthername(String othername) {
        this.othername = othername;
    }

    public Integer getPlacenums() {
        return placenums;
    }

    public void setPlacenums(Integer placenums) {
        this.placenums = placenums;
    }
}
