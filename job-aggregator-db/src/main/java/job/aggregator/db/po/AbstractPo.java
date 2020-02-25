package job.aggregator.db.po;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;

@MappedSuperclass
public class AbstractPo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PK")
    @SequenceGenerator(sequenceName = "SEQ_PK", allocationSize = 1, name = "SEQ_PK")
    private Long id;
}
