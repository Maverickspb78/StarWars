package ru.star.screen;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.star.base.BaseScreen;
import ru.star.base.Logo;
import ru.star.math.Rect;
import ru.star.sprite.Background;

public class MenuScreen extends BaseScreen {

    private Texture bg;
    private Background background;
    private Texture tx;
    private Logo logo;

    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/bg.png");
        background = new Background(bg);
        tx = new Texture("badlogic.jpg");
        logo = new Logo();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.3f, 0.6f, 0.4f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        batch.draw(tx, logo.getPos().x, logo.getPos().y, 0.1f, 0.1f);
        batch.end();
        logo.setPos(logo.play());

    }

    @Override
    public void dispose() {
        bg.dispose();
        tx.dispose();
        super.dispose();

    }

    @Override
    public void resize(Rect worldBounds) {
        background.resize(worldBounds);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        logo.setTouch(touch);
        return super.touchDown(touch, pointer, button);
    }
}

