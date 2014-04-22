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

package org.elasticspring.cache.config;

import org.elasticspring.cache.StaticMemcachedFactoryBean;
import org.elasticspring.cache.memcached.MemcachedClientIF;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Agim Emruli
 */
public class StaticMemcachedFactoryBeanTest {

	@Test
	public void getObject_availableClient_returnsConfiguredMemcachedClient() throws Exception {
		// Arrange
		int memcacheServerPort = TestMemcacheServer.startServer();
		StaticMemcachedFactoryBean staticMemcachedFactoryBean = new StaticMemcachedFactoryBean("localhost:" + memcacheServerPort);

		// Act
		staticMemcachedFactoryBean.afterPropertiesSet();
		MemcachedClientIF memcachedClient = staticMemcachedFactoryBean.getObject();

		// Assert
		Assert.assertNotNull(memcachedClient);
		Assert.assertNull(memcachedClient.get("getObject_availableCluster_returnsConfiguredMemcachedClient"));

		memcachedClient.shutdown();

	}

}