package org.hdcd.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@IdClass(UserItemId.class)
public class UserItem {
	
	@Id
	@ManyToOne
	@JoinColumn(name = "user_no")
	private Member member;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "item_no")
	private Item item;
	
	private int amount;

	@CreationTimestamp
	private Date regDate;
	@UpdateTimestamp
	private Date updDate;
	
}
