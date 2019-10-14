package com.xiaobawang.mtserver.dao;
import com.xiaobawang.mtserver.pojo.User;
import com.xiaobawang.mtserver.pojo.UserHobby;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Mapper
@Repository
public interface UserDao {

	@Update("UPDATE users SET uname=#{name},upwd=#{pwd} WHERE uid=#{id}")
	int userEdit(String id, String name, String pwd);

	@Insert("INSERT INTO users VALUES (UUID(),#{name},#{pwd},#{email},#{phone},NOW())")
	int userRegister(String name, String pwd, String email, String phone);

	@Select("select * from users where uname=#{name} and upwd=#{pwd}")
	User userLogin(String name, String pwd);

	@Select("select * from users where uname=#{name}")
	User selectUserByName(String name);

	@Select("select uphone from users where uname=#{name}")
	String selectPhoneByName(String name);

	@Update("UPDATE users SET upwd=#{password} WHERE uname=#{name}")
	int changeUserPassword(String name, String password);

	@Select("SELECT * FROM userinfo where userName = #{userName}")
	User checkUserName(String userName);

	@Update("UPDATE userinfo SET nickName=#{nickName} WHERE userId=#{userId}")
	int setNickName(Integer userId, String nickName);

	@Select("SELECT * FROM userinfo where nickName = #{nickName}")
	User checkNickName(String nickName);

	@Select("SELECT * FROM userinfo where phone = #{phone}")
	User checkPhone(String phone);

	@Insert("INSERT INTO userinfo(userName,password,phone,nickName) VALUES (#{userName},#{password},#{phone},#{nickName})")
	int register(String userName, String password, String phone, String nickName);

	@Select("SELECT * FROM userinfo where userName = #{userName} and password = #{password}")
	User login(String userName, String password);

	@Update("UPDATE userinfo SET password=#{password} WHERE userName=#{userName}")
	int setPwd(String userName, String password);

	@Update("UPDATE userinfo SET headImage=#{headImage} WHERE userId=#{userId}")
    int setHeadImage(Integer userId, String headImage);

	@Update("UPDATE userinfo SET birthday=#{birthday} WHERE userId=#{userId}")
	int setBirthday(Integer userId, Date birthday);

	@Update("UPDATE userinfo SET gender=#{gender} WHERE userId=#{userId}")
	int setGender(Integer userId, String gender);

	@Select("select * from userinfo where userId=#{userId}")
    User selectUserById(Integer userId);

	@Insert("INSERT INTO userhobby(userId,objId,tag) VALUES (#{userId},#{objId},#{tag})")
    int setLike(Integer userId, Integer objId, Integer tag);

	@Delete("delete from userhobby where userId = #{userId} and objId = #{objId} and tag = #{tag}")
	int cancelLike(Integer userId, Integer objId, Integer tag);

	@Select("select * from userhobby where userId = #{userId} and objId = #{objId} and tag = #{tag}")
	UserHobby getUserLike(Integer userId, Integer objId, Integer tag);
}
