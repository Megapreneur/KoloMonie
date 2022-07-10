package africa.semicolon.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WithdrawalRequest {
    private String accountNumber;
    private int amount;
    private String password;


}
