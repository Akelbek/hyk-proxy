/**
 * This file is part of the hyk-proxy project.
 * Copyright (c) 2010 Yin QiWen <yinqiwen@gmail.com>
 *
 * Description: AsyncRemoteServiceManager.java 
 *
 * @author yinqiwen [ 2010-5-29 | 04:35:50 PM ]
 *
 */
package org.hyk.proxy.gae.common.rpc.service;

import org.hyk.proxy.gae.common.gae.auth.User;

import com.hyk.rpc.core.RpcCallback;
import com.hyk.rpc.core.annotation.Async;

/**
 *
 */
@Async(RemoteServiceManager.class)
public interface AsyncRemoteServiceManager
{
	public void getFetchService(User user, RpcCallback<FetchService> callback);


	public void getServerVersion(RpcCallback<String> callback);
}
