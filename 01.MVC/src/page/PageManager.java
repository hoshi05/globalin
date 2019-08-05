package page;

public class PageManager {

	private int requestPage;
	
	
	public PageManager(){}
	
	public PageManager(int requestPage) {
		this.requestPage = requestPage;
	}
	
	public PageRowResult getPageRowResult() {
		PageRowResult pageRowResult = new PageRowResult();
		
		//PageRowResult의 객체변수 값 셋팅	
		pageRowResult.setRowStartNumber((requestPage-1)*PageInfo.ROW_COUNT_PRE_PAGE+1); //1  6  11  16
		 //pageRowResult.setRowEndNumber(PageInfo.ROW_COUNT_PRE_PAGE*requestPage-(PageInfo.ROW_COUNT_PRE_PAGE-1));
		pageRowResult.setRowEndNumber(requestPage*PageInfo.ROW_COUNT_PRE_PAGE); //5  10  15  20(데이터의 마지막)
		
		
		return pageRowResult;
	}
	
	public PageGroupResult getPageGroupResult(String sql) {
		PageGroupResult pageGroupResult = new PageGroupResult();
		
		//PageGroupResult의 객체변수 값 셋팅
		int requestPageGroupNumber = (requestPage/PageInfo.SHOW_PAGE_COUNT)+(requestPage%PageInfo.SHOW_PAGE_COUNT>0? 1:0);
		//(requestPage-1)/pageInfo.SHOW_PAGE_COUNT;
		//int requestPageGroupNumber = (int)Math.ceil((double)requestPage/PageInfo.SHOW_PAGE_COUNT);
		
		pageGroupResult.setGroupStartNumber(PageInfo.SHOW_PAGE_COUNT*(requestPageGroupNumber-1)+1);
		//pageGroupResult.setGroupStartNumber(requestPageGroupNumber*PageInfo.SHOW_PAGE_COUNT-(PageInfo.SHOW_PAGE_COUNT-1));
		pageGroupResult.setGroupEndNumber(requestPageGroupNumber*PageInfo.SHOW_PAGE_COUNT);
		
		//총 줄수 가져오기
		PageDAO dao = new PageDAOImple();
		int totalRow = dao.getCount(sql);
		
		// 총 링크개수
		int totalPageNumber = (int)Math.ceil((double)totalRow/PageInfo.ROW_COUNT_PRE_PAGE);
		
		System.out.println(totalPageNumber);
			
		//last페이지 링크값 변경하기
		if(pageGroupResult.getGroupEndNumber() > totalPageNumber) {
			
			pageGroupResult.setGroupEndNumber(totalPageNumber);
		}
		
		//before , after 유무
		
		if(pageGroupResult.getGroupStartNumber() == 1) {
			
			pageGroupResult.setBeforePage(false);	
		}
		
		if(pageGroupResult.getGroupEndNumber() == totalPageNumber) {
			
			pageGroupResult.setAfterPage(false);
		}
		
		
		pageGroupResult.setSelectPageNumber(requestPage);
		
		
		return pageGroupResult;
		
	}
	
	
	
	public static void main(String[] args) {
/*		PageManager pagemanager = new PageManager(5);
		pagemanager.getPageRowResult().getRowStartNumber();
		pagemanager.getPageRowResult().getRowEndNumber();
		
		System.out.println(pagemanager.getPageRowResult().getRowStartNumber());
		System.out.println(pagemanager.getPageRowResult().getRowEndNumber());
				
		pagemanager.getPageGroupResult().getGroupStartNumber();
		pagemanager.getPageGroupResult().getGroupEndNumber();
		
		System.out.println(pagemanager.getPageGroupResult().getGroupStartNumber());
		System.out.println(pagemanager.getPageGroupResult().getGroupEndNumber());	*/
		
		
		
	}	
}
