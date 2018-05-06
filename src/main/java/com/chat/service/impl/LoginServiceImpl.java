package com.chat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.chat.mapper.LoginMapper;
import com.chat.pojo.Staff;
import com.chat.service.LoginService;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 5)
@Service("loginService")
public class LoginServiceImpl implements LoginService {
	@Autowired
	LoginMapper loginMapper;

	public Staff getStaffByName(String name) {
		Staff staff = loginMapper.getStaffByName(name);
		return (staff != null) ? staff : null;
	}

	public Long getUidByName(String name) {
		Staff staff = loginMapper.getStaffByName(name);
		if(staff != null) {
			return (long)staff.getStaffId();
		} else {
			return null;
		}	
	}

	public Staff getStaffById(long id) {
		Staff staff = loginMapper.getStaffById(id);
		return (staff != null) ? staff : null;
	}

}
