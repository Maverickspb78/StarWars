package ru.star.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.star.base.BaseButton;
import ru.star.math.Rect;
import ru.star.screen.GameScreen;

public class NewGame extends BaseButton {

    private static final float HEIGHT = 0.06f;

    private GameScreen gameScreen;

    public NewGame(TextureAtlas atlas, GameScreen gameScreen) {
        super(atlas.findRegion("button_new_game"));
        this.gameScreen = gameScreen;
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(HEIGHT);
    }

    @Override
    public void action() {
        gameScreen.startNewGame();
    }
}