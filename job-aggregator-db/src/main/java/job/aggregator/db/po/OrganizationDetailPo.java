package job.aggregator.db.po;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CO_ORGANIZATION_DETAIL")
@Getter
@Setter
@EqualsAndHashCode
@ToString(exclude = "ID")
public class OrganizationDetailPo extends AbstractPo {

    private static final long serialVersionUID = 1L;

    @OneToOne
    @JoinColumn(name = "PHYSICAL_ADDRESS_ID", updatable = true, nullable = false)
    private AddressPo physicalAddress;

    @OneToOne
    @JoinColumn(name = "JURIDICAL_ADDRESS_ID", updatable = true)
    private AddressPo juridicalAddress;

    //ИНН
    @Column(name = "TAXPAYER_IDENTIFICATION_NUMBER", nullable = false)
    private Integer taxpayerIdentificationNumber;

    //КПП
    @Column(name = "TAX_REGISTRATION_REASON_CODE")
    private Integer taxRegistrationReasonCode;

    //ОГРП
    @Column(name = "PRIMARY_STATE_REGISTRATION_NUMBER")
    private Integer primaryStateRegistrationNumber;

    @Column(name = "CORRESPONDENT_ACCOUNT")
    private Long correspondentAccount;
}
