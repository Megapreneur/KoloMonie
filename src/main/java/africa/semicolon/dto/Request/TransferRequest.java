package africa.semicolon.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferRequest {
    private String senderAccountNumber;
    private String password;
    private String receiverAccountNumber;
    private int amount;


}
