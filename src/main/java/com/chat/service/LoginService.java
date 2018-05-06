package com.chat.service;

import com.chat.pojo.Staff;

public interface LoginService {
	Staff getStaffByName(String name);

	Long getUidByName(String name);

	Staff getStaffById(long id);
}
