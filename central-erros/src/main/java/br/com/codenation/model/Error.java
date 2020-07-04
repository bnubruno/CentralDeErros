package br.com.codenation.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import br.com.codenation.commons.EnvironmentEnum;
import br.com.codenation.commons.LevelEnum;
import br.com.codenation.model.interfaces.IModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "log")
@Table(indexes = {@Index(name = "idx_title", columnList = "title"),
		@Index(name = "idx_archived", columnList = "archived"),
		@Index(name = "idx_level", columnList = "level"),
		@Index(name = "idx_environment", columnList = "environment")})
public class Error extends AbstractAuditingEntity implements IModel<UUID> {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private UUID id;

	@NotNull
	private String title;

	@NotNull
	private String details;

	@NotNull
	@ManyToOne
	private Application application;

	@Column(columnDefinition = "boolean default false")
	private Boolean archived = false;

	@ManyToOne
	private User user;

	@NotNull
	@Enumerated(EnumType.STRING)
	private LevelEnum level;

	@NotNull
	@Enumerated(EnumType.STRING)
	private EnvironmentEnum environment;

}