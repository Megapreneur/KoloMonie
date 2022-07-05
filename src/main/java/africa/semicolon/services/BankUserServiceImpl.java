package africa.semicolon.services;

import africa.semicolon.Exceptions.EmailNotFoundException;
import africa.semicolon.Exceptions.UserAlreadyExistException;
import africa.semicolon.Utils.Mapper;
import africa.semicolon.data.models.BankUser;
import africa.semicolon.data.repositories.BankUserRepository;
import africa.semicolon.dto.Request.*;
import africa.semicolon.dto.Response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


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
        Optional<BankUser> savedUser = bankUserRepository.findByEmail(loginUserRequest.getEmail());
        if (savedUser.isPresent()){
            if (savedUser.get().getPassword().equals(loginUserRequest.getPassword())){
                LoginUserResponse loginUserResponse = new LoginUserResponse();
                loginUserResponse.setMessage("Welcome back " + savedUser.get().getFirstName());
                return loginUserResponse;
            }
        }
        throw new EmailNotFoundException("Email not found");
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
