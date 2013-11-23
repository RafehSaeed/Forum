import java.util.*;

public class Account {

	private String user;
	private String password;
	private ArrayList<Post> myposts;

	public Account(String user, String password) { 
		this.user = user;
		this.password = password;
		myposts = new ArrayList<Post>();
	}
	public String getUser()
	{
		return user;
	}

	public String getPassword()
	{
		return password;
	}
	
	public String getPosts()
	{
		String ph = user+"'s Post History\n";
		Post p;
		
		for(int i=0; i<myposts.size(); i++) {
			p = myposts.get(i);
			if(p instanceof CommentPost) {
				CommentPost cp = (CommentPost) p;
				ph += "\n"+cp.toString();
			} else {
				TopicPost tp = (TopicPost) p;
				ph += "\n"+tp.toString();
			}
		}
		
		return ph;
	}
}
