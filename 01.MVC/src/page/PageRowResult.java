package page;

public class PageRowResult {
	
	private int rowStartNumber; // 한 페이지에 출력되는 ROWNUM 시작 값  [제일 첫번째 줄 번호]
	private int rowEndNumber; // 한 페이지에  출력되는 ROWNUM 마지막 값 [제일 마지막 줄 번호] 
	
	
	public int getRowStartNumber() {
		return rowStartNumber;
	}
	public void setRowStartNumber(int rowStartNumber) {
		this.rowStartNumber = rowStartNumber;
	}
	public int getRowEndNumber() {
		return rowEndNumber;
	}
	public void setRowEndNumber(int rowEndNumber) {
		this.rowEndNumber = rowEndNumber;
	}
	
	
	
}
