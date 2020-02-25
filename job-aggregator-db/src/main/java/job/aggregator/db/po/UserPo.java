package job.aggregator.db.po;

import job.aggregator.common.models.enums.Sex;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CO_USER")
@Getter
@Setter
@ToString(exclude = "id")
@EqualsAndHashCode
public class UserPo extends AbstractPo {

    private final static long  serialVersionUID = 1L;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "AGE")
    private Byte age;

    @Column(name = "BIRTH_DATE", nullable = false)
    private LocalDateTime birthDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "SEX")
    private Sex sex;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "SO_USER_ADDRESS",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ADDRESS_ID")
    )
    private Set<AddressPo> addresses = new HashSet<>();
}
