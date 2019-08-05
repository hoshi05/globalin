package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.memoDAO;
import dao.memoImpl;
import model.Memo;
import page.PageManager;
import page.PageSQL;

@WebServlet(name = "MemoController", 
urlPatterns= {"/memo_input","/memo_save","/memo_list","/memo_detail",
			"/memo_update","/memo_delete","/memo_search","/memo_req_list"}) //���� �̸��� Ŭ���� �̸����� ��./ urlâ�� �߸�, ��Ʈ�ѷ��� �ۼ��Ǿ������ �����ϰ� ����
public class MemoController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
		
		/*		System.out.println("doGet() ȣ���");
		
		RequestDispatcher rd = req.getRequestDispatcher("/jsp/memo/memoForm.jsp");
		rd.forward(req, resp);
			*/
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
		
			/*	System.out.println("doPost() ȣ���"); //ȭ�鿡 �Էµ� ���� Request.parameter�� ���� �� ����.
		req.setCharacterEncoding("utf-8"); // �ѱ۷� �ۼ��ص� �������ʰ� ����.
		
		memoDAO dao = new memoImpl();
		Memo memo = new Memo();
		
		memo.setName(req.getParameter("name"));
		memo.setAge(Integer.parseInt(req.getParameter("age")));
		
		boolean result = dao.insert(memo);
		
		System.out.println(result);
		
		System.out.println(req.getParameter("name")); // name�Ӽ��� �Ӽ����� �Ķ���ͷ� ������.
		System.out.println(req.getParameter("age"));*/
		
	}
	
	
	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		
		System.out.println(uri);
		
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);
		
		req.setCharacterEncoding("utf-8");
		
		if(action.equals("memo_input")) {
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/memo/memoForm.jsp");
			rd.forward(req, resp);
		
		}else if(action.equals("memo_save")) {
			req.setCharacterEncoding("utf-8"); 
			
			memoDAO dao = new memoImpl();
			Memo memo = new Memo();
			
			memo.setName(req.getParameter("name"));
			memo.setAge(Integer.parseInt(req.getParameter("age")));
			
			boolean result = dao.insert(memo);
			
			System.out.println(result);
			
			System.out.println(req.getParameter("name"));
			System.out.println(req.getParameter("age"));
			
			resp.sendRedirect("memo_req_list?reqPage=1");
			
		}else if(action.equals("memo_list")) {
			memoDAO dao = new memoImpl();
			List<Memo> memoList = dao.selectAll();
			
			req.setAttribute("memos", memoList); //�ڹٿ��� ȭ������ ���� �� ���.req.setAttribute(ȭ�鿡�� ����� �̸�, ȭ������ ���������ϴ� ������)
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/memo/memoList.jsp");
			rd.forward(req, resp);
			
			for(Memo memo : memoList) {
			System.out.println(memo);
			}			
		}else if(action.equals("memo_detail")) {
			
			int memoid = Integer.parseInt(req.getParameter("memoid"));
			
			memoDAO dao = new memoImpl();
			Memo memo = dao.selectByMemoId(memoid);
			
			System.out.println(memo);
			
			req.setAttribute("memo", memo);
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/memo/memodetail.jsp");
			rd.forward(req, resp);	
			
		}else if(action.equals("memo_update")) {
			
			Memo memo = new Memo();	
			memo.setMemoid(Integer.parseInt(req.getParameter("memoid")));
			memo.setName(req.getParameter("name"));
			memo.setAge(Integer.parseInt(req.getParameter("age")));
					
			memoDAO dao = new memoImpl();
			boolean result = dao.update(memo);
				
			resp.sendRedirect("memo_list");			
				
		}else if(action.equals("memo_delete")) {
		
			int memoid = Integer.parseInt(req.getParameter("memoid"));
				
			memoDAO dao = new memoImpl();
			boolean memo = dao.deleteByMemoId(memoid);
			
			System.out.println(memo);
			
			resp.sendRedirect("memo_list");
			
		}else if(action.equals("memo_search")) {
			String name = req.getParameter("name");
			
			memoDAO dao = new memoImpl();
			List<Memo> memoList = dao.selectByMemoName(name);
			
			req.setAttribute("memos", memoList);
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/memo/memoList.jsp");
			rd.forward(req, resp);
			
		}else if(action.equals("memo_req_list")) {
			int requestPage = Integer.parseInt(req.getParameter("reqPage"));
			
			PageManager pm = new PageManager(requestPage);
			
			memoDAO dao = new memoImpl();
			List<Memo> memos = dao.selectAll(pm.getPageRowResult().getRowStartNumber(), pm.getPageRowResult().getRowEndNumber());
		
			req.setAttribute("memos", memos);
			req.setAttribute("pageGroupResult", pm.getPageGroupResult(PageSQL.MEMO_SELECT_ALL_COUNT));
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/memo/memoList.jsp");
			rd.forward(req, resp);
		}
	}//process()
}// class
