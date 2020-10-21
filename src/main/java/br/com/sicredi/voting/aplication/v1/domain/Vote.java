package br.com.sicredi.voting.aplication.v1.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.sicredi.voting.aplication.v1.domain.dto.response.VoteResponse;
import br.com.sicredi.voting.aplication.v1.domain.enums.VoteEnumeration;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Entity
@EqualsAndHashCode(callSuper = false, of = "voteId")
@Builder
@Table(name = "TB_VOTE")
public class Vote implements DomainEntity<VoteResponse> {

	@Id
	@Column(name = "CD_VOTE", nullable = false, columnDefinition = "NUMERIC(9)")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vote_seq")
	@SequenceGenerator(name = "vote_seq", allocationSize = 1)
	private Long voteId;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private VoteEnumeration vote;

	@ManyToOne(optional = false)
	@JoinColumn(name = "CD_ASSOCIADO", referencedColumnName = "CD_ASSOCIADO", insertable = false, updatable = false)
	private Associate associate;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "CD_PAUTA", referencedColumnName = "CD_PAUTA", insertable = false, updatable = false)
	private Question question;

	@Override
	public VoteResponse toDTO() {
		return VoteResponse.builder().associate(this.associate.toDTO()).voteId(this.voteId).vote(this.vote).build();
	}
}
