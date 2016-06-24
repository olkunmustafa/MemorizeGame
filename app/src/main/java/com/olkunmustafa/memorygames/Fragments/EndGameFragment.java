package com.olkunmustafa.memorygames.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.olkunmustafa.memorygames.R;

/**
 * A simple {@link Fragment} subclass.
 *
 * @since 0.1.0
 */
public class EndGameFragment extends Fragment {


    public EndGameFragment() {
        // Required empty public constructor
    }

    /**
     * Crates singleton helper for EndGameFragment
     */
    public static EndGameFragment singleton;


    /**
     * Singleton helper.
     */
    public static EndGameFragment newInstance(){

        if( singleton == null )
            singleton = new EndGameFragment();

        return singleton;

    }


    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState ) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate( R.layout.fragment_end_game, container, false );

        return rootView;
    }

}
