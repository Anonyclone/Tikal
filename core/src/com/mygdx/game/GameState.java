package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.renderers.HexagonalTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class GameState extends State {

	private Stage stage;
	private TiledMap map;
	private OrthographicCamera camera;
	private HexagonalTiledMapRenderer renderer;
	private Texture background;
	
	private Texture hexture;
	private Texture hexture27;
	private Hud hud;
	private Skin skin;
	
	private Joueur j1;
	private Joueur j2;
	private Joueur j3;
	private Joueur j4;
	private Joueur actif;
	
	public GameState(GameStateManager gsm) {
		super(gsm);
		//background = new Texture("backgroundJeux.jpg");
		float w = 128;
		float h = 128;
	
		j1 = new Joueur("Joueur 1");
		j2 = new Joueur("Joueur 2");
		j3 = new Joueur("Joueur 3");
		j4 = new Joueur("Joueur 4");
		////////////////TEST////////////////
		Tresor t1 = new Tresor("Tresor");
		j1.ajouterTresor(t1);
		actif = j4;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, (w / h) * 1170, 960);//780,640
		camera.update();

		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		skin = new Skin(Gdx.files.internal("ui/defaultskin.json"));
		hexture = new Texture("test.png");
		hexture27 = new Texture("27.png");

		hud = new Hud(gsm);
		
		TextureRegion[][] hexes = TextureRegion.split(hexture, 125, 110);
		map = new TiledMap();
		MapLayers layers = map.getLayers();
		TiledMapTile[] tiles = new TiledMapTile[3];
		tiles[0] = new StaticTiledMapTile(new TextureRegion(hexes[0][0]));

		for (int l = 0; l < 5; l++) {
			TiledMapTileLayer layer = new TiledMapTileLayer(8, 5, 125, 110);//8,5,125,110
			for (int y = 0; y < 5; y++) {
				for (int x = 0; x < 8; x++) {
					int id = 0;
					Cell cell = new Cell();
					cell.setTile(tiles[id]);
					layer.setCell(x, y, cell);
					System.out.println("x :" + x + " " + "y : " + y + " " + "cell :" + cell);
				}
			}
			layers.add(layer);
		}
		renderer = new HexagonalTiledMapRenderer(map);
		j1.setActif();
		
		
		TextButton buttonPion = new TextButton("Placer un pion", skin);
		buttonPion.setBounds(560, 400, 200, 35);
		stage.addActor(buttonPion);
		buttonPion.addListener(new ClickListener(){
		       @Override
		       public void clicked(InputEvent event, float x, float y) {
		           System.out.println("Place un pion");
		           if(actif.placerPionPoint() == false){
		        	   notEnoughPoint();
		           }
		           hud.updateTour(actif);
		       }
		  });
		  
		TextButton buttonPionMouv = new TextButton("Deplacer un pion", skin);
		buttonPionMouv.setBounds(560, 360, 200, 35);
		stage.addActor(buttonPionMouv);
		buttonPionMouv.addListener(new ClickListener(){
				@Override
			    public void clicked(InputEvent event, float x, float y) {
					System.out.println("Delace un pion");
					if(actif.deplacerPionPoint() == false){
						notEnoughPoint();
					}
			       }
			   });
			  
		TextButton buttonComapement = new TextButton("Placer un campement", skin);
		buttonComapement.setBounds(560, 320, 200, 35);
		stage.addActor(buttonComapement);
		buttonComapement.addListener(new ClickListener(){
				@Override
				public void clicked(InputEvent event, float x, float y) {
					System.out.println("Place un campement");
					if(actif.placerCampementPoint() == false){
						notEnoughPoint();
					}
					hud.updateTour(actif);
				       }
				});
		
		TextButton buttonDeterrerTresor = new TextButton("Deterrer un tresor", skin);
		buttonDeterrerTresor.setBounds(560, 280, 200, 35);
		stage.addActor(buttonDeterrerTresor);
		buttonDeterrerTresor.addListener(new ClickListener(){
				@Override
				public void clicked(InputEvent event, float x, float y) {
					System.out.println("Deterrer un tresor");
					if(actif.deterrerTresorPoint() == false){
						notEnoughPoint();
					}
					hud.updateTour(actif);
				       }
				});
		
		TextButton buttonEchangerTresor = new TextButton("Echanger un tresor", skin);
		buttonEchangerTresor.setBounds(560, 240, 200, 35);
		stage.addActor(buttonEchangerTresor);
		buttonEchangerTresor.addListener(new ClickListener(){
				@Override
				public void clicked(InputEvent event, float x, float y) {
					System.out.println("Echanger un tresor");
					actif.Afficher();
					
				       }
				});
		
		TextButton buttonAmeliorerTemple = new TextButton("Ameliorer un temple", skin);
		buttonAmeliorerTemple.setBounds(560, 200, 200, 35);
		stage.addActor(buttonAmeliorerTemple);
		buttonAmeliorerTemple.addListener(new ClickListener(){
				@Override
				public void clicked(InputEvent event, float x, float y) {
					System.out.println("Ameliorer un temple");
					if(actif.AmeliorerTemplePoint() == false){
						notEnoughPoint();
					}
					hud.updateTour(actif);
				       }
				});
				
		TextButton buttonGardien = new TextButton("Placer un gardien", skin);
		buttonGardien.setBounds(560, 160, 200, 35);
		stage.addActor(buttonGardien);
		buttonGardien.addListener(new ClickListener(){
				@Override
				public void clicked(InputEvent event, float x, float y) {
					System.out.println("Place un gardien");
					if(actif.PlacerGardienPoint()){
						notEnoughPoint();
					}
					hud.updateTour(actif);
				       }
				});
		
		TextButton buttonTerminerTour = new TextButton("Terminer le tour", skin);
		buttonTerminerTour.setBounds(560, 60, 200, 50);
		stage.addActor(buttonTerminerTour);
		buttonTerminerTour.addListener(new ClickListener(){
				@Override
				public void clicked(InputEvent event, float x, float y) {
					actif.setPa(10);
					tourSuivant();
				       }
				});
		
		TextButton buttonQuitter = new TextButton("Quitter la partie", skin);
		buttonQuitter.setBounds(560, 5, 200, 50);
		stage.addActor(buttonQuitter);
		buttonQuitter.addListener(new ClickListener(){
				@Override
				public void clicked(InputEvent event, float x, float y) {
					System.out.println("Quitter");
					Gdx.app.exit();
				       }
				});
		tourSuivant();//Initialisation du tour  avec le Joueur1
	}

	@Override
	public void render(SpriteBatch sb) {
		Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
		sb.begin();
		//sb.draw(background, 0, 0);
		camera.update();
		renderer.setView(camera);
		renderer.render();
		hud.stage.draw();
		hud.stage.draw();
		sb.end();
		stage.draw();
	}

	@Override
	public void dispose() {
		background.dispose();
		renderer.dispose();
		hexture.dispose();
		map.dispose();
		stage.dispose();
		hud.dispose();
	}

	public void push() {
		// TODO Auto-generated method stub
		System.out.println("Envoyé");
	}

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		
	}
	
	public void tourSuivant(){
    	if(actif == j1){
    		actif = j2;
    	}
    	else if(actif == j2){
    		actif = j3;
    	}
    	else if(actif == j3){
    		actif = j4;
    	}
    	else if(actif == j4){
    		actif = j1;
    	}
    	hud.updateTour(actif);
	}
	
	public void notEnoughPoint(){
		Dialog dialog = new Dialog("Erreur PA", skin, "dialog") {
		    public void result(Object obj) {
		        System.out.println("result "+obj);
		        remove();
		    }
		};
		dialog.text("Vous n'avez pas assez de point d'action !");
		dialog.button("Ok", true); //sends "true" as the result
		dialog.show(stage);
	}
	
	public void selectJoueurEchange(){
		Dialog dialog = new Dialog("Echanger un tresor", skin, "dialog") {
		    public void result(Object obj) {
		    	remove();
		    }
		};
		dialog.text("Avec quel joueur voulez-vous echanger un tresor ?");
		for(Tresor t : actif.getTresors()){
		dialog.button("Joueur 1", j1);
		dialog.button("Joueur 2", j2);
		dialog.button("Joueur 3", j3);
		dialog.button("Joueur 4", j4);
		}
		dialog.show(stage);
	}
	

}