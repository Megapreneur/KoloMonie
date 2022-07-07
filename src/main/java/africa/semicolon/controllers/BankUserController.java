package africa.semicolon.controllers;

import africa.semicolon.dto.Request.DepositRequest;
import africa.semicolon.dto.Request.LoginUserRequest;
import africa.semicolon.dto.Request.RegisterUserRequest;
import africa.semicolon.dto.Response.DepositResponse;
import africa.semicolon.dto.Response.LoginUserResponse;
import africa.semicolon.dto.Response.RegisterUserResponse;
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
        return bankUserService.registerResponse(request);
    }
    @PostMapping("/bankUser/login")
    public LoginUserResponse loginRequest(@RequestBody LoginUserRequest loginUserRequest){
        return bankUserService.loginRequest(loginUserRequest);
    }
    @PostMapping("/bankUser/deposit")
    public DepositResponse deposit(@RequestBody DepositRequest depositRequest){
        return bankUserService.deposit(depositRequest);
    }

}
