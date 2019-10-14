package com.xiaobawang.mtserver.services;

import com.xiaobawang.mtserver.dao.MovieInfoDao;
import com.xiaobawang.mtserver.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MovieServices {

    @Autowired
    MovieInfoDao movieInfoDao;

    public MovieInfo selectMovieInfoById(int movieid) {
        if (movieid == 0) {
            return null;
        } else {
            MovieInfo tmp = movieInfoDao.selectMovieInfoById(movieid);
            int placeNums = movieInfoDao.selectMoviePlots(movieid);
            tmp.setPlacenums(placeNums);
            return tmp;
        }
    }

    public List<MovieInfo> selectMovieImageByTimeTop6() {
        List<MovieInfo> movieInfo = movieInfoDao.selectMovieImageByTimeTop6();
        if (movieInfo != null) {
            for (MovieInfo info : movieInfo) {
                int n = movieInfoDao.selectMoviePlots(info.getMovieid());
                info.setPlacenums(n);
            }
            return movieInfo;
        } else {
            return null;
        }
    }

    public List<MovieInfo> selectMovieLunBo() {
        List<MovieInfo> list = movieInfoDao.selectMovieLunBo();
        if (list != null) {
            for (MovieInfo info : list) {
                int n = movieInfoDao.selectMoviePlots(info.getMovieid());
                info.setPlacenums(n);
            }
            return list;
        } else {
            return null;
        }
    }

    public List<MovieInfo> selectMovieList(int type) {
        List<MovieInfo> list;
        if (type == -1) {
            list = movieInfoDao.selectAllMovie();
            for (MovieInfo info : list) {
                int n = movieInfoDao.selectMoviePlots(info.getMovieid());
                info.setPlacenums(n);
            }
        } else {
            list = movieInfoDao.selectMovieListByType(String.valueOf(type));
            for (MovieInfo info : list) {
                int n = movieInfoDao.selectMoviePlots(info.getMovieid());
                info.setPlacenums(n);
            }
        }
        return list;
    }

    public List<MoviePlot> selectPlotsList(int movieid) {
        return movieInfoDao.selectPlotsList(movieid);
    }

    public List<Comment> MovieComment(int movieid) {
        return movieInfoDao.MovieComments(movieid);
    }

    public boolean postComment(int movieid, String content, int userId, String headimage, String username) {
        int flag = movieInfoDao.postComment(movieid, content, userId, headimage, username);
        return flag == 1;
    }

    public List<MovieInfo> getRecentUpdate() {
     
        List<MovieInfo> list =  movieInfoDao.getRecentUpdate();
        for (MovieInfo info : list) {
            int n = movieInfoDao.selectMoviePlots(info.getMovieid());
            info.setPlacenums(n);
        }
        return list;
    }

    public List<MovieInfo> getHotMovie() {
       
        List<MovieInfo> list =  movieInfoDao.getHotMovie();
        for (MovieInfo info : list) {
            int n = movieInfoDao.selectMoviePlots(info.getMovieid());
            info.setPlacenums(n);
        }
        return list;
    }

    public List<MovieInfo> getHomeMovieList() {
       

        List<MovieInfo> list = movieInfoDao.getHomeMovieList();
        for (MovieInfo info : list) {
            int n = movieInfoDao.selectMoviePlots(info.getMovieid());
            info.setPlacenums(n);
        }
        return list;
    }

    public List<MovieInfo> getMovieHobby(Integer userId) {
        List<UserHobby> hobbyList = movieInfoDao.getHobbyList(userId);
        List<MovieInfo> movieList = new ArrayList<>();
      
        for (UserHobby hobby : hobbyList) {
            MovieInfo movie = movieInfoDao.getMovieById(hobby.getObjId());
            movieList.add(movie);
        }
        return movieList;
    }

    public List<MovieInfo> searchMovie(String value) {
    
        List<MovieInfo> list = movieInfoDao.searchMovie(value);
        for (MovieInfo info : list) {
            int n = movieInfoDao.selectMoviePlots(info.getMovieid());
            info.setPlacenums(n);
        }
        return list;
    }

   
    public List<MovieInfo> getAoSiKa() {
       
       List<MovieInfo> list = movieInfoDao.getAoSiKa();
       for (MovieInfo info : list) {
           int n = movieInfoDao.selectMoviePlots(info.getMovieid());
           info.setPlacenums(n);
       }
       return list;
    }

    
    public List<MovieInfo> getCountry(String type) {
     
        List<MovieInfo> list = movieInfoDao.getCountry(type);
        for (MovieInfo info : list) {
            int n = movieInfoDao.selectMoviePlots(info.getMovieid());
            info.setPlacenums(n);
        }
        return list;
    }

   
    public List<MovieInfo> getBeiTuoLuNi() {
       
        List<MovieInfo> list = movieInfoDao.getBeiTuoLuQi();
        for (MovieInfo info : list) {
            int n = movieInfoDao.selectMoviePlots(info.getMovieid());
            info.setPlacenums(n);
        }
        return list;
    }

   
    public List<MovieInfo> getJinMaJiang() {
        
        List<MovieInfo> list = movieInfoDao.getJinMaJiang();
        for (MovieInfo info : list) {
            int n = movieInfoDao.selectMoviePlots(info.getMovieid());
            info.setPlacenums(n);
        }
        return list;
    }

   
    public List<MoviePlot> getMovieRoute(int movieid) {

        return movieInfoDao.getMovieRoute(movieid);
    
    }

    public List<PlaceInfo> getLngLat(int movieid){
        return movieInfoDao.getLngLat(movieid);
    }

    public List<PlaceInfo> getZuiJinDistance(int movieid,String lng,String lat){
        return movieInfoDao.getZuiJinDistance(movieid,Double.parseDouble(lng),Double.parseDouble(lat));
    }

}


