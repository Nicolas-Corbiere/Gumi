package com.pa.gumi;

import androidx.annotation.NonNull;

public class AffichageOperation {

    private String operation;
    private String operationResultat;

    public AffichageOperation(String operation,String operationResultat){
        this.operation = operation;
        this.operationResultat = operationResultat;
    }

    public String getOperation() {
        return operation;
    }

    public String getOperationResultat() {
        return operationResultat;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setOperationResultat(String operationResultat) {
        this.operationResultat = operationResultat;
    }

    @NonNull
    @Override
    public String toString() {
        return "operation : " + operation + " operationResultat : " + operationResultat;
    }
}
