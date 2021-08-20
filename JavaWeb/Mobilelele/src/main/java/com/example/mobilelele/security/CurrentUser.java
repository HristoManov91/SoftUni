package com.example.mobilelele.security;

import com.example.mobilelele.model.entity.Role;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
public class CurrentUser {

    private static final String ANONYMOUS = "anonymous";

    private String name = ANONYMOUS;
    private Boolean isAnonymous = true;
    private List<Role> userRoles = new ArrayList<>();

    public String getName() {
        return name;
    }

    public CurrentUser setName(String name) {
        this.name = name;
        return this;
    }

    public Boolean getAnonymous() {
        return isAnonymous;
    }

    public boolean isAnonymous(){
        return isAnonymous;
    }

    public boolean isLoggedIn(){
        return !isAnonymous;
    }

    public CurrentUser setAnonymous(boolean anonymous){
        if(anonymous){
            this.name = ANONYMOUS;
            this.userRoles.clear();
        }
        isAnonymous = anonymous;
        return this;
    }

    public CurrentUser setUserRoles(List<Role> userRoles){
        userRoles.clear();;
        userRoles.addAll(userRoles);
        return this;
    }
}
