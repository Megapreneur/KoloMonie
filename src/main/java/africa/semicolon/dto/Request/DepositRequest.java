package africa.semicolon.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DepositRequest {
//    private String firstName;
//    private String lastName;
    private String accountNumber;
    private int amount;
}
