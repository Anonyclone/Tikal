package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.Joueur;
import com.mygdx.game.Tikal;
import com.mygdx.game.GameState;
import com.mygdx.game.Tresor;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = Tikal.WIDTH;
        config.height = Tikal.HEIGHT;
        config.title = Tikal.TITLE;
		new LwjglApplication(new Tikal(), config);

	}
}
