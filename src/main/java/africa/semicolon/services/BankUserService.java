package africa.semicolon.services;

import africa.semicolon.dto.Request.*;
import africa.semicolon.dto.Response.*;

public interface BankUserService {
    RegisterUserResponse createAccount(RegisterUserRequest request);
    LoginUserResponse loginRequest(LoginUserRequest loginUserRequest);
    DepositResponse deposit(DepositRequest depositRequest);
    TransferResponse transfer(TransferRequest transferRequest);
    WithdrawalResponse withdrawal(WithdrawalRequest withdrawalRequest);
    CheckBalanceResponse checkBalance(CheckBalanceRequest checkBalanceRequest);
}
