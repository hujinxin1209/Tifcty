package com.chat.mapper;

import com.chat.pojo.Staff;

public interface LoginMapper {
	Staff getStaffByName(String name);
	Staff getStaffById(long id);
}
