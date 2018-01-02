package com.example.cassa.entrainementprojettut.operation.SetsOperation;

import android.support.annotation.NonNull;

import com.example.cassa.entrainementprojettut.operation.Addition;
import com.example.cassa.entrainementprojettut.operation.I_operation;
import com.example.cassa.entrainementprojettut.operation.Multiplication;
import com.example.cassa.entrainementprojettut.operation.Soustraction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clement on 02/01/18.
 */

public class SetOperationCE2 implements I_SetOperation {

    private List<I_operation> operations;

    public SetOperationCE2() {
        this.operations = genererSetOperation();
    }

    @Override
    public List<I_operation> getOperations() {
        return operations;
    }

    @Override
    public List<I_operation> genererSetOperation() {
        List<I_operation> resultat = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            I_operation ioperation =genererUneOperation();
            resultat.add(ioperation);
        }
        return resultat;
    }

    @Override
    public I_operation getUneOperation(int i) {
        return operations.get(i);
    }

    @Override
    public I_operation genererUneOperation() {
        I_operation operation;
        int operateur=(int)(Math.random() * (3) + 1);
        switch (operateur){
            case 1:
                operation= genererAddition();
                break;
            case 2:
                operation= genererSoustraction();
                break;
            case 3:
                operation = genererMultiplicationSimple();
                break;
            default:
                operation=genererAddition();
                break;
        }

        return operation;
    }

    @NonNull
    private I_operation genererMultiplicationSimple() {
        int terme1=genererMultipleSimple();
        Multiplication multiplication=new Multiplication();
        multiplication.genererOperation(terme1,10,1);
        return multiplication;
    }

    private int genererMultipleSimple() {
        int tabProduit[] = new int[4];
        tabProduit[1] = 2;
        tabProduit[2] = 5;
        tabProduit[3] = 10;

        return tabProduit[(int)(Math.random() * (3) + 1)];
    }

    @NonNull
    public I_operation genererSoustraction() {
        Soustraction soustraction=new Soustraction();
        soustraction.genererOperation(10,1,10,1);
        return soustraction;
    }

    @NonNull
    public I_operation genererAddition() {
        Addition addition=new Addition();
        addition.genererOperation(10,1,10,1);
        return addition;
    }
}