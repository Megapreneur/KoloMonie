package africa.semicolon.Utils;

import africa.semicolon.data.models.BankUser;
import africa.semicolon.dto.Request.RegisterUserRequest;
import africa.semicolon.dto.Response.RegisterUserResponse;

public class Mapper {
    public static void map(RegisterUserRequest request, BankUser user) {
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setAddress(request.getAddress());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setEmail(request.getEmail());
        user.setOccupation(request.getOccupation());
    }
    public static void map(BankUser savedUser, RegisterUserResponse userResponse) {
        userResponse.setMessage("Welcome on board "+ savedUser.getFirstName().toUpperCase() + ".\n Your account creation was successful.");
        userResponse.setAccountNumber("Your account number is ");

    }
}
