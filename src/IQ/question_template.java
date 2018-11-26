package IQ;

public class question_template {

	public String Question ="";
	
	public String op1 ="";
	public String op2 ="";
	public String op3 ="";
	public String op4 ="";
	public String corAns ="";
	
	public String getQuestion() {
		return Question;
	}
	public void setQuestion(String question) {
		Question = question;
	}
	public String getOp1() {
		return op1;
	}
	public void setOp1(String op1) {
		this.op1 = op1;
	}
	public String getOp2() {
		return op2;
	}
	public void setOp2(String op2) {
		this.op2 = op2;
	}
	public String getOp3() {
		return op3;
	}
	public void setOp3(String op3) {
		this.op3 = op3;
	}
	public String getOp4() {
		return op4;
	}
	public void setOp4(String op4) {
		this.op4 = op4;
	}
	public String getCorAns() {
		return corAns;
	}
	public void setCorAns(String corAns) {
		this.corAns = corAns;
	}
	public question_template(String question, String op1, String op2, String op3, String op4, String corAns) {
		super();
		Question = question;
		this.op1 = op1;
		this.op2 = op2;
		this.op3 = op3;
		this.op4 = op4;
		this.corAns = corAns;
	}
	
}
