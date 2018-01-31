package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Hud implements Disposable{

	public Stage stage;
	private OrthographicCamera camera;
	
	private Label J1;
	private Label J2;
	private Label J3;
	private Label J4;
	
	private Label Score;
	private Label Pion;
	private Label Tresor;
	
	private Label labelJoueurTour;
	private Label labelscoreJ1;
	private Label labelscoreJ2;
	private Label labelscoreJ3;
	private Label labelscoreJ4;
	
	private Label labelpionJ1;
	private Label labelpionJ2;
	private Label labelpionJ3;
	private Label labelpionJ4;
	
	private Label labelchefJ1;
	private Label labelchefJ2;
	private Label labelchefJ3;
	private Label labelchefJ4;
	
	private Skin skin;
	
	public Hud(GameStateManager gsm){
		super();
		float w = 128;
		float h = 128;
		String joueurTour = "Joueur 1";
		skin = new Skin(Gdx.files.internal("ui/defaultskin.json"));
		
		int scoreJ1 = 0;
		int scoreJ2 = 0;
		int scoreJ3 = 0;
		int scoreJ4 = 0;
		
		int pionJ1 = 0;
		int pionJ2 = 0;
		int pionJ3 = 0;
		int pionJ4 = 0;
		
		int chefJ1= 0;
		int chefJ2= 0;
		int chefJ3= 0;
		int chefJ4= 0;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, (w / h) * 1170, 960);		
		stage = new Stage();
		
		//Tableau Score
		Table tablescore = new Table();
		tablescore.left();
		tablescore.setFillParent(true);
		tablescore.setPosition(-200, 340);
		
		//Tableau Pion
		Table tablepion = new Table();
		tablepion.left();
		tablepion.setFillParent(true);
		tablepion.setPosition(-25, 340);
		
		//Tableau Tresors
		Table tabletresor = new Table();
		tabletresor.left();
		tabletresor.setFillParent(true);
		tabletresor.setPosition(250, 340);
		//300 245 190 135 
		
		//Info du joueur 1					
		Table tablej1 = new Table();	Table tableScorej1 = new Table();		Table tablePionj1 = new Table();
		tablej1.left();					tableScorej1.left();					tablePionj1.left();
		tablej1.setFillParent(true);	tableScorej1.setFillParent(true);		tablePionj1.setFillParent(true);
		tablej1.setPosition(-350, 300);	tableScorej1.setPosition(-200, 300);	tablePionj1.setPosition(-50, 300);
		
		//Info du joueur 2					
		Table tablej2 = new Table();	Table tableScorej2 = new Table();		Table tablePionj2 = new Table();
		tablej2.left();					tableScorej2.left();					tablePionj2.left();
		tablej2.setFillParent(true);	tableScorej2.setFillParent(true);		tablePionj2.setFillParent(true);
		tablej2.setPosition(-350, 250);	tableScorej2.setPosition(-200, 250);	tablePionj2.setPosition(-50, 250);
		
		//Info du joueur 3					
		Table tablej3 = new Table();	Table tableScorej3 = new Table();		Table tablePionj3 = new Table();
		tablej3.left();					tableScorej3.left();					tablePionj3.left();
		tablej3.setFillParent(true);	tableScorej3.setFillParent(true);		tablePionj3.setFillParent(true);
		tablej3.setPosition(-350, 200);	tableScorej3.setPosition(-200, 200);	tablePionj3.setPosition(-50, 200);
	
		//Info du joueur 4					
		Table tablej4 = new Table();	Table tableScorej4 = new Table();		Table tablePionj4 = new Table();
		tablej4.left();					tableScorej4.left();					tablePionj4.left();
		tablej4.setFillParent(true);	tableScorej4.setFillParent(true);		tablePionj4.setFillParent(true);
		tablej4.setPosition(-350, 150);	tableScorej4.setPosition(-200, 150);	tablePionj4.setPosition(-50, 150);
		
		//Chef pion			
		Table tableChefj1 = new Table();	Table tableChefj2 = new Table();	Table tableChefj3 = new Table();
		tableChefj1.left();					tableChefj2.left();					tableChefj3.left();
		tableChefj1.setFillParent(true);	tableChefj2.setFillParent(true);	tableChefj3.setFillParent(true);
		tableChefj1.setPosition(10, 300);	tableChefj2.setPosition(10, 250);	tableChefj3.setPosition(10, 200);
		
		//Chef pion
		Table tableChefj4 = new Table();
		tableChefj4.left();
		tableChefj4.setFillParent(true);
		tableChefj4.setPosition(10, 150);
		
		//Affichage du tour
		Table table2 = new Table();
		table2.right();
		table2.setFillParent(true);
		table2.setPosition(257, -215);
		
		
		labelJoueurTour = new Label(String.format("%s", joueurTour), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		labelscoreJ1 = new Label(String.format("%d", scoreJ1), new Label.LabelStyle(new BitmapFont(), Color.BLUE));
		labelscoreJ2 = new Label(String.format("%d", scoreJ2), new Label.LabelStyle(new BitmapFont(), Color.RED));
		labelscoreJ3 = new Label(String.format("%d", scoreJ3), new Label.LabelStyle(new BitmapFont(), Color.GREEN));
		labelscoreJ4 = new Label(String.format("%d", scoreJ4), new Label.LabelStyle(new BitmapFont(), Color.YELLOW));
		
		labelpionJ1 = new Label(String.format("%d", pionJ1), new Label.LabelStyle(new BitmapFont(), Color.BLUE));
		labelpionJ2 = new Label(String.format("%d", pionJ2), new Label.LabelStyle(new BitmapFont(), Color.RED));
		labelpionJ3 = new Label(String.format("%d", pionJ3), new Label.LabelStyle(new BitmapFont(), Color.GREEN));
		labelpionJ4 = new Label(String.format("%d", pionJ4), new Label.LabelStyle(new BitmapFont(), Color.YELLOW));
		
		labelchefJ1 = new Label(String.format("%d", chefJ1), new Label.LabelStyle(new BitmapFont(), Color.BLUE));
		labelchefJ2 = new Label(String.format("%d", chefJ2), new Label.LabelStyle(new BitmapFont(), Color.RED));
		labelchefJ3 = new Label(String.format("%d", chefJ3), new Label.LabelStyle(new BitmapFont(), Color.GREEN));
		labelchefJ4 = new Label(String.format("%d", chefJ4), new Label.LabelStyle(new BitmapFont(), Color.YELLOW));
		
		Score = new Label("SCORE", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		Pion = new Label("PION(S) / CHEF", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		Tresor = new Label("TRESOR(S)", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		
		J1 = new Label("JOUEUR 1", new Label.LabelStyle(new BitmapFont(), Color.BLUE));
		J2 = new Label("JOUEUR 2", new Label.LabelStyle(new BitmapFont(), Color.RED));
		J3 = new Label("JOUEUR 3", new Label.LabelStyle(new BitmapFont(), Color.GREEN));
		J4 = new Label("JOUEUR 4", new Label.LabelStyle(new BitmapFont(), Color.YELLOW));
		
		tablej1.add(J1).expandX();
		tablej2.add(J2).expandX();
		tablej3.add(J3).expandX();
		tablej4.add(J4).expandX();
		
		tableScorej1.add(labelscoreJ1).expandX();
		tableScorej2.add(labelscoreJ2).expandX();
		tableScorej3.add(labelscoreJ3).expandX();
		tableScorej4.add(labelscoreJ4).expandX();
		
		tablePionj1.add(labelpionJ1).expandX();
		tablePionj2.add(labelpionJ2).expandX();
		tablePionj3.add(labelpionJ3).expandX();
		tablePionj4.add(labelpionJ4).expandX();
		
		tableChefj1.add(labelchefJ1).expandX();
		tableChefj2.add(labelchefJ2).expandX();
		tableChefj3.add(labelchefJ3).expandX();
		tableChefj4.add(labelchefJ4).expandX();
		
		tablescore.add(Score).expandX();
		tablepion.add(Pion).expandX();
		tabletresor.add(Tresor).expandX();
		
		table2.add(labelJoueurTour).expandX();
		
		
		stage.addActor(tablej1);
		stage.addActor(tablej2);
		stage.addActor(tablej3);
		stage.addActor(tablej4);
		
		stage.addActor(table2);
		
		stage.addActor(tablescore);
		stage.addActor(tablepion);
		stage.addActor(tabletresor);
		
		stage.addActor(tableScorej1);
		stage.addActor(tableScorej2);
		stage.addActor(tableScorej3);
		stage.addActor(tableScorej4);
		
		stage.addActor(tablePionj1);
		stage.addActor(tablePionj2);
		stage.addActor(tablePionj3);
		stage.addActor(tablePionj4);
		
		stage.addActor(tableChefj1);
		stage.addActor(tableChefj2);
		stage.addActor(tableChefj3);
		stage.addActor(tableChefj4);
	}
	
	@Override
	public void dispose() {
		stage.dispose();
	}
	
	public void updateTour(Joueur j){
		labelJoueurTour.setText(String.format("Tour de : %s / PA : %d", j.getPseudo(), j.getPa() ));
	}
	
}