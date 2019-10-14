package com.xiaobawang.mtserver.dao;

import com.xiaobawang.mtserver.pojo.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface MovieInfoDao {
    @Select("select * from movieInfo where movieid=#{movieid}")
    public MovieInfo selectMovieInfoById(@Param("movieid") int movieid);

    @Select("SELECT COUNT(placeid) from movieplot WHERE movieid = #{movieid}")
    int selectMoviePlots(@Param("movieid") int movieid);

    @Select("select movieimage,movieid from movieInfo ORDER BY showtime LIMIT 6")
    public List<MovieInfo> selectMovieImageByTimeTop6();

    @Select("select movieid,movieimage from movieInfo Limit 4")
    public List<MovieInfo> selectMovieLunBo();

    @Select("select movieplot.placeid,movieplot.movieid,placecname,placeename,placelocation,placeimg from movieplot,movieInfo where movieInfo.movieid = movieplot.movieid and movieplot.movieid=#{movieid}")
    public List<MoviePlot> selectPlotsList(int movieid);

    @Select("select * from mpcomment where movieid = #{movieid} ORDER BY puttime desc")
    public List<Comment> MovieComments(int movieid);

    @Insert("INSERT INTO mpcomment (userid,username,headimage,comment,movieid) VALUES (#{userId},#{username},#{headimage},#{content},#{movieid})")
    int postComment(int movieid, String content, int userId, String headimage, String username);

    @Select("SELECT * FROM movieInfo ORDER BY showtime DESC LIMIT 10")
    List<MovieInfo> getRecentUpdate();

    @Select("SELECT * FROM movieInfo WHERE LENGTH(content) > 300 and showtime>2017 ORDER BY LENGTH(content) DESC")
    List<MovieInfo> getHotMovie();

    @Select("SELECT * FROM movieInfo WHERE LENGTH(content) > 300 and showtime>2018 ORDER BY LENGTH(content) DESC")
    List<MovieInfo> getHomeMovieList();

    @Select("SELECT * FROM userhobby WHERE userId = #{userId} and tag = 0")
    List<UserHobby> getHobbyList(Integer userId);

    @Select("SELECT * FROM movieInfo WHERE movieid = #{objId}")
    MovieInfo getMovieById(Integer objId);

    @Select("SELECT * FROM movieInfo WHERE movietitle like '%${value}%'")
    List<MovieInfo> searchMovie(String value);

    @Select("select * from movieInfo")
    List<MovieInfo> selectAllMovie();

    @Select("select * from movieInfo where movieid = 4852 or movieid = 4686 or movieid = 4855 or movieid = 4845 or movieid = 4836")
    List<MovieInfo> getAoSiKa();

    @Select("select * from movieInfo where country=#{type} and showtime between 2018 and 2019")
    List<MovieInfo> getCountry(String type);

    @Select("select * from movieInfo where movieid = 4627 or movieid = 4686 or movieid = 4624")
    List<MovieInfo> getBeiTuoLuQi();

    @Select("select * from movieInfo where movieid = 4608 or movieid = 4681 or movieid = 4429 or movieid = 4392 or movieid = 4441 or movieid = 4749 or movieid = 4599")
    List<MovieInfo> getJinMaJiang();

    @Select("select movieplot.* from movieInfo,movieplot where movieInfo.movieid = movieplot.movieid and movieInfo.movieid = #{movieid}")
    List<MoviePlot> getMovieRoute(int movieid);

    @Select("select * from movieInfo where movietype = #{valueOf}")
    List<MovieInfo> selectMovieListByType(String valueOf);

    @Select("select placeId,placeCname,placeLocation,coverPath,placeEname,lng,lat from place where placeId in (select placeid from movieInfo,movieplot where movieInfo.movieid = movieplot.movieid and movieInfo.movieid = #{movieid})")
    List<PlaceInfo> getLngLat(int movieid);

    @Select("SELECT placeCname,placeEname,placeId,coverPath,placeLocation,(6371393 * ACOS(COS(RADIANS(#{lng})) * COS(RADIANS(lat)) * COS(RADIANS(#{lat} - lng))+ SIN(RADIANS(#{lng})) * SIN(RADIANS(lat)))) AS distance, lng, lat FROM place WHERE placeCname in (select placecname from movieplot,movieInfo where movieInfo.movieid = movieplot.movieid and movieplot.movieid=#{movieid}) ORDER BY distance")
    List<PlaceInfo> getZuiJinDistance(int movieid, double lat, double lng);
}

