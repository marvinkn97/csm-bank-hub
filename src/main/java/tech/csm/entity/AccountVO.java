package tech.csm.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountVO {
	private String accountNo;
	private String name;
	private String email;
	private String phoneNo;
	private String accountType;
	private BankVO bankVO;
	private String balance;
}
