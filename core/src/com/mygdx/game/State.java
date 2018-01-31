package com.mygdx.game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public abstract class State{
    protected Vector3 mouse;
    protected final GameStateManager gsm;

    public State(GameStateManager gsm){
        this.gsm = gsm;
        mouse = new Vector3();
    }
    public abstract void update(float dt);
    public abstract void render(SpriteBatch sb);
    public abstract void dispose();
}