package cdut.cn.serve.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

import cdut.cn.Word;
import cdut.cn.common.DBTools;
import cdut.cn.serve.WordServce;


public class WordServceImpl implements WordServce {

	Connection conn = null;//表示与特定数据库的连接
   
    @Override
	public String queryBySQL(String sql) {
//    	System.out.println(sql);
    	//sql = "select * from word where book=3a and section = 3";
		if(conn==null)conn = DBTools.connectToDB();
        List<Word> eList = new ArrayList<Word>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
            	Word word = new Word();
//                System.out.println("调用了rs");
                word.setID(rs.getString("ID"));
            	word.setWords(rs.getString("words"));
            	word.setGrade(rs.getString("book"));
            	word.setSection(rs.getString("section"));
            	word.setChinese(rs.getString("chinese"));
               System.out.println("word="+word);
                eList.add(word);
                
            }
//            System.out.println("elist调用了");
            System.out.println("result:  "+eList);
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        finally {
            try{
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            }catch (SQLException sqlEx) { } // ignore
        }
        String json=JSON.toJSONString(eList);
//        System.out.println(json);
        return json;
	}


	@Override
	public int queryUnitNum(String sql) {
		if(conn==null)conn = DBTools.connectToDB();
        List<Word> list = new ArrayList<Word>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
            	Word word = new Word();
//                System.out.println("调用了rs");
                word.setID(rs.getString("ID"));
            	word.setWords(rs.getString("words"));
            	word.setGrade(rs.getString("book"));
            	word.setSection(rs.getString("section"));
            	word.setChinese(rs.getString("chinese"));
               System.out.println(word);
               list.add(word);
                
            }
//            System.out.println("elist调用了");
            System.out.println("result:  "+list);
            System.out.println("list.size()="+list.size());
		
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        finally {
            try{
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            }catch (SQLException sqlEx) { }
        }
	return list.size();
	
	}
	
}