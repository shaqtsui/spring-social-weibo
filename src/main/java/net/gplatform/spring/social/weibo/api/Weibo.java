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
package net.gplatform.spring.social.weibo.api;

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

import org.springframework.social.ApiBinding;

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

public interface Weibo extends ApiBinding {

	Account accountOperations();

	Comments commentsOperations();

	Favorite favoriteOperations();

	Friendships friendshipsOperations();

	Place placeOperations();

	PublicService publicServiceOperations();

	Reminds remindsOperations();

	Search searchOperations();

	ShortUrl shortUrlOperations();

	Suggestion suggestionOperations();

	Tags tagsOperations();

	Timeline timelineOperations();

	Trend trendOperations();

	Users usersOperations();
}
