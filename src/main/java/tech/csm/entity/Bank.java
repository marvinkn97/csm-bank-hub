package tech.csm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="t_bank_master")
public class Bank implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6164118246919213026L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bank_id")
	private Integer bankId;
	
	@Column(name="ifsc_code")
	private String ifscCode;
	
	@Column(name="bank_name")
	private String bankName;
}
