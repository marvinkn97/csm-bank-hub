package tech.csm.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BankVO {
	private String bankId;
	private String ifscCode;
	private String bankName;

}
