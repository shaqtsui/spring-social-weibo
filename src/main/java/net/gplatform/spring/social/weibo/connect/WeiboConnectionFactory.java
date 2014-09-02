package net.gplatform.spring.social.weibo.connect;

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

import org.springframework.social.connect.support.OAuth2ConnectionFactory;


public class WeiboConnectionFactory extends OAuth2ConnectionFactory<Weibo> {

	public WeiboConnectionFactory(String consumerKey, String consumerSecret) {
		super("weibo", new WeiboServiceProvider(consumerKey, consumerSecret), new WeiboAdapter());
	}

}
