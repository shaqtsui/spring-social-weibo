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


import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.social.support.ClientHttpRequestFactorySelector;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WeiboOAuth2Template extends OAuth2Template {

	private static final Log logger = LogFactory.getLog(WeiboOAuth2Template.class.getName());

	public WeiboOAuth2Template(String clientId, String clientSecret, String authorizeUrl, String accessTokenUrl) {
		super(clientId, clientSecret, authorizeUrl, accessTokenUrl);
	}

	@Override
	protected RestTemplate createRestTemplate() {
		RestTemplate restTemplate = new RestTemplate(ClientHttpRequestFactorySelector.getRequestFactory());
		HttpMessageConverter<?> messageConverter = new FormHttpMessageConverter() {

			private final ObjectMapper objectMapper = new ObjectMapper();

			@Override
			public boolean canRead(Class<?> clazz, MediaType mediaType) {
				return true;
			}

			@Override
			public MultiValueMap<String, String> read(Class<? extends MultiValueMap<String, ?>> clazz, HttpInputMessage inputMessage)
					throws IOException, HttpMessageNotReadableException {

				TypeReference<Map<String, ?>> mapType = new TypeReference<Map<String, ?>>() {
				};
				LinkedHashMap<String, ?> readValue = objectMapper.readValue(inputMessage.getBody(), mapType);
				LinkedMultiValueMap<String, String> result = new LinkedMultiValueMap<String, String>();
				for (Entry<String, ?> currentEntry : readValue.entrySet()) {
					result.add(currentEntry.getKey(), currentEntry.getValue().toString());
				}
				return result;
			}
		};

		restTemplate.setMessageConverters(Collections.<HttpMessageConverter<?>> singletonList(messageConverter));
		return restTemplate;
	}

	@Override
	@SuppressWarnings("unchecked")
	protected AccessGrant postForAccessGrant(String accessTokenUrl, MultiValueMap<String, String> parameters) {
		MultiValueMap<String, String> response = getRestTemplate().postForObject(accessTokenUrl, parameters, MultiValueMap.class);
		String expires = response.getFirst("expires_in");
		String accessToken = response.getFirst("access_token");
		if (logger.isDebugEnabled()) {
			logger.debug("access token value = " + accessToken);
		}
		return new AccessGrant(accessToken, null, null, expires != null ? Long.valueOf(expires) : null);
	}

}
