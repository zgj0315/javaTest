package org.after90.someTest.fastjson;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaogj on 19/03/2017.
 */
@Data
public class Group {
    private int nId;
    private String strName;
    private List<User> listUser;

    public void addUser(User user) {
        if (listUser == null) {
            listUser = new ArrayList<User>();
        }
        listUser.add(user);
    }
}
