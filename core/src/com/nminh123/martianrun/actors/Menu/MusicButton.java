package com.nminh123.martianrun.actors.Menu;

import com.badlogic.gdx.math.Rectangle;
import com.nminh123.martianrun.utils.AudioUtils;

public class MusicButton extends GameButton {

    public MusicButton(Rectangle bounds) {
        super(bounds);
    }

    protected String getRegionName() {
        return AudioUtils.getInstance().getMusicRegionName();
    }

    public void touched() {
        if (AudioUtils.getInstance().getMusic().isPlaying()) {
            AudioUtils.getInstance().pauseMusic();
        }
        AudioUtils.getInstance().toggleMusic();
        AudioUtils.getInstance().playMusic();
    }

}
