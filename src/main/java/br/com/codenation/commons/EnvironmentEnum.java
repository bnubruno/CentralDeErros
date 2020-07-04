package br.com.codenation.commons;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public enum EnvironmentEnum {

    DEVELOPMENT("DEV"),
    HOMOLOGATION("HOM"),
    PRODUCTION("PRD");

    private String description;

}
