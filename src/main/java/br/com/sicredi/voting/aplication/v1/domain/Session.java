package br.com.sicredi.voting.aplication.v1.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.sicredi.voting.aplication.v1.domain.dto.response.SessionResponse;
import br.com.sicredi.voting.aplication.v1.domain.enums.VoteEnumeration;
import br.com.sicredi.voting.aplication.v1.dto.request.SessionRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
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

	@ManyToOne
	@JoinColumn(name = "CD_PAUTA", referencedColumnName = "CD_PAUTA", insertable = false, updatable = false)
	private Question question;

	@ManyToMany
	private List<Vote> votes;
	
	@PrePersist
	public void prePersist() {
		this.votesYes = 0L;
		this.votesNo =  0L;
	}

	@Override
	public SessionResponse toDTO() {
		return SessionResponse.builder().sessionId(this.sessionId).duration(this.duration)
				.votes(this.votes).votesYes(getYes()).votesNo(getNo()).build();
	}

	public void addQuestion(Question questionRequest) {
		this.question=questionRequest;
	}
	
	public static Session of(SessionRequest session) {
		return Session.builder().votes(new ArrayList<Vote>())
				.duration(session.getDuration())
				.build();
	}
	
	private Long getYes() {
		return votes.stream().filter(v->v.getVote().equals(VoteEnumeration.YES)).count();
	}
	
	private Long getNo() {
		return votes.stream().filter(v->v.getVote().equals(VoteEnumeration.NO)).count();
	}

}
