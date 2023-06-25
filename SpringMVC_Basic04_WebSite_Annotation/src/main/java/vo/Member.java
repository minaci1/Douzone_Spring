package vo;

import java.util.Date;
import lombok.Data;


@Data
public class Member {
	private String uid;
	private String pwd;
	private String name;
	private String gender;
	private String birth;
	private String isLunar;
	private String cPhone;
	private String email;
	private String habit;
	private Date   regDate;
  
}
