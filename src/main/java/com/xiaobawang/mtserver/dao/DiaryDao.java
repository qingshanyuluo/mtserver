package com.xiaobawang.mtserver.dao;

import com.xiaobawang.mtserver.pojo.Diary;
import com.xiaobawang.mtserver.pojo.DiaryComment;
import org.apache.ibatis.annotations.*;

import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DiaryDao {

    @Insert("INSERT INTO diaryinfo (content, userId, title) VALUES (#{content}, #{userId}, #{title})")
    int createDiary(String content, Integer userId, String title);

    @Select("SELECT * FROM diaryinfo where userId = #{userId} and open = 0")
    List<Diary> showPrivateDiary(Integer userId);

    @Select("SELECT * FROM diaryinfo where userId = #{userId} and open = 1")
    List<Diary> showPublicDiary(Integer userId);

    @Select("SELECT * FROM diaryinfo where diaryId = #{diaryId}")
    Diary getDiaryDetail(Integer diaryId);

    @Update("UPDATE diaryinfo SET open=1 WHERE diaryId=#{diaryId}")
    Integer publishDiary(Integer diaryId);

    @Delete("DELETE FROM diaryinfo WHERE diaryId=#{diaryId}")
    int deleteDiary(Integer diaryId);

    @Update("UPDATE diaryinfo SET open=0 WHERE diaryId=#{diaryId}")
    Integer withdrawDiary(Integer diaryId);

    @Select("SELECT * FROM diaryinfo where open = 1 and userId != #{userId} ORDER BY createDate")
    List<Diary> selectSquareDiary(Integer userId);

    @Update("UPDATE diaryinfo SET view=view+1 WHERE diaryId=#{diaryId}")
    int addView(Integer diaryId);

    @Select("SELECT * FROM diarycomment WHERE diaryId=#{diaryId} ORDER BY createDate DESC")
    List<DiaryComment> selectCommentList(Integer diaryId);

    @Insert("INSERT INTO diarycomment (diaryId, userId, content) VALUES (#{diaryId}, #{userId}, #{commentContent})")
    int publishComment(Integer diaryId, Integer userId, String commentContent);

    @Update("UPDATE diaryinfo SET likeNumber=likeNumber+1 WHERE diaryId=#{diaryId}")
    int addLikeNumber(Integer diaryId);

    @Update("UPDATE diaryinfo SET likeNumber=likeNumber-1 WHERE diaryId=#{diaryId}")
    int minusLikeNumber(Integer diaryId);

    @Update("UPDATE diaryinfo SET commentCount=commentCount+1 WHERE diaryId=#{diaryId}")
    void addCommentCount(Integer diaryId);

    @Update("UPDATE diaryinfo SET title = #{title}, content = #{content} WHERE diaryId=#{diaryId}")
    Integer editDiary(String title, String content, String diaryId);
}
