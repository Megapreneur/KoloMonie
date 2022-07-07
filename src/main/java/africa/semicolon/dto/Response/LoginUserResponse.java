package africa.semicolon.dto.Response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserResponse {
    private String message;
    private String firstName;
    private String lastName;
    private String accountNumber;
    private int balance;
}
