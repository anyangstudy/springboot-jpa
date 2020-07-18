package org.hdcd.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@EqualsAndHashCode(of="groupCode")
public class CodeGroup {

	@Id
	private String groupCode;
	
	private String groupName;
	private String useYn = "Y";
	
	@CreationTimestamp
	private Date regDate;
	@UpdateTimestamp
	private Date updDate;
	
}
