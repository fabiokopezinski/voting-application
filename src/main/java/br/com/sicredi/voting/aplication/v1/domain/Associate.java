package br.com.sicredi.voting.aplication.v1.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.sicredi.voting.aplication.v1.domain.dto.response.AssociateResponse;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Entity
@EqualsAndHashCode(callSuper = false,of="associadoId")
@Builder
@Table(name = "TB_ASSOCIADO")
public class Associate implements DomainEntity<AssociateResponse> {

	@Id
	@Column(name = "CD_ASSOCIADO", nullable = false, columnDefinition = "NUMERIC(9)")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "associate_seq")
    @SequenceGenerator(name = "associate_seq", allocationSize = 1)
	private Long associadoId;

	@Column(length = 15, nullable = false)
	private String cpf;
	
	@OneToMany(mappedBy = "associate", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Vote> votes;

	@Override
	public AssociateResponse toDTO() {
		return AssociateResponse.builder().associadoId(this.associadoId).cpf(this.cpf).build();
	}
}
