/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.gplatform.spring.social.weibo.connect;

import net.gplatform.spring.social.weibo.api.Weibo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;

import weibo4j.model.User;
import weibo4j.model.WeiboException;

public class WeiboAdapter implements ApiAdapter<Weibo> {
	private static final Logger LOG = LoggerFactory.getLogger(WeiboAdapter.class);

	@Override
	public boolean test(Weibo api) {
		try {
			api.accountOperations().getAccountPrivacy();
			return true;
		} catch (WeiboException e) {
			LOG.debug("", e);
			return false;
		}
	}

	@Override
	public void setConnectionValues(Weibo api, ConnectionValues values) {
		try {
			String uid = api.accountOperations().getUid().toString();
			User user = api.usersOperations().showUserById(uid);
			values.setProviderUserId(user.getId() + "");
			values.setDisplayName(user.getScreenName());
			values.setProfileUrl(user.getUrl());
			values.setImageUrl(user.getAvatarLarge());
		} catch (WeiboException e) {
			LOG.error("error setConnectionValues", e);
		}
	}

	@Override
	public UserProfile fetchUserProfile(Weibo api) {
		try {
			String uid = api.accountOperations().getUid().toString();
			User user = api.usersOperations().showUserById(uid);
			return new UserProfileBuilder().setName(user.getName()).setUsername(uid).build();
		} catch (WeiboException e) {
			LOG.error("error fetchUserProfile", e);
		}
		return null;

	}

	@Override
	public void updateStatus(Weibo api, String message) {
		try {
			api.timelineOperations().UpdateStatus(message);
		} catch (WeiboException e) {
			LOG.error("error updateStatus", e);
		}
	}

}
