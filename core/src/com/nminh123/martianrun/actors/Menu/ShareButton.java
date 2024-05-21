package com.nminh123.martianrun.actors.Menu;

import com.badlogic.gdx.math.Rectangle;
import com.nminh123.martianrun.utils.Constants;

public class ShareButton extends GameButton {

    public interface ShareButtonListener {
        public void onShare();
    }

    private ShareButtonListener listener;

    public ShareButton(Rectangle bounds, ShareButtonListener listener) {
        super(bounds);
        this.listener = listener;
    }

    @Override
    protected String getRegionName() {
        return Constants.SHARE_REGION_NAME;
    }

    @Override
    public void touched() {
        listener.onShare();
    }

}
