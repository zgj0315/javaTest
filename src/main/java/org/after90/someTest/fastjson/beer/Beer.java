package org.after90.someTest.fastjson.beer;

import lombok.Data;

/**
 * Created by zhaogj on 19/03/2017.
 */
@Data
public class Beer {
    private int nBeer = 0;
    private int nBottle = 0;
    private int nCover = 0;

    public boolean doCount() {
        int nBeerAdd = nBottle / 2;
        nBeerAdd += nCover / 4;
        nBeer += nBeerAdd;
        nBottle = nBottle % 2;
        nBottle += nBeerAdd;
        nCover = nCover % 4;
        nCover += nBeerAdd;
        if (nCover < 4 && nBottle < 2) {
            return false;
        } else {
            return true;
        }
    }
}
