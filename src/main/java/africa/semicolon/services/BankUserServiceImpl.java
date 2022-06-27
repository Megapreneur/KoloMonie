package africa.semicolon.services;

import africa.semicolon.data.models.BankUser;
import africa.semicolon.data.repositories.BankUserRepository;
import africa.semicolon.dto.Request.*;
import africa.semicolon.dto.Response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BankUserServiceImpl implements BankUserService{
    @Autowired
    private BankUserRepository bankUserRepository;
    @Override
    public RegisterUserResponse registerResponse(RegisterUserRequest request) {
        BankUser user = new BankUser();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setAddress(request.getAddress());
        user.setPhoneNumber(request.getPhoneNumber());

        BankUser savedUser = bankUserRepository.save(user);
        RegisterUserResponse userResponse = new RegisterUserResponse();
        userResponse.setMessage(savedUser.getFirstName()  + " Account successfully created");
        userResponse.setAccountNumber("Your account number is ");



        return userResponse;
    }
    @Override
    public LoginUserResponse loginRequest(LoginUserRequest loginUserRequest) {
        return null;
    }

    @Override
    public DepositResponse deposit(DepositRequest depositRequest) {
        return null;
    }

    @Override
    public TransferResponse transfer(TransferRequest transferRequest) {
        return null;
    }

    @Override
    public WithdrawalResponse withdrawal(WithdrawalRequest withdrawalRequest) {
        return null;
    }

    @Override
    public CheckBalanceResponse checkBalance(CheckBalanceRequest checkBalanceRequest) {
        return null;
    }


}
