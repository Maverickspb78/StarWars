package ru.star.pool;

import ru.star.base.SpritesPool;
import ru.star.sprite.BonusStar;


public class BonusStarPool extends SpritesPool<BonusStar> {

    @Override
    protected BonusStar newObject() {
        return new BonusStar();
    }



}
