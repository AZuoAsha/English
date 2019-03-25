package cdut.cn.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cdut.cn.serve.WordServce;
import cdut.cn.serve.impl.WordServceImpl;

/**
 * Servlet implementation class WordsServlet
 */
@WebServlet("/WordsServlet")
public class WordsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	WordServce ws=new WordServceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		    System.out.println("调用了。。。。");
		    //response.getWriter().println("这是结果");
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
            queryWords(request,response);
        
	}

	
	private void queryWords(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String edition = request.getParameter("edition");
        String section=request.getParameter("section");
        String book=request.getParameter("book");
        System.out.println("section = "+section+"  book = "+book);
        String json="";
        if(section==null){
        	String  sql="select * from word where book="+"'"+book+"'"+"group by section";
        	int count=ws.queryUnitNum(sql);
        	  try {
      			response.getWriter().println(count);
      		} catch (IOException e) {
      			// TODO Auto-generated catch block
      			e.printStackTrace();
      		}
        }else{
        	String sql2="select * from word where book="+"'"+book+"'"+" and section="+"'"+section+"'";
        	json=ws.queryBySQL(sql2);
        	  try {
      			response.getWriter().println(json);
      			response.setCharacterEncoding("utf-8");
      		} catch (IOException e) {
      			// TODO Auto-generated catch block
      			e.printStackTrace();
      		}
        }
      
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
