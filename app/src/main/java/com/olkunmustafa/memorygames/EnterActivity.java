package com.olkunmustafa.memorygames;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by olkunmustafa on 15/06/16
 */
public class EnterActivity extends BaseActivity {

    /**
     * Indicates a view for start button
     *
     * @since 0.1.0
     */
    private Button startButton;

    /**
     * Indicates a view for game name.
     */
    private TextView gameName;


    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activitiy_enter );

        this.findViews();
        this.startGame();

    }

    @Override
    protected void onStart() {
        super.onStart();

        this.animates();
    }

    /**
     * Finds views in Activity
     *
     * @since 0.1.0
     */
    private void findViews() {
        this.startButton = ( Button ) findViewById( R.id.startButton );
        this.gameName = ( TextView ) findViewById( R.id.gameName );

    }

    /**
     * Starts the game
     *
     * @since 0.1.0
     */
    private void startGame() {
        this.startButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {

                Intent intent = new Intent( EnterActivity.this, MainActivity.class );
                startActivity( intent );

            }
        } );

    }

    /**
     * Animates the main views in enter screen
     *
     * @since 0.1.0
     */
    private void animates() {

        long duration = 1200;
        long delay = 750;

        PropertyValuesHolder alpha
                = PropertyValuesHolder.ofFloat( View.ALPHA, 1f );
        PropertyValuesHolder translationY
                = PropertyValuesHolder.ofFloat( View.TRANSLATION_Y, 1f );

        ObjectAnimator animGameName
                = ObjectAnimator.ofPropertyValuesHolder( gameName, alpha, translationY );
        animGameName.setDuration( duration );
        animGameName.setStartDelay( delay );
        animGameName.start();

        ObjectAnimator animStartButton
                = ObjectAnimator.ofPropertyValuesHolder( startButton, alpha, translationY );

        animStartButton.setDuration( duration );
        animStartButton.setStartDelay( duration );
        animStartButton.start();

    }

}
