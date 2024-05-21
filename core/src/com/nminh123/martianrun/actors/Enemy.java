package com.nminh123.martianrun.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.physics.box2d.Body;
import com.nminh123.martianrun.box2d.EnemyUserData;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.nminh123.martianrun.utils.Constants;
import com.badlogic.gdx.Gdx;

public class Enemy extends GameActor
{
    private Animation animation;
    private float stateTime;
    public Enemy(Body body)
    {
        super(body);
        TextureAtlas textureAtlas = new TextureAtlas(Constants.CHARACTERS_ATLAS_PATH);
        TextureRegion[] runningFrames = new TextureRegion[getUserData().getTextureRegion().length];
        for (int i = 0; i < getUserData().getTextureRegion().length; i++) {
            String path = getUserData().getTextureRegion()[i];
            runningFrames[i] = textureAtlas.findRegion(path);
        }
        animation = new Animation(0.1f, runningFrames);
        stateTime = 0f;
    }

    /*public Enemy(Body body) {
        super(body);
        animation = AssetsManager.getAnimation(getUserData().getAnimationAssetId());
        stateTime = 0f;
    }*/
    @Override
    public EnemyUserData getUserData()
    {
        return (EnemyUserData) userData;
    }
    @Override
    public void act(float delta)
    {
        super.act(delta);
        body.setLinearVelocity(getUserData().getLinearVelocity());
    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        stateTime += Gdx.graphics.getDeltaTime();
        batch.draw((TextureRegion) animation.getKeyFrame(stateTime, true),
                (screenRectangle.x - (screenRectangle.width * 0.1f)),
                screenRectangle.y, screenRectangle.width * 1.2f,
                screenRectangle.height * 1.1f);
    }
}
