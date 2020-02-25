package job.aggregator.db.po;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "CO_ORGANIZATION")
@Getter
@Setter
@EqualsAndHashCode
@ToString(exclude = "ID")
public class OrganizationPo extends AbstractPo {

    private static final long serialVersionUID = 1L;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "ORGANIZATION_DETAIL_ID", updatable = true)
    private OrganizationDetailPo organizationDetail;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "VACANCIES_ID", nullable = false)
    private Set<VacancyPo> vacancies;
}
