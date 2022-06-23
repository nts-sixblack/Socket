package nts.sixblack.socket.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageForm {
    private long userSenderId;
    private long channelId;
    private String content;
}
