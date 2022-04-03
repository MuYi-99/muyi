package com.muyi.user.domain.model.user;

import lombok.Getter;
import lombok.Setter;
/**
 * @author yangx
 * @date 2022/3/25 11:10
 */
@Getter
@Setter
public class User {

    private String id;

    private String username;

    private String password;

    public User() {

    }

    public User(String username){
        this.setUsername(username);
    }

}
