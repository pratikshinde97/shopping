package com.example.shopping.common;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@Data
@Accessors(chain = true)
public class BaseEntity implements Serializable{

	private static final long serialVersionUID = 7442096420121476686L;
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	@Column(name="ID", updatable = true, length = 200)
	protected String id;


}
