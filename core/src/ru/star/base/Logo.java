package ru.star.base;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;


public class Logo {

    private static final float V_LEN = 0.01f;

    private Vector2 touch = new Vector2();
    private Vector2 pos = new Vector2();
    private Vector2 velositi = new Vector2();
    private Vector2 tmp = new Vector2();


    public Logo() {

    }

    public Vector2 play() {
        tmp.set(touch);
        if (tmp.sub(pos).len() > velositi.len()) {
            return pos.add(velositi);
        }
        return pos.set(touch);
    }


    public Vector2 getTouch() {
        return touch;
    }

    public void setTouch(Vector2 touch) {
        this.touch = touch;
        velositi.set(touch.cpy().sub(pos)).setLength(0.01f);
    }

    public Vector2 getPos() {
        return pos;
    }

    public void setPos(Vector2 pos) {
        this.pos = pos;
    }


}
