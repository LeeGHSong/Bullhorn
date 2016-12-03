import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import customTools.DbBullhorn;
import customTools.DbUser;
import model.Bhpost;

import java.util.Date;
import model.Bhuser;

public class dBBullhornTests {

	@Test
	public void test() {
		assertTrue(1==1);

	}

	@Test
	 public void getAllPostsTest() {
	 try {

	 ArrayList<Bhpost> posts = (ArrayList<Bhpost>) DbBullhorn.AllPosts();
	 System.out.println(posts.get(1).getPosttext());
	 assertTrue(posts.get(1).getPosttext().length()>0);

	 } catch (ClassNotFoundException | SQLException e) {
	 
	 e.printStackTrace();
	 }
	 }

	@Test
	 public void addPostTest(){
	 java.util.Date d = new java.util.Date();
	 java.sql.Date postdate = new java.sql.Date(d.getTime());
	 String posttext = "This is a test2";
	 int userid = 2;
	 
	 System.out.println(DbBullhorn.insert(postdate, posttext, userid));
	 assertEquals(DbBullhorn.insert(postdate, posttext, userid),1);
	 }

	@Test
	public void dateTest(){
		Bhuser profileUser = null;
		profileUser = DbUser.getUser(1);
		System.out.println(profileUser.getBhuserid());
		System.out.println(profileUser.getJoindate());
	}
}
