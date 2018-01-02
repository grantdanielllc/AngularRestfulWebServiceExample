package com.aca.dao;

import java.util.ArrayList;
import java.util.List;
import com.aca.model.Friend;

public class FriendsDao {

	private static List<Friend> friends = new ArrayList<Friend>();
	
	static {
		
		friends.add(new Friend("1","Daniel","Lazenby",
				"https://stocklandmartelblog.files.wordpress.com/2013/07/nino-muncc83oz_hugh-jackman_page_3.jpg"));
		friends.add(new Friend("2","Scarlet","Johansson",
				"http://static.comicvine.com/uploads/original/11111/111117228/4087439-2415305600-Scarl.jpg"));
		friends.add(new Friend("3","Rodger","Federer",
				"http://static5.businessinsider.com/image/534ff37cecad044b58f1c953-480/roger-federer.jpg"));
		friends.add(new Friend("4","Grant","Lazenby",
				"http://www.atpworldtour.com/en/news/www.atpworldtour.com/-/media/images/news/2017/05/12/15/26/nadal-madrid-2017-friday.jpg"));
		friends.add(new Friend("5","Katelyn","Lazenby",
				"https://upload.wikimedia.org/wikipedia/commons/thumb/4/4b/Keys_WM17_%283%29_%2836050849651%29.jpg/800px-Keys_WM17_%283%29_%2836050849651%29.jpg"));
		friends.add(new Friend("6","John","McEnroe",
				"https://www.irelandsown.ie/wp-content/uploads/2017/06/mcenroe11.jpg"));
		friends.add(new Friend("7","Bob","Bryan",
				"https://upload.wikimedia.org/wikipedia/commons/thumb/9/95/The_Bryan_brothers_crop.jpg/338px-The_Bryan_brothers_crop.jpg"));
		friends.add(new Friend("8","Stan","Smith",
				"http://images.complex.com/complex/image/upload/t_article_image/cz2qe8jrclrsi82qwyuc.jpg"));
		friends.add(new Friend("9","Sloane","Stephens",
				"https://ssl.c.photoshelter.com/img-get/I0000I97SgTA3Vf0/s/900/900/SLOANE-STEVENS-27062012-3035.jpg"));
	}

	/**
	 * return friends as a collection (e.g. ArrayList of Friend objects)
	 * @return
	 */
	public List<Friend> getFriendsAsList() {		
		List<Friend> friendList = new ArrayList<Friend>();		
		friendList.addAll(FriendsDao.friends);		
		return friendList;		
	}
	
	/**
	 * Find friend by the record Id.
	 * @return
	 */
	public Friend getFriendById(String id) {	 
		Friend myFriend = null;
		
		for (Friend friend : FriendsDao.friends) {
			if (friend.getId().equals(id)) {
				myFriend = friend;
				break;
			}
		}
		
		return myFriend;		
	}
	
	public Friend deleteFriendById(String id) {		
		Friend myFriend = null;		
		int index = -1;
		
		for (Friend friend : FriendsDao.friends) {
			index++;
			if (friend.getId().equals(id)) {				
				break;
			}
		}
		
		if  (index != -1) {
			myFriend = FriendsDao.friends.remove(index);
		}		
		
		return myFriend;		
	}

	public List<Friend> getFriendByLastName(String lastname) {
		
		List<Friend> friendList = new ArrayList<Friend>();
		
		for (Friend friend : FriendsDao.friends) {
			if (friend.getLastName().equalsIgnoreCase(lastname)) {
				friendList.add(friend);
			}
		}
			
		return friendList;		
	}

	public Friend updateFriend(Friend updatedFriend) {
		int index = -1;
		
		for (Friend friend : FriendsDao.friends) {
			index++;
			if (friend.getId().equals(updatedFriend.getId())) {
				break;
			}
		}
		
		if (index != -1) {
			FriendsDao.friends.set(index, updatedFriend);
		}
		return updatedFriend;	
	}
	
}

