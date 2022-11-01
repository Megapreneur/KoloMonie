package africa.semicolon.dto.Request;

import africa.semicolon.data.models.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phoneNumber;
    private String occupation;
    private String password;
    private AccountType accountType;
//    private String accountNumber;


}
