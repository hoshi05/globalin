package page;

public class PageRowResult {
	
	private int rowStartNumber; // �� �������� ��µǴ� ROWNUM ���� ��  [���� ù��° �� ��ȣ]
	private int rowEndNumber; // �� ��������  ��µǴ� ROWNUM ������ �� [���� ������ �� ��ȣ] 
	
	
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
