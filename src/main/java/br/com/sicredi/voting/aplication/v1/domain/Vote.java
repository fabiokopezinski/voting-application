package br.com.sicredi.voting.aplication.v1.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.sicredi.voting.aplication.v1.domain.dto.request.VoteRequest;
import br.com.sicredi.voting.aplication.v1.domain.dto.response.VoteResponse;
import br.com.sicredi.voting.aplication.v1.domain.enums.VoteEnumeration;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
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

	@OneToOne(optional = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "CD_ASSOCIADO", referencedColumnName = "CD_ASSOCIADO")
	private Associate associate;

	
	@ManyToOne(optional = false)
	@JoinColumn(name = "CD_SESSAO")
	private Session session;
	
	public static Vote of(VoteRequest response,Associate associate,Session session) {
		return Vote.builder().vote(response.getVote()).associate(associate).session(session).build();
	}

	@Override
	public VoteResponse toDTO() {
		return VoteResponse.builder().associate(this.associate.toDTO()).vote(this.vote).build();
	}
}
