package com.jary.progress.service.impl;

import com.jary.progress.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author fanzhengjie
 * @date 2020/5/26 3:49 下午
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public void save() {
        System.out.println("保存用户!");
        //throw new RuntimeException();
    }

    @Override
    public void delete() {
        System.out.println("删除用户!");
    }

    @Override
    public void update() {
        System.out.println("更新用户!");
    }

    @Override
    public void find() {
        System.out.println("查找用户!");
    }
}
