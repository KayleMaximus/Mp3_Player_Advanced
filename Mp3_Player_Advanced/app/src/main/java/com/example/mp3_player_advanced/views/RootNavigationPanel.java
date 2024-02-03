package com.example.mp3_player_advanced.views;

import static com.realgear.multislidinguppanel.MultiSlidingUpPanelLayout.COLLAPSED;

import android.content.Context;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;

import com.example.mp3_player_advanced.R;
import com.realgear.multislidinguppanel.BasePanelView;
import com.realgear.multislidinguppanel.MultiSlidingUpPanelLayout;

public class RootNavigationPanel extends BasePanelView {
    public RootNavigationPanel(@NonNull Context context, MultiSlidingUpPanelLayout panelLayout) {
        super(context, panelLayout);
        getContext().setTheme(R.style.Theme_Mp3_Player_Advanced);
        LayoutInflater.from(getContext()).inflate(R.layout.layout_root_navigation_bar, this, true);
    }

    @Override
    public void onCreateView() {
        // The panel will be collapsed on start of application
        this.setPanelState(COLLAPSED);
        // The panel will slide up and down
        this.setSlideDirection(MultiSlidingUpPanelLayout.SLIDE_VERTICAL);
        // Sets the panels peak height
        this.setPeakHeight(getResources().getDimensionPixelSize(R.dimen.navigation_bar_height));
    }

    @Override
    public void onBindView() {

    }

    @Override
    public void onPanelStateChanged(int i) {

    }
}
