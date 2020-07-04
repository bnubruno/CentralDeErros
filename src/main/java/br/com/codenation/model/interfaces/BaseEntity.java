package br.com.codenation.model.interfaces;

public interface BaseEntity<ID> {
    ID getId();
    void setId(ID id);
}
