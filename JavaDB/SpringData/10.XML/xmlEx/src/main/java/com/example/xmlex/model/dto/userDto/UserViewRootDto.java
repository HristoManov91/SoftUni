package com.example.xmlex.model.dto.userDto;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserViewRootDto {

    @XmlElement(name = "user")
    List<UserWithSoldProducts> users;

    public List<UserWithSoldProducts> getUsers() {
        return users;
    }

    public void setUsers(List<UserWithSoldProducts> users) {
        this.users = users;
    }
}
