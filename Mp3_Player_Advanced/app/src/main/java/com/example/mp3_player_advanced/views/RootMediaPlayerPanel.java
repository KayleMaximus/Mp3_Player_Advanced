package com.example.mp3_player_advanced.views;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;

import com.example.mp3_player_advanced.R;
import com.realgear.multislidinguppanel.BasePanelView;
import com.realgear.multislidinguppanel.MultiSlidingUpPanelLayout;

import static com.realgear.multislidinguppanel.MultiSlidingUpPanelLayout.COLLAPSED;

import java.util.Random;

public class RootMediaPlayerPanel extends BasePanelView {
    public RootMediaPlayerPanel(@NonNull Context context, MultiSlidingUpPanelLayout panelLayout) {
        super(context, panelLayout);
        getContext().setTheme(R.style.Theme_Mp3_Player_Advanced);
        LayoutInflater.from(getContext()).inflate(R.layout.layout_root_mediaplayer, this, true);
    }

    @Override
    public void onCreateView() {
        // The panel will be collapsed on start of application
        this.setPanelState(COLLAPSED);
        // The panel will slide up and down
        this.setSlideDirection(MultiSlidingUpPanelLayout.SLIDE_VERTICAL);
        // Sets the panels peak height
        this.setPeakHeight(getResources().getDimensionPixelSize(R.dimen.mediaplayerbar_height));
    }

    @Override
    public void onBindView() {
    }

    @Override
    public void onPanelStateChanged(int panelSate) {

    }
}
