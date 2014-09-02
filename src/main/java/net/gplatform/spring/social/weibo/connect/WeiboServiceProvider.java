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
import net.gplatform.spring.social.weibo.api.impl.WeiboTemplate;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;

public class WeiboServiceProvider extends AbstractOAuth2ServiceProvider<Weibo> {

	public WeiboServiceProvider(String clientId, String clientSecret) {
		super(getOAuth2Template(clientId, clientSecret));
	}

	private static OAuth2Template getOAuth2Template(String clientId, String clientSecret) {
		OAuth2Template oAuth2Template = new WeiboOAuth2Template(clientId, clientSecret, "https://api.weibo.com/oauth2/authorize",
				"https://api.weibo.com/oauth2/access_token");
		oAuth2Template.setUseParametersForClientAuthentication(true);
		return oAuth2Template;
	}

	public Weibo getApi(String accessToken) {
		return new WeiboTemplate(accessToken);
	}

}
