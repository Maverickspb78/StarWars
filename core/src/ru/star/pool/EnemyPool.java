package ru.star.pool;

import com.badlogic.gdx.audio.Sound;

import ru.star.base.SpritesPool;
import ru.star.math.Rect;
import ru.star.sprite.EnemyShip;

public class EnemyPool extends SpritesPool<EnemyShip> {


    private BulletPool bulletPool;
    private ExplosionPool explosionPool;
    private Rect worldBounds;
    private Sound sound;

    public EnemyPool(BulletPool bulletPool, ExplosionPool explosionPool, Rect worldBounds, Sound sound) {
        this.bulletPool = bulletPool;
        this.explosionPool = explosionPool;
        this.worldBounds = worldBounds;
        this.sound = sound;

    }

    @Override
    protected EnemyShip newObject() {
        return new EnemyShip(bulletPool, explosionPool, worldBounds, sound);
    }
}