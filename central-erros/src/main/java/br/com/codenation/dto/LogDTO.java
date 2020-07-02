package br.com.codenation.dto;

import br.com.codenation.dto.interfaces.IDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LogDTO implements IDTO {

    private UUID id;
    private String title;
    private String details;
    private UUID applicationId;
    private String applicationName;
    private Boolean archived;
    private UUID userId;
    private String userName;
    private String level;
    private String environment;
    private String createdAt;
    private String updatedAt;
}
