package com.xiaobawang.mtserver.services;

import com.xiaobawang.mtserver.dao.DiaryDao;
import com.xiaobawang.mtserver.dao.UserDao;
import com.xiaobawang.mtserver.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DiaryService {
    @Autowired
    DiaryDao diaryDao ;
    @Autowired
    UserDao userDao;

    public int createDiary(String content, Integer userId, String title) {
        int n = diaryDao.createDiary(content, userId, title);
        return n;
    }

    public List<Diary> showPrivateDiary(Integer userId) {
        List<Diary> diaryList = diaryDao.showPrivateDiary(userId);
        return diaryList;
    }

    public List<Diary> showPublicDiary(Integer userId) {
        List<Diary> diaryList = diaryDao.showPublicDiary(userId);
        return diaryList;
    }

    public Diary getDiaryDetail(Integer diaryId) {
        Diary diary = diaryDao.getDiaryDetail(diaryId);
        return diary;
    }

    public Integer publishDiary(Integer diaryId) {
        Integer i = diaryDao.publishDiary(diaryId);
        return i;
    }

    public int deleteDiary(Integer diaryId) {
        return diaryDao.deleteDiary(diaryId);
    }

    public Integer withdrawDiary(Integer diaryId) {
        Integer i = diaryDao.withdrawDiary(diaryId);
        return i;
    }

    public List<SquareDiary> showSquareDiary(Integer userId) {
        List<SquareDiary> squareDiaryList = new ArrayList<>();
        List<Diary> diaryList = diaryDao.selectSquareDiary(userId);
        for (Diary diary : diaryList) {
            SquareDiary squareDiary = new SquareDiary();
            User u = userDao.selectUserById(diary.getUserId());
            squareDiary.setUserId(u.getUserId());
            squareDiary.setNickName(u.getNickName());
            squareDiary.setHeadImage(u.getHeadImage());
            squareDiary.setDiaryId(diary.getDiaryId());
            squareDiary.setTitle(diary.getTitle());
            squareDiary.setCommentCount(diary.getCommentCount());
            squareDiary.setCreateDate(diary.getCreateDate());
            squareDiary.setLikeNumber(diary.getLikeNumber());
            squareDiary.setView(diary.getView());
            squareDiaryList.add(squareDiary);
        }
        return squareDiaryList;
    }

    public int addView(Integer diaryId) {
        int n = diaryDao.addView(diaryId);
        return n;
    }

    public List<DiaryCommentObj> getCommentList(Integer diaryId) {
        List<DiaryCommentObj> diaryCommentObjList = new ArrayList<>();
        List<DiaryComment> diaryCommentList = diaryDao.selectCommentList(diaryId);
        for (DiaryComment comment : diaryCommentList) {
            DiaryCommentObj diaryCommentObj = new DiaryCommentObj();
            User u = userDao.selectUserById(comment.getUserId());
            diaryCommentObj.setNickName(u.getNickName());
            diaryCommentObj.setHeadImage(u.getHeadImage());
            diaryCommentObj.setContent(comment.getContent());
            diaryCommentObj.setCreateDate(comment.getCreateDate());
            diaryCommentObj.setCommentId(comment.getCommentId());
            diaryCommentObjList.add(diaryCommentObj);
        }
        return diaryCommentObjList;
    }

    public int publishComment(Integer diaryId, Integer userId, String commentContent) {
        int n = diaryDao.publishComment(diaryId, userId, commentContent);
        return n;
    }

    public int addLikeNumber(Integer diaryId) {
        int n = diaryDao.addLikeNumber(diaryId);
        return n;
    }

    public int minusLikeNumber(Integer diaryId) {
        int n = diaryDao.minusLikeNumber(diaryId);
        return n;
    }

    public void addCommentCount(Integer diaryId) {
        diaryDao.addCommentCount(diaryId);
    }

    public Integer editDiary(String title, String content, String diaryId) {
        return diaryDao.editDiary(title, content, diaryId);
    }
}

