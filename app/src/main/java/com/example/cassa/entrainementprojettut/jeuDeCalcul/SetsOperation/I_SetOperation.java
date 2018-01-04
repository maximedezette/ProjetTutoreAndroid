package com.example.cassa.entrainementprojettut.jeuDeCalcul.SetsOperation;

import com.example.cassa.entrainementprojettut.jeuDeCalcul.Operations.I_Operation;

/**
 * Created by clement on 02/01/18.
 */

public interface I_SetOperation {

    I_Operation genererUneOperation();

    I_Operation getOperation();

    int getTerme1Operation();

    int getTerme2Operation();

    char getSigneOperation();

}