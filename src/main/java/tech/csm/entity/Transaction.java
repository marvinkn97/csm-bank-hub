package tech.csm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="t_transaction_master")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="transaction_id")
	private Integer transactionId;
	
	@Column(name="transaction_date")
	private Date transactionDate;
	
	@Column(name="transaction_type")
	private char transactionType; 
	
	private Double amount;
	
	@ManyToOne()
	@JoinColumn(name="account_no")
	private Account account;

}
