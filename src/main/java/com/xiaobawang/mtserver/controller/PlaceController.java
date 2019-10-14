package com.xiaobawang.mtserver.controller;

import com.xiaobawang.mtserver.pojo.Comment;
import com.xiaobawang.mtserver.pojo.JsonResult;
import com.xiaobawang.mtserver.pojo.PlaceInfo;
import com.xiaobawang.mtserver.services.PlaceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/place")
public class PlaceController {
    @Autowired
    private PlaceServices placeServices;

    @RequestMapping("placeinfo/{placeId}")
    public JsonResult PlaceInfo(@PathVariable("placeId") Integer placeId) {
        JsonResult result = new JsonResult();
        PlaceInfo placeInfo = placeServices.selectPlaceInfoById(placeId);
        if (null != placeInfo) {
            result.setResults(placeInfo);
            result.setStatus("0");
            result.setErrorcode("-1");
        } else {
            result.setStatus("-1");
            result.setResults(null);
            result.setErrorcode("0");
        }
        return result;
    }

    @RequestMapping("listlength/{type}")
    public JsonResult getListLength(@PathVariable("type") String type) {
        JsonResult jsonResult = new JsonResult();
        int length;
        if (type.equals("全部")) {
            length = placeServices.getListLength("%");
        } else {
            length = placeServices.getListLength(type);
        }
        jsonResult.setErrorcode("0");
        jsonResult.setStatus("OK");
        jsonResult.setResults(length);
        return jsonResult;
    }

    @RequestMapping("placelunbo")
    public JsonResult PlaceLunBo() {
        JsonResult jsonResult = new JsonResult();
        List<PlaceInfo> lunBo = placeServices.selectPlaceLunBo();
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
    public JsonResult PlaceSmallPictures() {
        JsonResult result = new JsonResult();
        List<PlaceInfo> placeInfos = placeServices.selectPlaceImageByHotTop5();
        if (placeInfos != null) {
            result.setErrorcode("-1");
            result.setStatus("0");
            result.setResults(placeInfos);
        } else {
            result.setResults(null);
            result.setStatus("-1");
            result.setErrorcode("0");
        }
        return result;
    }

    @RequestMapping("placeList")
    public JsonResult PlaceList(@RequestParam("type") String type,
                                @RequestParam("begin") Integer begin,
                                @RequestParam("limit") Integer limit) {
        JsonResult result = new JsonResult();
        List<PlaceInfo> list;
        if (type.equals("全部")) {
            list = placeServices.selectPlaceList("%", begin, limit);

        } else {
            list = placeServices.selectPlaceList(type, begin, limit);

        }
        result.setResults(list);
        result.setStatus("OK");
        result.setErrorcode("0");
        return result;
    }

    @RequestMapping("nearplacelist/{city}")
    public JsonResult NearPlaceList(@PathVariable("city") String city) {
        JsonResult result = new JsonResult();
        List<PlaceInfo> list = placeServices.selectNearMovieList(city);
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

    @RequestMapping("placecomment/{id}")
    public JsonResult PlaceComment(@PathVariable("id") int placeid) {
        JsonResult result = new JsonResult();
        List<Comment> list = placeServices.PlaceComment(placeid);
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

    @RequestMapping("placepostcomment/{id}")
    public JsonResult PlacePostComment(@PathVariable("id") int placeid,
                                       @RequestParam("content") String content,
                                       @RequestParam("userId") int userId,
                                       @RequestParam("headImage") String headImage,
                                       @RequestParam("userName") String username) {
        JsonResult result = new JsonResult();
        boolean flag = placeServices.postComment(placeid, content, userId, headImage, username);
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

    //    获取首页轮播�?
    @RequestMapping("getSlide")
    public JsonResult getSlide() {
        JsonResult j = new JsonResult();
        List<PlaceInfo> list = placeServices.getSlide();
        j.setErrorcode("0");
        j.setStatus("1");
        j.setResults(list);
        return j;
    }

    //    获取热门地点列表
    @RequestMapping("getHotPlace")
    public JsonResult getHotPlace() {
        JsonResult j = new JsonResult();
        List<PlaceInfo> list = placeServices.getHotPlace();
        j.setErrorcode("0");
        j.setStatus("1");
        j.setResults(list);
        return j;
    }

    //    getHomePlaceList
    @RequestMapping("getHomePlaceList")
    public JsonResult getHomePlaceList() {
        JsonResult j = new JsonResult();
        List<PlaceInfo> list = placeServices.getHomePlaceList();
        j.setErrorcode("0");
        j.setStatus("1");
        j.setResults(list);
        return j;
    }

    //地点专题 �?
    @RequestMapping("placeZhuanTiSea")
    public JsonResult getPlaceZhuanTiSea(){
        JsonResult result = new JsonResult();
        List<PlaceInfo> list = placeServices.getPlaceZhuanTiSea();
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

    //地点专题 书店
    @RequestMapping("placeZhuanTiShuDian")
    public JsonResult getPlaceZhuanTiShuDian(){
        JsonResult result = new JsonResult();
        List<PlaceInfo> list = placeServices.getPlaceZhuanTiShuDian();
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

    //地点专题 静安
    @RequestMapping("placeZhuanTiJingAn")
    public JsonResult getPlaceZhuanTiJingAn(){
        JsonResult result = new JsonResult();
        List<PlaceInfo> list = placeServices.getPlaceZhuanTiJingAn();
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

    //地点专题 花园
    @RequestMapping("placeZhuanTiPark")
    public JsonResult getPlaceZhuanTiPark(){
        JsonResult result = new JsonResult();
        List<PlaceInfo> list = placeServices.getPlaceZhuanTiPark();
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

    //    获取个人地点关注列表
    @RequestMapping("getPlaceHobby")
    public JsonResult getPlaceHobby(@RequestParam("userId") Integer userId) {
        JsonResult j = new JsonResult();
        List<PlaceInfo> list = placeServices.getPlaceHobby(userId);
        j.setResults(list);
        j.setStatus("success");
        j.setErrorcode("0");
        return j;
    }

    @RequestMapping("searchPlace")
    public JsonResult searchPlace(@RequestParam("value") String value) {
        JsonResult j = new JsonResult();
        List<PlaceInfo> list = placeServices.searchPlace(value);
        j.setResults(list);
        j.setStatus("success");
        j.setErrorcode("0");
        return j;
    }

    //地点周边地点
    @RequestMapping("zhoubian/{location}")
    public JsonResult getZhouBian(@PathVariable("location") String location){
        JsonResult result = new JsonResult();
        List<PlaceInfo> list = placeServices.getZhouBian(location);
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

    //�ص�ľ�γ��
    @RequestMapping("placejingwei/{placeid}")
    public JsonResult getJingWei(@PathVariable("placeid") int placeid){
        JsonResult result = new JsonResult();
        List<PlaceInfo> list = placeServices.getJingWei(placeid);
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

