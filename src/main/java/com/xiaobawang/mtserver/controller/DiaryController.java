package com.xiaobawang.mtserver.controller;

import com.xiaobawang.mtserver.pojo.*;
import com.xiaobawang.mtserver.services.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DiaryController {
    @Autowired
    DiaryService diaryService;

    @RequestMapping("/writeDiary")
    public JsonResult createDiary(
            @RequestParam("content") String content,
            @RequestParam("userId") Integer userId,
            @RequestParam("title") String  title
    ) {
        JsonResult j = new JsonResult();
        int n = diaryService.createDiary(content, userId, title);
        if (n == 1) {
            j.setErrorcode("0");
            j.setStatus("success");
            j.setResults(null);
        } else {
            j.setStatus("-1");
            j.setErrorcode("fail");
            j.setResults(null);
        }
        return j;
    }

//    获取私密日记列表
    @RequestMapping("/getDiary/privateDiary/{userId}")
    public JsonResult showPrivateDiary(@PathVariable("userId") Integer userId) {
        JsonResult j = new JsonResult();
        List<Diary> diaryList = diaryService.showPrivateDiary(userId);
        j.setStatus("success");
        j.setErrorcode("0");
        j.setResults(diaryList);
        return j;
    }

//    获取公开日记列表
    @RequestMapping("/getDiary/publicDiary/{userId}")
    public JsonResult showPublicDiary(@PathVariable("userId") Integer userId) {
        JsonResult j = new JsonResult();
        List<Diary> diaryList = diaryService.showPublicDiary(userId);
        j.setStatus("success");
        j.setErrorcode("0");
        j.setResults(diaryList);
        return j;
    }

//   获取日记详情内容
    @RequestMapping("/getDiary/diaryDetail/{diaryId}")
    public JsonResult getDiaryDetail(@PathVariable("diaryId") Integer diaryId) {
        JsonResult j = new JsonResult();
        Diary diary = diaryService.getDiaryDetail(diaryId);
        j.setStatus("success");
        j.setErrorcode("0");
        j.setResults(diary);
        return j;
    }

//    编辑日记
    @RequestMapping("/editDiary")
    public JsonResult editDiary(
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam("diaryId") String diaryId) {
        JsonResult j = new JsonResult();
        Integer n = diaryService.editDiary(title, content, diaryId);
        if (n == 1) {
            j.setStatus("success");
            j.setErrorcode("0");
            j.setResults(null);
        } else {
            j.setStatus("fail");
            j.setErrorcode("1");
            j.setResults(null);
        }
        return j;
    }

//    设置日记为公开日记
    @RequestMapping("/publishDiary/{diaryId}")
    public JsonResult publishDiary (@PathVariable("diaryId") Integer diaryId) {
        JsonResult j = new JsonResult();
        Integer i = diaryService.publishDiary(diaryId);
        if (i == 1) {
            j.setStatus("success");
            j.setErrorcode("0");
            j.setResults(null);
        } else {
            j.setStatus("fail");
            j.setErrorcode("1");
            j.setResults(null);
        }
        return j;
    }

//    删除日记
    @RequestMapping("deleteDiary/{diaryId}")
    public JsonResult deleteDiary (@PathVariable("diaryId") Integer diaryId) {
        JsonResult j = new JsonResult();
        int i = diaryService.deleteDiary(diaryId);
        if (i == 1) {
            j.setStatus("success");
            j.setErrorcode("0");
            j.setResults(null);
        } else {
            j.setStatus("fail");
            j.setErrorcode("1");
            j.setResults(null);
        }
        return j;
    }

//    取消公开日记
    @RequestMapping("/withdrawDiary/{diaryId}")
    public JsonResult withdrawDiary (@PathVariable("diaryId") Integer diaryId) {
        JsonResult j = new JsonResult();
        Integer i = diaryService.withdrawDiary(diaryId);
        if (i == 1) {
            j.setStatus("success");
            j.setErrorcode("0");
            j.setResults(null);
        } else {
            j.setStatus("fail");
            j.setErrorcode("1");
            j.setResults(null);
        }
        return j;
    }

//    获取广场日记
    @RequestMapping("/getDiary/squareDiary")
    public JsonResult squareDiary (@RequestParam("userId") Integer userId) {
        JsonResult j = new JsonResult();
        List<SquareDiary> squareDiaryList  = diaryService.showSquareDiary(userId);
        j.setStatus("1");
        j.setErrorcode("0");
        j.setResults(squareDiaryList);
        return j;
    }

//    浏览量加一
    @RequestMapping("/addView")
    public JsonResult addView (@RequestParam("diaryId") Integer diaryId) {
        JsonResult j = new JsonResult();
        int n = diaryService.addView(diaryId);
        if (n == 1) {
            j.setStatus("1");
            j.setErrorcode("0");
            j.setResults(null);
        } else {
            j.setStatus("-1");
            j.setErrorcode("1");
            j.setResults(null);
        }
        return j;
    }

//    喜欢数量加一
    @RequestMapping("/addLikeNumber")
    public JsonResult addLikeNumber (@RequestParam("diaryId") Integer diaryId) {
        JsonResult j = new JsonResult();
        int n = diaryService.addLikeNumber(diaryId);
        if (n == 1) {
            j.setStatus("1");
            j.setErrorcode("0");
            j.setResults(null);
        } else {
            j.setStatus("-1");
            j.setErrorcode("1");
            j.setResults(null);
        }
        return j;
    }

//    喜欢数量减一
    @RequestMapping("/minusLikeNumber")
    public JsonResult minusLikeNumber (@RequestParam("diaryId") Integer diaryId) {
        JsonResult j = new JsonResult();
        int n = diaryService.minusLikeNumber(diaryId);
        if (n == 1) {
            j.setStatus("1");
            j.setErrorcode("0");
            j.setResults(null);
        } else {
            j.setStatus("-1");
            j.setErrorcode("1");
            j.setResults(null);
        }
        return j;
    }

//    获取每一篇日记的评论
    @RequestMapping("/getCommentList")
    public JsonResult getCommentList (@RequestParam("diaryId") Integer diaryId) {
        JsonResult j = new JsonResult();
        List<DiaryCommentObj> commentList = diaryService.getCommentList(diaryId);
        j.setStatus("1");
        j.setErrorcode("0");
        j.setResults(commentList);
        return j;
    }

//    发表一篇日记的评论
    @RequestMapping("/publishComment")
    public JsonResult publishComment (
            @RequestParam("diaryId") Integer diaryId,
            @RequestParam("userId") Integer userId,
            @RequestParam("commentContent") String commentContent
            ){
        JsonResult j = new JsonResult();
        int n = diaryService.publishComment(diaryId, userId, commentContent);
        if (n == 1) {
            j.setStatus("1");
            j.setErrorcode("0");
            j.setResults(null);
            diaryService.addCommentCount(diaryId);
        } else {
            j.setStatus("-1");
            j.setErrorcode("1");
            j.setResults(null);
        }
        return j;
    }
}
