package com.mediamonks.googleflip.pages.settings;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import com.mediamonks.googleflip.BuildConfig;
import com.mediamonks.googleflip.R;
import com.mediamonks.googleflip.data.constants.PrefKeys;
import com.mediamonks.googleflip.pages.game.physics.constants.Physics;
import com.mediamonks.googleflip.ui.RegisteredFragmentActivity;
import com.mediamonks.googleflip.util.FloatPrefSeekBarController;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by stephan on 8-5-2015.
 */
public class SettingsActivity extends RegisteredFragmentActivity {
    private static final String TAG = SettingsActivity.class.getSimpleName();

    @Bind(R.id.sb_density)
    protected SeekBar _densitySeekBar;
    @Bind(R.id.tv_ball_density)
    protected TextView _ballDensityText;
    @Bind(R.id.sb_gravity)
    protected SeekBar _gravitySeekBar;
    @Bind(R.id.tv_gravity_factor)
    protected TextView _gravityFactorText;
    @Bind(R.id.sb_wall_elasticity)
    protected SeekBar _wallElasticitySeekBar;
    @Bind(R.id.tv_wall_elasticity)
    protected TextView _wallElasticityText;
    @Bind(R.id.tv_version)
    protected TextView _versionText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);

        FloatPrefSeekBarController controller = new FloatPrefSeekBarController(this, _densitySeekBar, _ballDensityText, R.string.ball_density, PrefKeys
                .BALL_DENSITY);
        controller.initValues(.01f, .5f, Physics.BALL_DENSITY);

        controller = new FloatPrefSeekBarController(this, _gravitySeekBar, _gravityFactorText, R.string.gravity_factor, PrefKeys.GRAVITY_FACTOR);
        controller.initValues(50, 500, Physics.GRAVITY_FACTOR);

        controller = new FloatPrefSeekBarController(this, _wallElasticitySeekBar, _wallElasticityText, R.string.wall_elasticity, PrefKeys.WALL_ELASTICITY);
        controller.initValues(0, .9f, Physics.WALL_ELASTICITY);

        _versionText.setText(BuildConfig.VERSION_NAME + " - " + BuildConfig.BUILD_DATE);
    }
}
