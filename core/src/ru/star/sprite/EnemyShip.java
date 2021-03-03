package ru.star.sprite;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.star.base.Ship;
import ru.star.math.Rect;
import ru.star.pool.BonusStarPool;
import ru.star.pool.BulletPool;
import ru.star.pool.ExplosionPool;


public class EnemyShip extends Ship {

    private static final float START_V_Y = -0.3f;
    private boolean gainsbool = false;
    private BonusStarPool bonusStarPool = new BonusStarPool();
    private BonusStar bonusStar = new BonusStar();


    public EnemyShip(BulletPool bulletPool, ExplosionPool explosionPool, Rect worldBounds, Sound sound) {
        this.bulletPool = bulletPool;
        this.explosionPool = explosionPool;
        this.worldBounds = worldBounds;
        this.sound = sound;

        v = new Vector2();
        v0 = new Vector2();
        bulletPos = new Vector2();
        bulletV = new Vector2();
    }

    @Override
    public void update(float delta) {
        if (getTop() > worldBounds.getTop()) {
            reloadTimer = reloadInterval * 0.8f;
        } else if (!v.equals(v0)) {
            v.set(v0);
        }
        super.update(delta);
        bulletPos.set(pos.x, pos.y - getHalfHeight());
        if (getBottom() < worldBounds.getBottom()) {
            destroy();
        }
    }

    public void set(
            TextureRegion[] regions,
            Vector2 v0,
            TextureRegion bulletRegion,
            float bulletHeight,
            Vector2 bulletV,
            int damage,
            float reloadInterval,
            float height,
            int hp
    ) {
        this.regions = regions;
        this.v0.set(v0);
        this.bulletRegion = bulletRegion;
        this.bulletHeight = bulletHeight;
        this.bulletV.set(bulletV);
        this.damage = damage;
        this.reloadInterval = reloadInterval;
        setHeightProportion(height);
        this.hp = hp;
        v.set(0, START_V_Y);
    }

    public boolean isBulletCollision(Rect bullet) {
        return !(bullet.getRight() < getLeft()
                || bullet.getLeft() > getRight()
                || bullet.getBottom() > getTop()
                || bullet.getTop() < pos.y
        );
    }

    public boolean ifGifGains(){
        float gainsRandom = (float) Math.random();
        if (gainsRandom > 0f){
            gainsbool = true;
        }
        return gainsbool;
    }

    @Override
    public void destroy() {
        super.destroy();

    }

    public void bonus(){
        if (gainsbool){
            bonusStarPool.obtain();
        }
    }


}