package br.com.developeralexandresantos.santander_dev_week.exception.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Detalhes do erro retornado pela API")
public class ErrorResponse {

    @Schema(description = "Mensagem explicando o motivo do erro", example = "Recurso não encontrado")
    private String message;

    @Schema(description = "Código HTTP correspondente ao erro", example = "404")
    private int status;

    public ErrorResponse() {}

    public ErrorResponse(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
