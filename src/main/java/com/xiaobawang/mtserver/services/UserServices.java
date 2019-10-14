package com.xiaobawang.mtserver.services;

import com.xiaobawang.mtserver.dao.UserDao;
import com.xiaobawang.mtserver.pojo.User;
import com.xiaobawang.mtserver.pojo.UserHobby;
import com.xiaobawang.mtserver.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class UserServices{

	@Autowired
    UserDao userDao ;




	public int userEdit0(String id,String name, String pwd) {
		if(StringUtil.isEmpty(name) || StringUtil.isEmpty(pwd)) {
			return  -1 ;
		}
		return userDao.userEdit(id ,name , pwd) ;
	}

	public User selectUserByName(String name) {
		if (StringUtil.isEmpty(name)) {
			return null;
		} else {
			return userDao.selectUserByName(name);
		}
	}

	public int userCheck(String name, String phone) {
		if (StringUtil.isEmpty(name)) {
			return -1;
		} else if (userDao.selectUserByName(name) == null) {
			return 0;
		} else if (! (phone.equals(userDao.selectPhoneByName(name))) ) {
			return 2;
		} else {
			return 1;
		}
	}

	public int changePassword(String name, String password) {

		if(StringUtil.isEmpty(name) || StringUtil.isEmpty(password)) {
			return  -1 ;
		} else {
			return userDao.changeUserPassword(name, password);
		}

	}

	public User checkUserName (String userName) {
		User u = userDao.checkUserName(userName);
		return u;
	}

	public User checkNickName(String nickName) {
		User u = userDao.checkNickName(nickName);
		return u;
	}

	public int setNickName(Integer userId, String nickName) {
		int n = userDao.setNickName(userId, nickName);
		return n;
	}

	public User checkPhone(String phone) {
		User u = userDao.checkPhone(phone);
		return u;
	}

	public int register(User u) {
		int n = userDao.register(u.getUserName(), u.getPassword(), u.getPhone(), u.getNickName());
		return n;
	}

	public User login(User u) {
		User n = userDao.login(u.getUserName(), u.getPassword());
		return n;
	}

	public int setPwd(User u) {
		int n = userDao.setPwd(u.getUserName(), u.getPassword());
		return n;
	}

    public int setHeadImage(Integer userId, String headImage) {
		int n = userDao.setHeadImage(userId, headImage);
		return n;
    }

	public int setBirthday(Integer userId, Date birthday) {
		int n = userDao.setBirthday(userId, birthday);
		return n;
	}

	public int setGender(Integer userId, String gender) {
		int n = userDao.setGender(userId, gender);
		return n;
	}

    public int setLike(Integer userId, Integer objId, Integer tag) {
		return userDao.setLike(userId, objId, tag);
    }

	public int cancelLike(Integer userId, Integer objId, Integer tag) {
		return userDao.cancelLike(userId, objId, tag);
	}

	public UserHobby getUserLike(Integer userId, Integer objId, Integer tag) {
		return userDao.getUserLike(userId, objId, tag);
	}
}
