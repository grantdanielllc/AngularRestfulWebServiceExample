package com.aca.service;

import java.util.List;

import com.aca.dao.FriendsDao;
import com.aca.model.Friend;

public class FriendsService {

	public List<Friend> getAllFriends() {
		FriendsDao friendsDao = new FriendsDao();
		return friendsDao.getFriendsAsList();
	}

	public Friend getFriendById(String id) {
		FriendsDao friendsDao = new FriendsDao();
		return friendsDao.getFriendById(id);
	}

	public List<Friend> getFriendByLastName(String lastname) {
		FriendsDao friendsDao = new FriendsDao();
		return friendsDao.getFriendByLastName(lastname);
	}

	public Friend deleteFriendById(String id) {
		FriendsDao friendsDao = new FriendsDao();
		return friendsDao.deleteFriendById(id);
	}

	public Friend updateFriend(Friend updatedFriend) {
		FriendsDao friendsDao = new FriendsDao();
		return friendsDao.updateFriend(updatedFriend);
	}
	
	

}
