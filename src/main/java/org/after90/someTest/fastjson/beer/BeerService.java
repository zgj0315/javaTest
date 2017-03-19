package org.after90.someTest.fastjson.beer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by zhaogj on 19/03/2017.
 */
@Service
@Slf4j
public class BeerService {
    /**
     * 啤酒，2元钱一瓶
     * 4个瓶盖换一瓶
     * 2个空瓶换一瓶
     * 问：10元钱可以喝多少瓶
     */

    public void beerCount() {
        int nMoney = 10;
        Beer beer = new Beer();
        beer.setNBeer(nMoney / 2);
        beer.setNBottle(nMoney / 2);
        beer.setNCover(nMoney / 2);

        while (beer.doCount()) {
            log.info("继续喝");
        }
        log.info("啤酒个数:{}, 剩余盖子:{}, 剩余瓶子:{}", beer.getNBeer(), beer.getNCover(), beer.getNBottle());
    }

}
