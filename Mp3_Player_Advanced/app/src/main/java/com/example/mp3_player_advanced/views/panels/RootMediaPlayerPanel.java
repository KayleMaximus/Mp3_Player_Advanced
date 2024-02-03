package com.example.mp3_player_advanced.views.panels;

import android.content.Context;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;

import com.example.extensions.bottomsheet.CustomBottomSheetBehavior;
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
        DisplayMetrics dm = getResources().getDisplayMetrics();
        FrameLayout layout = findViewById(R.id.media_player_bottom_sheet_behavior);

        ViewGroup.LayoutParams params = layout.getLayoutParams();
        params.height = dm.heightPixels - (mPeakHeight);
        layout.setLayoutParams(params);

        CustomBottomSheetBehavior<FrameLayout> bottomSheetBehavior = CustomBottomSheetBehavior.from(layout);
        bottomSheetBehavior.setSkipAnchored(false);
        bottomSheetBehavior.setAllowUserDragging(true);

        bottomSheetBehavior.setAnchorOffset((int) (dm.heightPixels * 0.75f));
        bottomSheetBehavior.setPeekHeight(getPeakHeight());
        bottomSheetBehavior.setMediaPlayerBarHeight(getPeakHeight());
        bottomSheetBehavior.setState(CustomBottomSheetBehavior.STATE_COLLAPSED);

        bottomSheetBehavior.addBottomSheetCallback(new CustomBottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int oldState, int newState) {
                switch (newState) {
                    case CustomBottomSheetBehavior.STATE_ANCHORED:
                    case CustomBottomSheetBehavior.STATE_EXPANDED:
                    case CustomBottomSheetBehavior.STATE_DRAGGING:
                        mParentSlidingPanel.setSlidingEnabled(false);
                        break;
                    default:
                        mParentSlidingPanel.setSlidingEnabled(true);

                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });

    }

    @Override
    public void onPanelStateChanged(int panelSate) {

    }
}
