import java.util.*;
public class Forum {

 String name;
 ArrayList<TopicPost> tppost;
 ArrayList<Account> users;

 public Forum(String name) { 
  this.name = name ;
  tppost = new ArrayList<TopicPost> ();
 }
 /* Adds a User to the forum */
 public void addUser(Account useraccount)
 {
 users.add(useraccount);
  
 }
 /*Searches for a user added to the forum */
 private int searchUser(int id, int start, int end) {
  if((end-start) < 0)
   return -1;

  int mid = (end-start)/2;
  Account us = users.get(mid);

  if(id == us.getID()) {
   return mid;
  } else if (id > us.getID()) {
   return searchTopic(id, mid+1, end);
  } else {
   return searchTopic(id, start, mid-1);
  }
 }
 /* Adds a topic to the forum */
 public void addTopic(TopicPost topic) {
  tppost.add(topic);
 }

 /* Deletes a topic from the forum */
 public boolean deleteTopic(int id){
  //Need to call search user to check if the client trying to delete the topic is himself
  int start = 0;
  int end = tppost.size() - 1;

  int index = searchTopic(id, start, end);
  if(index == -1) {
   return false;
  } else {
   tppost.remove(index);
   return true;
  }
 }

 /* Search for a topic using binary search */
 private int searchTopic(int id, int start, int end) {
  if((end-start) < 0)
   return -1;

  int mid = (end-start)/2;
  TopicPost tp = tppost.get(mid);

  if(id == tp.getID()) {
   return mid;
  } else if (id > tp.getID()) {
   return searchTopic(id, mid+1, end);
  } else {
   return searchTopic(id, start, mid-1);
  }
 }

 /* Returns the topic specified by the id */
 public String viewTopic(int id){
  int start = 0;
  int end = tppost.size() - 1;
  int index = searchTopic(id, start, end);
  
  if(index == -1) {
   return "No topic matches this id.";
  } else {
   return tppost.get(index).toString();
  }
 }

 /* Prints out the name of all the topics in the database*/
 public String viewAllTopics()
 {
   if (tppost.isEmpty())//checks if list is empty
        
      {return "No topics have been added to the forum";}
   else{
  String topics = name+"\n";
  for(int i=0; i<tppost.size(); i++) {
   topics += "ID:" + tppost.get(i).getID() +" "+  tppost.get(i).getTitle() + "\n";
  }
  
  return topics;
   }
 }
}
