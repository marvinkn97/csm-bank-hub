package tech.csm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="t_account_master")
public class Account {
	
	@Id
	@Column(name = "account_no")
	private String accountNo;
	
	private String name;
	
	private String email;
	
	@Column(name = "phone_no")
	private String phoneNo;
	
	@Column(name = "account_type")
	private String accountType;
	
	private Double balance;
	
	@ManyToOne()
	@JoinColumn(name="bank_id")
	private Bank bank;

}
