package com.java.www.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.java.www.dto.Board;

public class BoardDao {

	// db 접근 정보
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	Board bdto;

	int bno, bgroup, bstep, bindent, bhit;
	String id, btitle, bcontent, bfile;
	Timestamp bdate;
	ArrayList<Board> list = new ArrayList<Board>();
	String query;

	// 게시글 모두 가져오기 메소드
	public ArrayList<Board> listSelectAll() {
		try {
			conn = getConnection();
			query = "select * from board01 order by bno desc";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery(); // select 시 사용
			// pstmt.executeUpdate(); // insert, update, delete 시 사용
			while (rs.next()) {
				bno = rs.getInt("bno");
				System.out.println("boardDao bno : " + bno);
				id = rs.getString("id");
				btitle = rs.getString("btitle");
				bcontent = rs.getString("bcontent");
				bdate = rs.getTimestamp("bdate");
				bgroup = rs.getInt("bgroup");
				bstep = rs.getInt("bstep");
				bindent = rs.getInt("bindent");
				bhit = rs.getInt("bhit");
				bfile = rs.getString("bfile");
				list.add(new Board(bno, id, btitle, bcontent, bdate, bgroup, bstep, bindent, bhit, bfile));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	} // listSelectAll

	// 게시글 1개 저장 메소드
	public void listInsert(String btitle, String bcontent) {
		try {
			conn = getConnection(); // 커넥션 메소드 호출
			query = "insert into board01 values(board_seq.nextval,?,?,?,sysdate,board_seq.currval,0,0,0,?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "aaa"); // id
			pstmt.setString(2, btitle); // btitle
			pstmt.setString(3, bcontent); // bcontent
			pstmt.setString(4, ""); // bfile

			// rs = pstmt.executeQuery(); // select 시 사용
			int result = pstmt.executeUpdate(); // insert, update, delete 시 사용
			System.out.println("executeUpdate 결과 : " + result); // 1 : 성공, -1 : 실패
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return;
	} // listInsert

	// board 1개 가져오기 메소드
	public Board selectOne(int bno) {
		Board board = null;
		try {
			conn = getConnection();
			query = "select * from board01 where bno=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery(); // select 시 사용

			while (rs.next()) {
				bno = rs.getInt("bno");
				id = rs.getString("id");
				btitle = rs.getString("btitle");
				bcontent = rs.getString("bcontent");
				bdate = rs.getTimestamp("bdate");
				bgroup = rs.getInt("bgroup");
				bstep = rs.getInt("bstep");
				bindent = rs.getInt("bindent");
				bhit = rs.getInt("bhit");
				bfile = rs.getString("bfile");
				board = new Board(bno, id, btitle, bcontent, bdate, bgroup, bstep, bindent, bhit, bfile);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return board;
	} // selectOne

	// 게시글 1개 삭제하기 메소드
	public void deleteOne(int bno) {
		try {
			conn = getConnection(); // 커넥션 메소드 호출
			query = "delete board01 where bno=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bno); // id
			int result = pstmt.executeUpdate(); // insert, update, delete 시 사용
			System.out.println("delete 결과 : " + result); // 1 : 성공, -1 : 실패
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return;

	} // deleteone

	// 게시글 수정하기 메소드
	public void update(int bno, String btitle, String bcontent, String bfile) {
		try {
			conn = getConnection(); // 커넥션 메소드 호출
			query = "update board01 set btitle=?,bcontent=?, bfile=? where bno=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, btitle);
			pstmt.setString(2, bcontent);
			pstmt.setString(3, bfile);
			pstmt.setInt(4, bno);
			int result = pstmt.executeUpdate(); // insert, update, delete 시 사용
			System.out.println("executeUpdate 결과 : " + result); // 1 : 성공, -1 : 실패
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return;
	} // update

	// -----------------------------
	// 커넥션 풀에서 connection 객체 가져오기 메소드
	public Connection getConnection() {
		Connection connection = null;
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/Oracle");
			connection = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;

	} // getConnection
		// ----------------------------------

}
