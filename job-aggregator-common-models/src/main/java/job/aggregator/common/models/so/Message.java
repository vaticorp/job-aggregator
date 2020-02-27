package job.aggregator.common.models.so;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Message {
    private MessageCategory type;
    private int code;
    private String description;
    private LocalDateTime timestamp;
}
