package org.after90.someTest.list;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhaogj on 16/06/2017.
 */
@Service
@Slf4j
public class ListService {
    private List<String> listA = new LinkedList<String>();

    public void doTest() {
        String strTmp = "A";
        listA.add(strTmp);
        strTmp = "B";
        listA.add(strTmp);
        strTmp = "C";
        for (String str : listA) {
            log.info("str:{}", str);
        }
    }
}
