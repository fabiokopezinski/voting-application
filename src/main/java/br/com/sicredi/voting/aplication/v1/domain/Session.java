package br.com.sicredi.voting.aplication.v1.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.sicredi.voting.aplication.v1.domain.dto.response.SessionResponse;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Entity
@EqualsAndHashCode(callSuper = false, of = "sessionId")
@Builder
@Table(name = "TB_SESSAO")
public class Session implements DomainEntity<SessionResponse> {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "voting_session_seq")
	@SequenceGenerator(name = "voting_session_seq", allocationSize = 1)
	private Long sessionId;

	@Column(name = "DURACAO", nullable = false)
	private Integer duration;

	@Column(name = "VOTO_SIM", nullable = true)
	private Long votesYes;

	@Column(name = "VOTO_NAO", nullable = true)
	private Long votesNo;

	@ManyToMany
	private List<Vote> votes;

	@Override
	public SessionResponse toDTO() {
		return SessionResponse.builder().sessionId(this.sessionId).duration(this.duration).votesYes(this.votesYes)
				.votesNo(this.votesNo).votes(this.votes).build();
	}

}
