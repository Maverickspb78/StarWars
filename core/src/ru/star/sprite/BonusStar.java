package ru.star.sprite;


import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.star.base.Sprite;
import ru.star.math.Rect;


public class BonusStar extends Sprite {

    private final Vector2 v;
    private Rect worldBounds;


    public BonusStar() {
        this.v = new Vector2();
        regions = new TextureRegion[1];
    }

    public void set(
            TextureRegion region,
            Vector2 pos0,
            Vector2 v0,
            float height,
            Rect worldBounds
    ) {
        regions[0] = region;
        pos.set(pos0);
        v.set(v0);
        setHeightProportion(height);
        this.worldBounds = worldBounds;
    }

    @Override
    public void update(float delta) {
        pos.mulAdd(v, delta);
        if (isOutside(worldBounds)) {
            destroy();
        }
    }



}
