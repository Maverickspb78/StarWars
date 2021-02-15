package ru.star;

import com.badlogic.gdx.Game;

import ru.star.screen.MenuScreen;

public class StarWars extends Game {

	
	@Override
	public void create () {
		setScreen(new MenuScreen(this));

	}

}
