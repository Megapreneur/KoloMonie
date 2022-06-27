package africa.semicolon.controllers;

import africa.semicolon.dto.Request.RegisterUserRequest;
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

    @PostMapping("/bankUser")
    public RegisterUserResponse register (@RequestBody RegisterUserRequest request){
        return bankUserService.registerResponse(request);
    }
}
