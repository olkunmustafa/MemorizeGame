package com.olkunmustafa.memorygames.Util;

import com.olkunmustafa.memorygames.Holders.GradeRowColumn;
import com.olkunmustafa.memorygames.Holders.SquaresInformations;

import java.util.ArrayList;

/**
 * Created by olkunmustafa on 22/05/16
 */
public class CalculateHelper {

    /**
     * @param gradeRowColumn Mevcut oyunun temel bilgileri.
     * @return Mevcut oyunda hangi karelerin aktif olacağına
     * dair ve diğer özelliklerini doldurur.
     *
     * TODO gelişmiş bir algoritma sonradan doldurulacak.
     * @since 0.1.0
     */
    public static ArrayList< SquaresInformations > getGradedList( GradeRowColumn gradeRowColumn ) {

        ArrayList< SquaresInformations > informations = new ArrayList< SquaresInformations >();
        int total = gradeRowColumn.getRow() * gradeRowColumn.getColumn();
        for ( int i = 1; i <= total; i++ ) {

            boolean active = gradeRowColumn.activeCount >= i;
            informations.add( new SquaresInformations( active ) );

        }

        return informations;
    }

}