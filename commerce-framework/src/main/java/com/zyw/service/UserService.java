package com.zyw.service;

import com.zyw.entity.UserAddress;

import java.util.List;

public interface UserService {

    public List<UserAddress> getUserAddressList(String userId);
}

