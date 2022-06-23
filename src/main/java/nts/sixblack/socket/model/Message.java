package nts.sixblack.socket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String message;

    @ManyToOne
    @JoinColumn(name = "userChannelId")
    private UserChannel userChannel;

    @ManyToOne
    @JoinColumn(name = "channelId")
    private Channel channel;
}
