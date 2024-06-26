package org.sid.tp6_ebankingbackend.web;

import lombok.AllArgsConstructor;
import org.sid.tp6_ebankingbackend.dtos.AccountHistoryDTO;
import org.sid.tp6_ebankingbackend.dtos.AccountOperationDTO;
import org.sid.tp6_ebankingbackend.entities.BankAccountDTO;
import org.sid.tp6_ebankingbackend.exceptions.BankAccountNotFoundException;
import org.sid.tp6_ebankingbackend.services.BankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor

@CrossOrigin("*")
public class BankAccountRestAPI {

    private BankAccountService bankAccountService;
@GetMapping("/accounts/{accountId}")
    public BankAccountDTO getBankAccount(@PathVariable String accountId) throws BankAccountNotFoundException {
        return bankAccountService.getBankAccount(accountId);

    }


    @GetMapping("/accounts")
    public List<BankAccountDTO> ListAccounts() {
        return bankAccountService.bankAccountList();

    }
    @GetMapping("/accounts/{accountId}/operations")
    public List<AccountOperationDTO> getHistory(@PathVariable String accountId) {
        return bankAccountService.accountHistory(accountId);

    }

    @GetMapping("/accounts/{accountId}/pageOperations")
    public AccountHistoryDTO getHistory(@PathVariable String accountId ,
                                              @RequestParam( name="page" ,defaultValue = "0") int page
                                            , @RequestParam( name="size" ,defaultValue = "5") int size) throws BankAccountNotFoundException {
        return bankAccountService.getAccountHistory(accountId,page,size);

    }



}
