package net.gplatform.spring.social.weibo.api.impl;

/*
 * #%L
 * spring-social-weibo
 * %%
 * Copyright (C) 2013 - 2014 Shark Xu
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */

import net.gplatform.spring.social.weibo.api.Weibo;
import weibo4j.Account;
import weibo4j.Comments;
import weibo4j.Favorite;
import weibo4j.Friendships;
import weibo4j.Place;
import weibo4j.PublicService;
import weibo4j.Reminds;
import weibo4j.Search;
import weibo4j.ShortUrl;
import weibo4j.Suggestion;
import weibo4j.Tags;
import weibo4j.Timeline;
import weibo4j.Trend;
import weibo4j.Users;

public class WeiboTemplate implements Weibo {
	private String accessToken;

	private Account accountOperations;
	private Comments commentsOperations;
	private Favorite favoriteOperations;
	private Friendships friendshipsOperations;
	private Place placeOperations;
	private PublicService publicServiceOperations;
	private Reminds remindsOperations;
	private Search searchOperations;
	private ShortUrl shortUrlOperations;
	private Suggestion suggestionOperations;
	private Tags tagsOperations;
	private Timeline timelineOperations;
	private Trend trendOperations;
	private Users usersOperations;

	public WeiboTemplate(String accessToken) {
		this.accessToken = accessToken;
		init();
	}

	private void init() {
		accountOperations = new Account();
		accountOperations.setToken(accessToken);
		commentsOperations = new Comments();
		commentsOperations.setToken(accessToken);
		favoriteOperations = new Favorite();
		favoriteOperations.setToken(accessToken);
		friendshipsOperations = new Friendships();
		friendshipsOperations.setToken(accessToken);
		placeOperations = new Place();
		placeOperations.setToken(accessToken);
		publicServiceOperations = new PublicService();
		publicServiceOperations.setToken(accessToken);
		remindsOperations = new Reminds();
		remindsOperations.setToken(accessToken);
		searchOperations = new Search();
		searchOperations.setToken(accessToken);
		shortUrlOperations = new ShortUrl();
		shortUrlOperations.setToken(accessToken);
		suggestionOperations = new Suggestion();
		suggestionOperations.setToken(accessToken);
		tagsOperations = new Tags();
		tagsOperations.setToken(accessToken);
		timelineOperations = new Timeline();
		timelineOperations.setToken(accessToken);
		trendOperations = new Trend();
		trendOperations.setToken(accessToken);
		usersOperations = new Users();
		usersOperations.setToken(accessToken);
	}

	@Override
	public boolean isAuthorized() {
		return accessToken != null;
	}

	@Override
	public Account accountOperations() {
		return accountOperations;
	}

	@Override
	public Comments commentsOperations() {
		return commentsOperations;
	}

	@Override
	public Favorite favoriteOperations() {
		return favoriteOperations;
	}

	@Override
	public Friendships friendshipsOperations() {
		return friendshipsOperations;
	}

	@Override
	public Place placeOperations() {
		return placeOperations;
	}

	@Override
	public PublicService publicServiceOperations() {
		return publicServiceOperations;
	}

	@Override
	public Reminds remindsOperations() {
		return remindsOperations;
	}

	@Override
	public Search searchOperations() {
		return searchOperations;
	}

	@Override
	public ShortUrl shortUrlOperations() {
		return shortUrlOperations;
	}

	@Override
	public Suggestion suggestionOperations() {
		return suggestionOperations;
	}

	@Override
	public Tags tagsOperations() {
		return tagsOperations;
	}

	@Override
	public Timeline timelineOperations() {
		return timelineOperations;
	}

	@Override
	public Trend trendOperations() {
		return trendOperations;
	}

	@Override
	public Users usersOperations() {
		return usersOperations;
	}

}
