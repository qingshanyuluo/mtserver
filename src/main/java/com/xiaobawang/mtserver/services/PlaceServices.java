package com.xiaobawang.mtserver.services;

import com.xiaobawang.mtserver.dao.PlaceInfoDao;
import com.xiaobawang.mtserver.pojo.Comment;
import com.xiaobawang.mtserver.pojo.PlaceInfo;
import com.xiaobawang.mtserver.pojo.UserHobby;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PlaceServices {

    @Autowired
    PlaceInfoDao placeInfoDao;

    public PlaceInfo selectPlaceInfoById(int placeid) {
        if (placeid == 0) {
            return null;
        } else {
            PlaceInfo tmp = placeInfoDao.selectPlaceInfoById(placeid);
            return tmp;
        }
    }

    public List<PlaceInfo> selectPlaceLunBo() {
        List<PlaceInfo> list = placeInfoDao.selectPlaceLunBo();
        if (list != null) {
            return list;
        } else {
            return null;
        }
    }

    public List<PlaceInfo> selectPlaceImageByHotTop5() {
        List<PlaceInfo> placeInfos = placeInfoDao.selectPlaceImageByHotTop5();
        if (placeInfos != null) {
            return placeInfos;
        } else {
            return null;
        }
    }

    public List<PlaceInfo> selectPlaceList(String type, Integer begin, Integer limit) {
        return placeInfoDao.selectPlaceList(type, begin, limit);
    }

    public List<PlaceInfo> selectNearMovieList(String city) {
        List<PlaceInfo> list = placeInfoDao.selectNearPlaceList(city);
        if (list != null) {
            return list;
        } else {
            return null;
        }
    }

    public boolean postComment(int placeid, String content, int userId, String headimage, String username) {
        int flag = placeInfoDao.postComment(placeid, content, userId, headimage, username);
        if (flag == 1) {
            return true;
        } else {
            return false;
        }
    }

    public List<Comment> PlaceComment(int placeid) {
        List<Comment> list = placeInfoDao.PlaceComments(placeid);
        if (list != null) {
            return list;
        } else {
            return null;
        }
    }

    public List<PlaceInfo> getSlide() {
            return placeInfoDao.getSlide();
        }

    public List<PlaceInfo> getHotPlace() {
            return placeInfoDao.getHotPlace();
        }

    public List<PlaceInfo> getHomePlaceList() {
            return placeInfoDao.getHomePlaceList();
        }

    public List<PlaceInfo> getPlaceHobby(Integer userId) {
        List<UserHobby> hobbyList = placeInfoDao.getHobbyList(userId);
        List<PlaceInfo> placeList = new ArrayList<>();
        for (UserHobby hobby : hobbyList) {
            PlaceInfo place = placeInfoDao.getPlaceById(hobby.getObjId());
            placeList.add(place);
        }
        return placeList;
    }

    public List<PlaceInfo> searchPlace(String value) {
        return placeInfoDao.searchPlace(value);
    }

    public int getListLength(String type) {
        return placeInfoDao.getListLength(type);
    }

    public List<PlaceInfo> getPlaceZhuanTiSea() {
        return placeInfoDao.getPlaceZhuanTiSea();
    }

    public List<PlaceInfo> getPlaceZhuanTiShuDian() {
        return placeInfoDao.getPlaceZhuanTiShuDian();
    }

    public List<PlaceInfo> getPlaceZhuanTiJingAn() {
        return placeInfoDao.getPlaceZhuanTiJingAn();
    }

    public List<PlaceInfo> getPlaceZhuanTiPark() {
        return placeInfoDao.getPlaceZhuanTiPark();
    }

    public List<PlaceInfo> getZhouBian(String location){
        List<PlaceInfo> placeInfos = placeInfoDao.getZhouBian(location);
        if (placeInfos != null) {
            return placeInfos;
        } else {
            return null;
        }
    }

    public List<PlaceInfo> getJingWei(int placeid){
        List<PlaceInfo> placeInfos = placeInfoDao.getJingWei(placeid);
        return placeInfos;
    }

}