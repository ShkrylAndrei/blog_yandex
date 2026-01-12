package info.database.mongo_account_transaction;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/transfers")
public class TransferController {

    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping
    public void transfer(@RequestParam String fromId,
                         @RequestParam String toId,
                         @RequestParam BigDecimal amount) {
        transferService.transferMoney(fromId, toId, amount);
    }
}
