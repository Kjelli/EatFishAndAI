package game;

import input.GlobalInput;
import screens.MenuScreen;
import screens.PlayScreen;
import assets.Assets;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EatFishAndAI extends Game {

	public static final int WIDTH = 640, HEIGHT = 480;

	@Override
	public void create() {
		Assets.loadAllAssets();
		GlobalInput.init();
		Gdx.input.setInputProcessor(GlobalInput.getInputMultiplexer());
		setScreen(new MenuScreen(this));
	}

	@Override
	public void setScreen(Screen screen) {
		Screen oldScreen = getScreen();
		if (oldScreen != null) {
			oldScreen.dispose();
		}
		super.setScreen(screen);
	}

	@Override
	public void dispose() {
		super.dispose();
	}

}
