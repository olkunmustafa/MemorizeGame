package com.olkunmustafa.memorygames;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by olkunmustafa on 21/05/16
 */
public class BaseActivity extends AppCompatActivity {

    /**
     * Allows the system resources
     *
     * @since 0.1.0
     */
    protected Resources mResources;

    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );

        this.mResources = getResources();
    }
}
