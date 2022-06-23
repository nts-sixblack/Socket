package nts.sixblack.socket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "channel")
public class Channel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "channel")
    @Cascade(org.hibernate.annotations.CascadeType.REMOVE)
    private List<UserChannel> userChannelList;

    @OneToMany(mappedBy = "channel")
    @Cascade(org.hibernate.annotations.CascadeType.REMOVE)
    private List<Message> messageList;


}
