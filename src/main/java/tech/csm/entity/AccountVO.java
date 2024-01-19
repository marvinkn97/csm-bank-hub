package tech.csm.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountVO {
	private String accountNo;
	private String name;
	private String email;
	private String phoneNo;
	private String accountType;
	private BankVO bankVO;
	private String balance;
}
