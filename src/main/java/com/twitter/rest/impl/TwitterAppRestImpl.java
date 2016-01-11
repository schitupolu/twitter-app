package com.twitter.rest.impl;

import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import com.twitter.rest.TwitterAppRest;

public class TwitterAppRestImpl implements TwitterAppRest {

	private final static String CONSUMER_KEY = "cYqE2llitDDCm0SSB4i0gw5f7";
	private final static String CONSUMER_SECRET = "DF0uMnBkPGNVMgF5aCpJQPXlcs3jPTKmYxyGYqwRgaLWkcmchN";
	private final static String ACCESS_KEY = "228585447-qTu7PFFSdsrGxqjZEMMSQtLxqbeSzKdPYGSoRzuF";
	private final static String ACCESS_SECRET = "Q6jtxivpsMVHnw2uSrC9xUCbgXnQl5CYWjBvN8CcEyhDL";

	public List<Status> getTweets(String username, int count, String dateSince,
			String dateUntil) throws Exception {
		List<Status> tweets = null;
		try {
			Twitter twitter = getCoconfig();
			Query query = new Query(username);
			query.setCount(count);
			if (!"null".equals(dateSince)) {
				query.setSince(dateSince);
			}
			query.setUntil(dateUntil);
			QueryResult result = twitter.search(query);
			tweets = result.getTweets();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tweets;
	}

	private static Twitter getCoconfig() {
		Twitter twitterInstance = null;
		try {
			// Twitter Configuration
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true).setOAuthConsumerKey(CONSUMER_KEY)
					.setOAuthConsumerSecret(CONSUMER_SECRET)
					.setOAuthAccessToken(ACCESS_KEY)
					.setOAuthAccessTokenSecret(ACCESS_SECRET);
			TwitterFactory twitterFactory = new TwitterFactory(cb.build());
			twitterInstance = twitterFactory.getInstance();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return twitterInstance;
	}
}
