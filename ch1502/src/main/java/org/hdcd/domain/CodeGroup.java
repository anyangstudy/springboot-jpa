package org.hdcd.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(of="groupCode")
@ToString(exclude = "codeDetails")
@Entity
public class CodeGroup {

	@Id
	private String groupCode;
	
	private String groupName;
	private String useYn = "Y";
	
	@CreationTimestamp
	private Date regDate;
	@UpdateTimestamp
	private Date updDate;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="group_code")
	private List<CodeDetail> codeDetails;
	
}
