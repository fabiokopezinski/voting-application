package br.com.sicredi.voting.aplication.v1.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.domain.AbstractAggregateRoot;

import br.com.sicredi.voting.aplication.v1.domain.dto.response.AssociateResponse;
import br.com.sicredi.voting.aplication.v1.dto.request.AssociateRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false,of="associateId")
@Builder
@Table(name = "TB_ASSOCIADO")
public class Associate extends AbstractAggregateRoot<Associate> implements DomainEntity<AssociateResponse> {

	@Id
	@Column(name = "CD_ASSOCIADO", nullable = false, columnDefinition = "NUMERIC(9)")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "associate_seq")
    @SequenceGenerator(name = "associate_seq", allocationSize = 1)
	private Long associateId;

	@Column(length = 15, nullable = false)
	private String cpf;

	public static Associate of(AssociateRequest request) {
		return Associate.builder().cpf(request.getCpf()).build(); 
	}

	@Override
	public AssociateResponse toDTO() {
		return AssociateResponse.builder().associateId(this.associateId).cpf(this.cpf).build();
	}
}
