package com.xiaobawang.mtserver.controller;

import com.xiaobawang.mtserver.pojo.*;
import com.xiaobawang.mtserver.services.MovieServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieServices movieServices;

    @RequestMapping("movieinfo/{movieId}")
    public JsonResult MovieInfo(@PathVariable("movieId") Integer movieId) {
        JsonResult result = new JsonResult();
        MovieInfo movieInfo = movieServices.selectMovieInfoById(movieId);
        if (movieInfo != null) {
            result.setResults(movieInfo);
            result.setStatus("0");
            result.setErrorcode("-1");
        } else {
            result.setStatus("-1");
            result.setResults(null);
            result.setErrorcode("0");
        }
        return result;
    }

    @RequestMapping("movielunbo")
    public JsonResult MovieLunBo() {
        JsonResult jsonResult = new JsonResult();
        List<MovieInfo> lunBo = movieServices.selectMovieLunBo();
        if (lunBo != null) {
            jsonResult.setStatus("0");
            jsonResult.setErrorcode("-1");
            jsonResult.setResults(lunBo);
        } else {
            jsonResult.setResults(null);
            jsonResult.setStatus("-1");
            jsonResult.setErrorcode("0");
        }
        return jsonResult;
    }

    @RequestMapping("smallpictures")
    public JsonResult MovieSmallPictures() {
        JsonResult result = new JsonResult();
        List<MovieInfo> movieInfo = movieServices.selectMovieImageByTimeTop6();
        if (movieInfo != null) {
            result.setErrorcode("-1");
            result.setStatus("0");
            result.setResults(movieInfo);
        } else {
            result.setResults(null);
            result.setStatus("-1");
            result.setErrorcode("0");
        }
        return result;
    }

    @RequestMapping("movielist/{type}")
    public JsonResult MovieList(@PathVariable("type") Integer type) {
        JsonResult result = new JsonResult();
        List<MovieInfo> list = movieServices.selectMovieList(type);
        if (list != null) {
            result.setErrorcode("-1");
            result.setStatus("0");
            result.setResults(list);
        } else {
            result.setResults(null);
            result.setStatus("-1");
            result.setErrorcode("0");
        }

        return result;
    }

    @RequestMapping("movieplots/{movieid}")
    public JsonResult MoviePlotsList(@PathVariable("movieid") int movieid) {
        JsonResult result = new JsonResult();
        List<MoviePlot> list = movieServices.selectPlotsList(movieid);
        if (list != null) {
            result.setErrorcode("-1");
            result.setStatus("0");
            result.setResults(list);
        } else {
            result.setResults(null);
            result.setStatus("-1");
            result.setErrorcode("0");
        }
        return result;
    }

    @RequestMapping("moviecomment/{id}")
    public JsonResult MovieComment(@PathVariable("id") int movieid) {
        JsonResult result = new JsonResult();
        List<Comment> list = movieServices.MovieComment(movieid);
        if (list != null) {
            result.setErrorcode("-1");
            result.setStatus("0");
            result.setResults(list);
        } else {
            result.setResults(null);
            result.setStatus("-1");
            result.setErrorcode("0");
        }
        return result;
    }

    @RequestMapping("moviepostcomment/{id}")
    public JsonResult MoviePostComment(@PathVariable("id") int movieid,
                                       @RequestParam("content") String content,
                                       @RequestParam("userId") int userId,
                                       @RequestParam("headImage") String headImage,
                                       @RequestParam("userName") String username) {
        JsonResult result = new JsonResult();
        boolean flag = movieServices.postComment(movieid, content, userId, headImage, username);
        if (flag == true) {
            result.setErrorcode("-1");
            result.setStatus("0");
            result.setResults("评论成功");
        } else {
            result.setErrorcode("0");
            result.setStatus("-1");
            result.setResults("评论失败");
        }
        return result;
    }


    //    获取最近更新的电影列表
    @RequestMapping("getRecentUpdate")
    public JsonResult getRecentUpdate() {
        JsonResult j = new JsonResult();
        List<MovieInfo> list = movieServices.getRecentUpdate();
        j.setErrorcode("0");
        j.setStatus("1");
        j.setResults(list);
        return j;
    }

    //    获取热门电影的列表
    @RequestMapping("getHotMovie")
    public JsonResult getHotMovie() {
        JsonResult j = new JsonResult();
        List<MovieInfo> list = movieServices.getHotMovie();
        j.setErrorcode("0");
        j.setStatus("1");
        j.setResults(list);
        return j;
    }

    //    获取首页电影列表
    @RequestMapping("getHomeMovieList")
    public JsonResult getHomeMovieList() {
        JsonResult j = new JsonResult();
        List<MovieInfo> list = movieServices.getHomeMovieList();
        j.setErrorcode("0");
        j.setStatus("1");
        j.setResults(list);
        return j;
    }

    //    获取个人电影关注列表
    @RequestMapping("getMovieHobby")
    public JsonResult getMovieHobby(@RequestParam("userId") Integer userId) {
        JsonResult j = new JsonResult();
        List<MovieInfo> list = movieServices.getMovieHobby(userId);
        j.setResults(list);
        j.setStatus("success");
        j.setErrorcode("0");
        return j;
    }

    @RequestMapping("searchMovie")
    public JsonResult searchMovie(@RequestParam("value") String value) {
        JsonResult j = new JsonResult();
        List<MovieInfo> list = movieServices.searchMovie(value);
        j.setResults(list);
        j.setStatus("success");
        j.setErrorcode("0");
        return j;
    }


    //电影专题奥斯卡电影列表
    @RequestMapping("movieaosika")
    public JsonResult getAoSiKa() {
        JsonResult result = new JsonResult();
        List<MovieInfo> list = movieServices.getAoSiKa();
        if (list != null) {
            result.setErrorcode("-1");
            result.setStatus("0");
            result.setResults(list);
        } else {
            result.setResults(null);
            result.setStatus("-1");
            result.setErrorcode("0");
        }
        return result;
    }

    //电影专题洛杉矶电影之城列表
    @RequestMapping("moviecountry/{type}")
    public JsonResult getCountry(@PathVariable("type") String type) {
        JsonResult result = new JsonResult();
        List<MovieInfo> list = movieServices.getCountry(type);
        if (list != null) {
            result.setErrorcode("-1");
            result.setStatus("0");
            result.setResults(list);
        } else {
            result.setResults(null);
            result.setStatus("-1");
            result.setErrorcode("0");
        }
        return result;
    }

    //电影专题贝托鲁奇列表
    @RequestMapping("moviebeituoluqi")
    public JsonResult getBeiTuoLuQi() {
        JsonResult result = new JsonResult();
        List<MovieInfo> list = movieServices.getBeiTuoLuNi();
        if (list != null) {
            result.setErrorcode("-1");
            result.setStatus("0");
            result.setResults(list);
        } else {
            result.setResults(null);
            result.setStatus("-1");
            result.setErrorcode("0");
        }
        return result;
    }

    //电影专题金马奖列表
    @RequestMapping("moviejinmajiang")
    public JsonResult getJinMaJiang() {
        JsonResult result = new JsonResult();
        List<MovieInfo> list = movieServices.getJinMaJiang();
        if (list != null) {
            result.setErrorcode("-1");
            result.setStatus("0");
            result.setResults(list);
        } else {
            result.setResults(null);
            result.setStatus("-1");
            result.setErrorcode("0");
        }
        return result;
    }

    //还原电影路线导航
    @RequestMapping("movieroute/{movieid}")
    public JsonResult getMovieRoute(@PathVariable("movieid") int movieid) {
        JsonResult result = new JsonResult();
        List<MoviePlot> list = movieServices.getMovieRoute(movieid);
        if (list != null) {
            result.setErrorcode("-1");
            result.setStatus("0");
            result.setResults(list);
        } else {
            result.setResults(null);
            result.setStatus("-1");
            result.setErrorcode("0");
        }
        return result;
    }

    //获取经纬度
    @RequestMapping("movieplotLngLat/{movieid}")
    public JsonResult getLngLat(@PathVariable("movieid") int movieid) {
        JsonResult result = new JsonResult();
        List<PlaceInfo> list = movieServices.getLngLat(movieid);
        if (list != null) {
            result.setErrorcode("-1");
            result.setStatus("0");
            result.setResults(list);
        } else {
            result.setResults(null);
            result.setStatus("-1");
            result.setErrorcode("0");
        }
        return result;
    }

    //获取最近的前几个地点
    @RequestMapping("zuijindistance/{movieid}")
    public JsonResult getZuiJinDistance(@PathVariable("movieid") int movieid, @RequestParam(value = "lng") String lng, @RequestParam(value = "lat") String lat) {
        JsonResult result = new JsonResult();
        List<PlaceInfo> list = movieServices.getZuiJinDistance(movieid, lng, lat);
        if (list != null) {
            result.setErrorcode("-1");
            result.setStatus("0");
            result.setResults(list);
        } else {
            result.setResults(null);
            result.setStatus("-1");
            result.setErrorcode("0");
        }
        return result;
    }
}