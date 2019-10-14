package com.xiaobawang.mtserver.dao;

import com.xiaobawang.mtserver.pojo.Comment;
import com.xiaobawang.mtserver.pojo.PlaceInfo;
import com.xiaobawang.mtserver.pojo.UserHobby;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PlaceInfoDao {
    @Select("select * from placeInfo where placeid=#{placeid}")
    PlaceInfo selectPlaceInfoById(@Param("placeid") int placeid);

    @Select("select placeid,placeimage from placeInfo Limit 5")
    List<PlaceInfo> selectPlaceLunBo();


    @Select("select placeimage,placeid,placename,placelocation from placeInfo LIMIT 4")
    List<PlaceInfo> selectPlaceImageByHotTop5();
    
    @Select("select * from placeInfo WHERE placename like '%${type}%' or placelocation like '%${type}%' limit #{begin}, #{limit}")
    List<PlaceInfo> selectPlaceList(String type, Integer begin, Integer limit);


    @Select("select * from placeInfo where placelocation like '%${city}%' or placename like '%${city}%'")
    List<PlaceInfo> selectNearPlaceList(String city);

    @Insert("INSERT INTO mpcomment (userid,username,headimage,comment,placeid) VALUES (#{userId},#{username},#{headimage},#{content},#{placeid})")
    int postComment(int placeid, String content, int userId, String headimage, String username);

    @Select("select * from mpcomment where placeid = #{placeid} ORDER BY puttime desc")
    List<Comment> PlaceComments(int placeid);

    @Select("SELECT * FROM placeInfo WHERE LENGTH(content) > 700 and placename not LIKE '%大观园%' ORDER BY placetype limit 5")
    List<PlaceInfo> getSlide();

    @Select("SELECT * FROM placeInfo WHERE placename LIKE '%景区%' limit 20")
    List<PlaceInfo> getHotPlace();

    @Select("SELECT * FROM placeInfo WHERE LENGTH(content) > 1000 ORDER BY placetype limit 4")
    List<PlaceInfo> getHomePlaceList();

    @Select("SELECT * FROM userhobby WHERE userId = #{userId} and tag = 1")
    List<UserHobby> getHobbyList(Integer userId);

    @Select("SELECT * FROM placeInfo WHERE placeid = #{objId}")
    PlaceInfo getPlaceById(Integer objId);

    @Select("SELECT * FROM placeInfo WHERE placename like '%${value}%' or placelocation like '%${value}%'")
    List<PlaceInfo> searchPlace(String value);
    @Select("SELECT COUNT(1) FROM placeInfo WHERE placename like '%${value}%' or placelocation like '%${value}%'")
    int getListLength(String value);    @Select("select * from placeInfo where placename like '%海滩%' limit 10")
    List<PlaceInfo> getPlaceZhuanTiSea();

  
    @Select("select * from placeInfo where placename like '%书店%' limit 10")
    List<PlaceInfo> getPlaceZhuanTiShuDian();


    @Select("select * from placeInfo where placelocation like '%静安%' limit 10")
    List<PlaceInfo> getPlaceZhuanTiJingAn();


    @Select("select * from placeInfo where placename like '%花园%' limit 10")
    List<PlaceInfo> getPlaceZhuanTiPark();

    @Select("select * from placeInfo where placelocation like '%${location}%' or placename like '%${location}%' limit 5")
   
    List<PlaceInfo> getZhouBian(String location);

    @Select("select lat,lng from place where placeId = #{placeid}")
    List<PlaceInfo> getJingWei(int placeid);
}

