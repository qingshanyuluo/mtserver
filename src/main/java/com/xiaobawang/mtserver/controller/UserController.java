package com.xiaobawang.mtserver.controller;

import com.xiaobawang.mtserver.pojo.JsonResult;
import com.xiaobawang.mtserver.pojo.User;
import com.xiaobawang.mtserver.pojo.UserHobby;
import com.xiaobawang.mtserver.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServices userServices;

    @RequestMapping("login")
    @ResponseBody
    public JsonResult login(User u) {
        JsonResult j = new JsonResult();
        User U = userServices.login(u);
        if (U != null) {
            j.setErrorcode("0");
            j.setStatus("0");
            j.setResults(U);
        } else {
            j.setStatus("-1");
            j.setErrorcode("1");
            j.setResults(null);
        }
        return j;
    }

    @RequestMapping("register")
    @ResponseBody
    public JsonResult register(User u) {
        JsonResult j = new JsonResult();
        int i = userServices.register(u);
        if (i == 1) {
            j.setErrorcode("0");
            j.setStatus("0");
            j.setResults(null);
        } else {
            j.setStatus("-1");
            j.setErrorcode("1");
            j.setResults(null);
        }
        return j;
    }

    @RequestMapping("checkUserName")
    @ResponseBody
    public JsonResult checkUserName(@RequestParam("userName") String userName) {
        JsonResult j = new JsonResult();
        User u = userServices.checkUserName(userName);
        if (u != null) {
            j.setStatus("user existed");
            j.setErrorcode("0");
            j.setResults(u);
        } else {
            j.setStatus("user not existed");
            j.setErrorcode("0");
            j.setResults(null);
        }
        return j;
    }

    @RequestMapping("setNickName")
    @ResponseBody
    public JsonResult setNickName(
            @RequestParam("userId") Integer userId,
            @RequestParam("nickName") String nickName) {
        JsonResult j = new JsonResult();
        int n = userServices.setNickName(userId, nickName);
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

    @RequestMapping("checkNickName")
    @ResponseBody
    public JsonResult checkNickName(@RequestParam("nickName") String nickName) {
        JsonResult j = new JsonResult();
        User u = userServices.checkNickName(nickName);
        if (u != null) {
            j.setStatus("nickName existed");
            j.setErrorcode("0");
            j.setResults(u);
        } else {
            j.setStatus("nickName not existed");
            j.setErrorcode("0");
            j.setResults(null);
        }
        return j;
    }

    @RequestMapping("checkPhone")
    @ResponseBody
    public JsonResult checkPhone(@RequestParam("phone") String phone) {
        JsonResult j = new JsonResult();
        User u = userServices.checkPhone(phone);
        if (u != null) {
            j.setStatus("phone existed");
            j.setErrorcode("0");
            j.setResults(u);
        } else {
            j.setStatus("phone not existed");
            j.setErrorcode("0");
            j.setResults(null);
        }
        return j;
    }

    @RequestMapping("setPwd")
    @ResponseBody
    public JsonResult setPwd(User u) {
        JsonResult j = new JsonResult();
        int n = userServices.setPwd(u);
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

    @RequestMapping("setHeadImage")
    @ResponseBody
    public JsonResult setHeadImage(
            @RequestParam("userId") Integer userId,
            @RequestParam("headImage") String headImage
    ){
        JsonResult j = new JsonResult();
        int n = userServices.setHeadImage(userId, headImage);
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

    @RequestMapping("setBirthday")
    @ResponseBody
    public JsonResult setBirthday(
            @RequestParam("userId") Integer userId,
            @RequestParam("birthday") String birthday
    ) throws ParseException {
        JsonResult j = new JsonResult();
        SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd" );
        Date date = sdf.parse(birthday);
        int n = userServices.setBirthday(userId, date);
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

    @RequestMapping("setGender")
    @ResponseBody
    public JsonResult setGender(
            @RequestParam("userId") Integer userId,
            @RequestParam("gender") String gender
    ) {
        JsonResult j = new JsonResult();
        int n = userServices.setGender(userId, gender);
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

    @RequestMapping("setLike")
    @ResponseBody
    public JsonResult setLike(
            @RequestParam("userId") Integer userId,
            @RequestParam("objId") Integer objId,
            @RequestParam("tag") Integer tag
    ) {
        JsonResult j = new JsonResult();
        int n = userServices.setLike(userId, objId, tag);
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

    @RequestMapping("cancelLike")
    @ResponseBody
    public JsonResult cancelLike(
            @RequestParam("userId") Integer userId,
            @RequestParam("objId") Integer objId,
            @RequestParam("tag") Integer tag
    ) {
        JsonResult j = new JsonResult();
        int n = userServices.cancelLike(userId, objId, tag);
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

    @RequestMapping("getUserLike")
    @ResponseBody
    public JsonResult getUserLike(
            @RequestParam("userId") Integer userId,
            @RequestParam("objId") Integer objId,
            @RequestParam("tag") Integer tag
    ) {
        JsonResult j = new JsonResult();
        UserHobby n = userServices.getUserLike(userId, objId, tag);
        j.setStatus("success");
        j.setErrorcode("0");
        j.setResults(n);
        return j;
    }

}
