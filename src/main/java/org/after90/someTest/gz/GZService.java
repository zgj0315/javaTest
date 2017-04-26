package org.after90.someTest.gz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Created by zhaogj on 26/04/2017.
 */
@Service
@Slf4j
public class GZService {
    public void writeFile() {
        String strFile = "./data/123.gz";
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new GZIPOutputStream(new FileOutputStream(new File(strFile)))));
            bw.write("hello world");
            bw.newLine();
            bw.write("fdsafdsa");
            bw.flush();
        } catch (Exception e) {
            log.error("", e);
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (Exception e) {
                    log.error("", e);
                }
            }
        }
    }

    public void readFile() {
        String strFile = "./data/123.gz";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(new File(strFile)))));
            String strLine = null;
            while ((strLine = br.readLine()) != null) {
                log.info("strLine:{}", strLine);
            }
        } catch (Exception e) {
            log.error("", e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    log.error("", e);
                }
            }
        }
    }
}
