package ru.star.sprite;



import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;


import ru.star.base.Sprite;
import ru.star.math.Rect;


public class MainShip extends Sprite {

    private static final float SCALE = 0.1f;
    private static final float INDENT = 0.03f;

    private final Vector2 con = new Vector2(0.3f,0);
    private final Vector2 velocity = new Vector2();


    public MainShip(TextureAtlas atlas) {
        super(atlas.findRegion("main_ship"), 1,2, 2);
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(SCALE);
        setBottom(worldBounds.getBottom() + INDENT);
    }

    @Override
    public void update(float delta) {
        pos.mulAdd(velocity, delta);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        return false;
    }

    public boolean keyDown(int keycode) {
        switch (keycode){
            case Input.Keys.A:
            case Input.Keys.LEFT:
                moveLeft();;
                break;
            case Input.Keys.D:
            case Input.Keys.RIGHT:
                moveRight();
                break;

        }
        return false;
    }


    public boolean keyUp(int keycode) {

        switch (keycode){
            case Input.Keys.A:
            case Input.Keys.LEFT:
            case Input.Keys.D:
            case Input.Keys.RIGHT:
                stop();
                break;

        }

        return false;
    }

    public  void moveRight(){
        velocity.set(con);
    }

    public  void moveLeft(){
        velocity.set(con).rotate(180);
    }

    public void stop(){
        velocity.setZero();
    }
}
