package info.database.mongo_account_transaction;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferLogRepository extends MongoRepository<TransferLog, String> {}
