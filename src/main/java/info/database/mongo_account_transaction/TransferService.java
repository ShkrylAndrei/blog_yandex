package info.database.mongo_account_transaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class TransferService {

    private static final Logger log = LoggerFactory.getLogger(TransferService.class);

    private final AccountRepository accountRepository;
    private final TransferLogRepository transferLogRepository;
    private final MongoTemplate mongoTemplate;

    public TransferService(AccountRepository accountRepository,
                           TransferLogRepository transferLogRepository,
                           MongoTemplate mongoTemplate) {
        this.accountRepository = accountRepository;
        this.transferLogRepository = transferLogRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @Transactional
    public void transferMoney(String fromAccountId, String toAccountId, BigDecimal amount) {
        log.info("Начинаем перевод {} от {} к {}", amount, fromAccountId, toAccountId);

        Account fromAccount = accountRepository.findById(fromAccountId)
                .orElseThrow(() -> new IllegalArgumentException("Счёт отправителя не найден"));
        Account toAccount = accountRepository.findById(toAccountId)
                .orElseThrow(() -> new IllegalArgumentException("Счёт получателя не найден"));

        if (fromAccount.getBalance().compareTo(amount) < 0) {
            throw new IllegalArgumentException("Недостаточно средств");
        }

        // Уменьшаем баланс отправителя
        fromAccount.setBalance(fromAccount.getBalance().subtract(amount));
        accountRepository.save(fromAccount);

        // Увеличиваем баланс получателя
        toAccount.setBalance(toAccount.getBalance().add(amount));
        accountRepository.save(toAccount);

        // Логируем операцию
        TransferLog logEntry = new TransferLog(fromAccountId, toAccountId, amount);
        transferLogRepository.save(logEntry);

        log.info("Перевод успешно завершён");
    }
}
