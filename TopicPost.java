import java.util.*;

public class TopicPost extends Post {

	private String title;
	private ArrayList<CommentPost> cmpost;

	public TopicPost(int id,String date, String text, String user, String title) { 
		super(id,date,text,user);
		this.title = title;
		cmpost = new ArrayList<CommentPost>();
	}

	public String getTitle()
	{
		return title;
	}

	public void addComment(CommentPost comment)
	{
		cmpost.add(comment);
	}

	public boolean removeComment(int id)
	{
		int start = 0;
		int end = cmpost.size() - 1;
		int index = searchComment(id, start, end);
		
		if(index == -1) {
			return false;
		} else {
			cmpost.remove(index);
			return true;
		}
	}
	
	private int searchComment(int id, int start, int end)
	{
		if((end-start) < 0)
			return -1;
		
		int middle = (end - start)/2;
		CommentPost cp = cmpost.get(middle);
		
		if(cp.getID() == id) {
			return middle;
		} else if(cp.getID() < id) {
			return searchComment(id, middle+1, end);
		} else {
			return searchComment(id, start, middle-1);
		}
	}

	public String toString()
	{
		String a = "Topic: "+title+"\n";
		a += super.toString();
		
		return a;
	}
	
	public String getComments() {
		String comments = "";
		
		for(int i=0 ; i < cmpost.size();i++)
		{
			comments += cmpost.get(i).toString()+"\n";
		}
		
		return comments;
	}

}
