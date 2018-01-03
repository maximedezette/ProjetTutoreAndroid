package com.example.cassa.entrainementprojettut.operation.SetsOperation;

import com.example.cassa.entrainementprojettut.operation.Addition;
import com.example.cassa.entrainementprojettut.operation.I_Operation;
import com.example.cassa.entrainementprojettut.operation.Soustraction;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by clement on 03/01/18.
 */
public class SetOperationCM2Test {

    private I_SetOperation setOperation;
    private I_Operation operation;

    @Before
    public void setUp() throws Exception {
        setOperation=new SetOperationCM2();
    }

    @Test
    public void testPresenceDesTroisOperations() throws Exception {
        int nbAddition=0,nbSoustraction=0,nbMultiplication=0;
        for (int i = 0; i <10000 ; i++) {
            operation=setOperation.genererUneOperation();
            if(operation.getClass()== Addition.class){
                nbAddition++;
            }else if(operation.getClass()== Soustraction.class){
                nbSoustraction++;
            }else{
                nbMultiplication++;
            }
        }
        assertEquals(true,nbAddition>0 && nbSoustraction>0 && nbMultiplication>0);
    }

}