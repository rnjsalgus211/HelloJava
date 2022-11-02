package co.edu.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {
	private String id;
	private String passwd;
	private String name;
	private String email;
	private String respons;
	
	private String title;
	private String sDate;
	private String eDate;
}
