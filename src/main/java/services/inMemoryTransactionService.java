package services;

import by.itstep.dto.Transaction;
import by.itstep.dto.TransactionResult;
import by.itstep.dto.TransactionType;
import exception.TransactionNotUnic;
import repository.TransactionRepository;

import java.util.UUID;

public class inMemoryTransactionService {
    private TransactionRepository transactionRepository;

    public inMemoryTransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void debit(Long amount){
        UUID uuid = UUID.randomUUID();
        Transaction foundTransaction = transactionRepository.getById(uuid);
        if (foundTransaction != null){
            Transaction newTransaction = new Transaction(
                    TransactionType.DEBIT,
                    uuid,
                    amount,
                    TransactionResult.FAILURE);
            throw new TransactionNotUnic("Transaction" + uuid + " is not unique");

        }else {
            Transaction newTransaction = new Transaction(
                    TransactionType.DEBIT,
                    uuid,
                    amount,
                    TransactionResult.SUCCESS);
            transactionRepository.save(newTransaction);
        }

    }
}
