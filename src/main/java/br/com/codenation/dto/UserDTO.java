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
public class UserDTO implements IDTO {
    private UUID id;
    private String name;
    private String email;
    private String token;
    private Boolean active;
    private String createdAt;
    private String updatedAt;
}
