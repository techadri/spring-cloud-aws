/*
 * Copyright 2013 the original author or authors.
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

package org.elasticspring.messaging.endpoint;

import org.elasticspring.messaging.config.annotation.NotificationSubject;
import org.springframework.core.MethodParameter;

import java.util.HashMap;

/**
 * @author Agim Emruli
 */
public class NotificationSubjectHeaderResolver extends AbstractNotificationMessageHandlerMethodArgumentResolver{

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.getParameterAnnotation(NotificationSubject.class) != null;
	}

	@Override
	protected Object doResolverArgumentFromNotificationMessage(HashMap<String, String> content) {
		return content.get("Subject");
	}
}
