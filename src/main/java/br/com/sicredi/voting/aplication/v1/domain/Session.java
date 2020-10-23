package br.com.sicredi.voting.aplication.v1.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.domain.AbstractAggregateRoot;

import br.com.sicredi.voting.aplication.v1.domain.dto.request.SessionRequest;
import br.com.sicredi.voting.aplication.v1.domain.dto.response.SessionResponse;
import br.com.sicredi.voting.aplication.v1.domain.enums.SessionStatus;
import br.com.sicredi.voting.aplication.v1.domain.enums.VoteEnumeration;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false, of = "sessionId")
@Builder
@Table(name = "TB_SESSAO")
public class Session extends AbstractAggregateRoot<Session> implements DomainEntity<SessionResponse> {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "voting_session_seq")
	@SequenceGenerator(name = "voting_session_seq", allocationSize = 1)
	@Column(name = "CD_SESSAO", nullable = false)
	private Long sessionId;

	@Column(name = "DURACAO", nullable = false)
	private Integer duration;

	@Setter
	@Column(name = "VOTO_SIM", nullable = true)
	private Long votesYes;

	@Setter
	@Column(name = "VOTO_NAO", nullable = true)
	private Long votesNo;

	@Setter
	@Column(name = "STATUS", nullable = true)
	private SessionStatus status;

	@OneToMany(mappedBy = "session", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Vote> votes;

	@ManyToOne(optional = false)
	@JoinColumn(name = "CD_PAUTA")
	private Question question;

	@OneToOne(optional = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "CD_ASSOCIADO", referencedColumnName = "CD_ASSOCIADO")
	private Associate associate;

	@PrePersist
	public void prePersist() {
		this.votesYes = 0L;
		this.votesNo = 0L;
	}

	@Override
	public SessionResponse toDTO() {
		return SessionResponse.builder().sessionId(this.sessionId).duration(this.duration).votesYes(this.votesYes)
				.votesNo(this.votesNo).build();
	}

	public void addQuestion(Question questionRequest) {
		this.question = questionRequest;
	}

	public void addVotes(Vote vote) {
		this.votes.add(vote);
		if (vote.getVote().equals(VoteEnumeration.YES)) {
			this.votesYes++;
		} else {
			votesNo++;
		}
	}

	public void addAssociate(Associate associate) {
		this.associate = associate;
	}

	public static Session of(SessionRequest session, Question questionRequest) {
		return Session.builder().votes(new ArrayList<Vote>()).duration(session.getDuration()).question(questionRequest)
				.build();
	}

	public Boolean isClosed() {
		return SessionStatus.CLOSED.equals(status);
	}
}
