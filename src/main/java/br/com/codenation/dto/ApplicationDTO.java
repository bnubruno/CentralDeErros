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
public class ApplicationDTO implements IDTO {

    private UUID id;
    private String name;
    private String token;
    private String createdAt;
    private String updatedAt;

}
