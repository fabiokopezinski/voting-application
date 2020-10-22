package br.com.sicredi.voting.aplication.v1.job;

import br.com.sicredi.voting.aplication.v1.service.command.CloseSessionCommandService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class CloseSession implements Runnable {

	private Long sessionId;
	private CloseSessionCommandService service;

	@Override
	public void run() {
		log.info("method=close sessionId={}",sessionId);
		service.close(sessionId);

	}

}
