package africa.semicolon.services;

import africa.semicolon.Exceptions.UserAlreadyExistException;
import africa.semicolon.Utils.Mapper;
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
        if (bankUserRepository.existsByEmail(request.getEmail())) throw new UserAlreadyExistException("Email already exist");
        BankUser user = new BankUser();
        Mapper.map(request, user);

        BankUser savedUser = bankUserRepository.save(user);
        RegisterUserResponse userResponse = new RegisterUserResponse();
        Mapper.map(savedUser, userResponse);

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
