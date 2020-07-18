package org.hdcd.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(of="memberDetailNo")
@ToString
@Entity
@Table(name="member_detail")
public class MemberDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_detail_no")
	private Long memberDetailNo;
	
	private String userName;
	private String email;
	
	@CreationTimestamp
	private Date regDate;
	@UpdateTimestamp
	private Date updDate;
	
	@OneToOne
	@JoinColumn(name = "user_no")
	private Member member;
	
}
