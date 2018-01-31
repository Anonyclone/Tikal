package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MenuState extends State{
	private Stage stage;
	private SpriteBatch batch;
	private Texture background;
	private OrthographicCamera camera;

	public MenuState(final GameStateManager gsm){
		super(gsm);
		background = new Texture("fondLogoTikal-iloveimg-resized.jpg");
		camera = new OrthographicCamera();
		batch = new SpriteBatch();
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		mouse = new Vector3();
		
		batch.setProjectionMatrix(camera.combined);
		Skin skin = new Skin(Gdx.files.internal("ui/defaultskin.json"));
		
		TextButton button = new TextButton("JOUER", skin);
		button.setBounds(300, 175, 200, 55);
		stage.addActor(button);
		  button.addListener(new ClickListener(){
		       @Override
		       public void clicked(InputEvent event, float x, float y) {
		           System.out.println("Tu cliques !");
		           gsm.set(new GameState(gsm));
		       }
		  });
	}
	

	public void resize(int width, int height) {
		camera.setToOrtho(false, width, height);
	}

	public void render(SpriteBatch sb) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sb.begin();
		sb.draw(background, 0, 0);
		camera.update();
		sb.end();
		stage.draw();
	}

	public void dispose() {
		batch.dispose();
		stage.dispose();
		background.dispose();
	}

	public void update(float dt) {
		// TODO Auto-generated method stub
	}

}