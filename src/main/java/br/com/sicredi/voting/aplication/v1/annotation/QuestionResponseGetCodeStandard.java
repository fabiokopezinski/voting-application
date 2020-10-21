package br.com.sicredi.voting.aplication.v1.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.http.MediaType;

import br.com.sicredi.voting.aplication.v1.domain.dto.response.QuestionResponse;
import br.com.sicredi.voting.aplication.v1.exception.BusinessException.BusinessExceptionBody;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Target({ ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Retorna as pautas existentes", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,schema = @Schema(implementation = QuestionResponse.class))),
		@ApiResponse(responseCode = "400", description = "J� possui cadastro",content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,schema = @Schema(implementation = BusinessExceptionBody.class))),
		@ApiResponse(responseCode = "500", description = "Sistema indispon�vel",content=@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)) })
@Operation(summary = Constants.MEETING_AGENDA_LIST_SUMMARY, description = Constants.MEETING_AGENDA_LIST_DESCRIPTION)
public @interface QuestionResponseGetCodeStandard {

}
