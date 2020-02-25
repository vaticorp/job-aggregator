package job.aggregator.db.po;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CO_ADDRESS")
@Setter
@Getter
@EqualsAndHashCode
@ToString(exclude = "id")
public class AddressPo extends AbstractPo {

    private final static long  serialVersionUID = 1L;

    @Column(name = "CITY", nullable = false)
    private String city;

    @Column(name = "STREET", nullable = false)
    private String street;

    @Column(name = "HOUSE", nullable = false)
    private Short house;

    @Column(name = "FLAT")
    private Short flat;

    @Column(name = "housing")
    private Short housing;

    @Column(name = "ZIP_CODE")
    private Integer zipCode;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "SO_USER_ADDRESS",
            joinColumns = @JoinColumn(name = "ADDRESS_ID"),
            inverseJoinColumns = @JoinColumn(name = "USER_ID")
    )
    private Set<UserPo> users = new HashSet<>();
}
