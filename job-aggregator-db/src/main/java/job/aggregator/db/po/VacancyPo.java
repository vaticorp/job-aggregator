package job.aggregator.db.po;

import job.aggregator.common.models.enums.VacancyStatus;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "CO_ADDRESS")
@Setter
@Getter
@EqualsAndHashCode
@ToString(exclude = "id")
public class VacancyPo extends AbstractPo {

    private static final long serialVersionUID = 1L;

    @Column(name = "ADDED_AT")
    private LocalDateTime addedAt;

    @Column(name = "POSITION")
    private String position;

    @OneToOne
    @JoinColumn(name = "ORGANIZATION_ID", updatable = true)
    private OrganizationPo organization;

    @Enumerated(EnumType.STRING)
    @Column(name = "VACANCY_STATUS")
    private VacancyStatus vacancyStatus;
}
