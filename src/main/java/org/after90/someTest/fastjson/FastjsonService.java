package org.after90.someTest.fastjson;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by zhaogj on 19/03/2017.
 */
@Service
@Slf4j
public class FastjsonService {
    public void json2string() {
        Group group = new Group();
        group.setNId(0);
        group.setStrName("admin");

        User guestUser = new User();
        guestUser.setNId(2);
        guestUser.setStrName("guest");

        User rootUser = new User();
        rootUser.setNId(3);
        rootUser.setStrName("root");

        group.addUser(guestUser);
        group.addUser(rootUser);

        String jsonString = JSON.toJSONString(group);

        log.info(jsonString);
    }
}
