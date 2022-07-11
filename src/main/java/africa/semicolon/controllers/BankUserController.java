package africa.semicolon.controllers;

import africa.semicolon.dto.Request.*;
import africa.semicolon.dto.Response.*;
import africa.semicolon.services.BankUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankUserController {
@Autowired
    private BankUserService bankUserService;

    @PostMapping("/bankUser/registration")
    public RegisterUserResponse register (@RequestBody RegisterUserRequest request){
        return bankUserService.createAccount(request);
    }
    @PostMapping("/bankUser/login")
    public LoginUserResponse loginRequest(@RequestBody LoginUserRequest loginUserRequest){
        return bankUserService.loginRequest(loginUserRequest);
    }
    @PostMapping("/bankUser/deposit")
    public DepositResponse deposit(@RequestBody DepositRequest depositRequest){
        return bankUserService.deposit(depositRequest);
    }
    @PostMapping("/bankUser/withdraw")
    public WithdrawalResponse withdrawal(@RequestBody WithdrawalRequest withdrawalRequest){
        return bankUserService.withdrawal(withdrawalRequest);
    }
    @PostMapping("/bankUser/balance")
    public CheckBalanceResponse checkBalance(@RequestBody CheckBalanceRequest checkBalanceRequest){
        return bankUserService.checkBalance(checkBalanceRequest);
    }

}
