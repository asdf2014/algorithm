package com.yore.medium;

import javax.print.attribute.HashDocAttributeSet;
import java.util.*;

/**
 * @author Yore
 * @date 2021/11/10 14:40
 * @description
 */
public class Number355 {
}

class Twitter {
    private static int timestamp = 0;
    private HashMap<Integer, User> userMap = new HashMap<>();

    private static class Tweet {
        private int tweetId;
        private int timestamp;
        private Tweet next;

        public Tweet(int tweetId, int timestamp) {
            this.tweetId = tweetId;
            this.timestamp = timestamp;
            next = null;
        }
    }

    private static class User {
        private int userId;
        public Set<Integer> followed;
        public Tweet head;

        public User(int userId) {
            followed = new HashSet<>();
            this.userId = userId;
            this.head = null;
            follow(userId);
        }

        public void follow(int userId) {
            followed.add(userId);
        }

        public void unfollow(int userId) {
            if (userId != this.userId) {
                followed.remove(userId);
            }
        }

        public void post(int tweetId) {
            Tweet twt = new Tweet(tweetId, timestamp);
            timestamp++;
            twt.next = head;
            head = twt;
        }
    }

    public Twitter() {

    }

    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }
        userMap.get(userId).post(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if (!userMap.containsKey(userId)) {
            return res;
        }
        Set<Integer> users = userMap.get(userId).followed;
        PriorityQueue<Tweet> priorityQueue = new PriorityQueue<>(users.size(), (a, b) -> (b.timestamp - a.timestamp));

        for(int id : users){
            Tweet tweet = userMap.get(id).head;
            if(tweet == null){
                continue;
            }
            priorityQueue.add(tweet);
        }

        while(!priorityQueue.isEmpty()){
            if(res.size() == 10){
                break;
            }
            Tweet twt = priorityQueue.poll();
            res.add(twt.tweetId);
            if(twt.next!=null) {
                priorityQueue.add(twt.next);
            }
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            userMap.put(followerId, new User(followerId));
        }
        if (!userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new User(followeeId));
        }
        userMap.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId)) {
            userMap.get(followerId).unfollow(followeeId);
        }
    }
}
