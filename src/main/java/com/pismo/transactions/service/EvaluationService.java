package com.pismo.transactions.service;

import com.pismo.transactions.model.EvaluationType;
import com.pismo.transactions.model.Transaction;

public interface EvaluationService {

    public EvaluationType getEvaluationType();
    public void evaluate(Transaction transaction);
}
