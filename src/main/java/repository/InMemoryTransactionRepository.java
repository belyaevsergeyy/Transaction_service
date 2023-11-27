package repository;

import by.itstep.dto.Transaction;
import exception.TransactionNotFound;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;


public class InMemoryTransactionRepository implements TransactionRepository{

    private HashMap<UUID, Transaction> inMemoryStorage;
    private static Long id;

    InMemoryTransactionRepository(HashMap<UUID, Transaction> inMemoryStorage)
    {
        this.inMemoryStorage = inMemoryStorage;
        InMemoryTransactionRepository.id = 0L;
    }


    public void save(Transaction transaction) {

      inMemoryStorage.put(InMemoryTransactionRepository.getUuid(), transaction);
    }

    public Transaction getById(UUID id) throws  TransactionNotFound{
        Transaction res = inMemoryStorage.get(id);
        if (res == null){
            throw new TransactionNotFound("Transaction not found");
        }
        return res;
    }

    public void update(Long id, Transaction transaction) {
        inMemoryStorage.
    }

    public void delete(Transaction transaction) {
    inMemoryStorage.remove(InMemoryTransactionRepository.id);

    }

    public List<Transaction> getAll() {
        return null;
    }
}
