import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest {
	public static void main(String[] args) {
		try {
			//oracle jdbc driver load
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Connection
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","ora_user","hong");
			
			System.out.println("연결완료");
			
			conn.setAutoCommit(false); //수동 commit 설정
			
			//Sql문을 생성하는 객체
			Statement stmt = conn.createStatement();
			
			//insert, update, delete 포함
			//stmt.executeUpdate("insert into student values('K202002', '홍길동', '국문학과')");
			//stmt.execute("update student set name='홍길돈' where id= 'K202002'");
			stmt.execute("delete from student where id='K202001'");
			//select
			ResultSet rs = stmt.executeQuery("select * from student");
			while(rs.next()) {
				System.out.print(rs.getString("id") + '\t');
				System.out.print(rs.getString("name") + '\t');
				System.out.println(rs.getString("depart"));
			}
			
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
