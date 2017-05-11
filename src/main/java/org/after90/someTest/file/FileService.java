package org.after90.someTest.file;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * Created by zhaogj on 02/05/2017.
 */
@Service
@Slf4j
public class FileService {
    public void readFileList() {
        File fileIndexPath = new File("/Users/zhaogj/tmp/");
        if (fileIndexPath.exists() && fileIndexPath.isDirectory()) {
            String[] aIndex = fileIndexPath.list();
            for (String strIndex : aIndex) {
                log.info("strIndex:{}", strIndex);
            }
        }
    }
}
