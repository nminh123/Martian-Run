package com.nminh123.martianrun;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MartianRun extends Game {
	@Override
	public void create() {
		setScreen(new GameScreen());
	}
}
