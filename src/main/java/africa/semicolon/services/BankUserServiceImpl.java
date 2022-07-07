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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
                Mapper.map(savedUser, loginUserResponse);
                return loginUserResponse;
            }
        }
        throw new EmailNotFoundException("Email not found");
    }

    @Override
    public DepositResponse deposit(DepositRequest depositRequest) {
        Optional<BankUser> savedUser = bankUserRepository.findByEmail(depositRequest.getEmail());
        if (savedUser.isPresent()){
            if (depositRequest.getAmount() < 0){
                savedUser.get().setBalance(savedUser.get().getBalance() + depositRequest.getAmount());

                DepositResponse depositResponse = new DepositResponse();
                depositResponse.setMessage("The deposit of " + depositRequest.getAmount() + " to " +
                        savedUser.get().getFirstName() + " " + savedUser.get().getLastName() + " was successful");
                depositResponse.setLocalDateTime(LocalDateTime.parse(DateTimeFormatter.ofPattern("EEEE, dd/MM/yyyy, hh:mm, a")
                        .format(savedUser.get().getLocalDateTime())));
                return depositResponse;
            }
        }


        throw new IllegalArgumentException("Invalid deposit");
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
