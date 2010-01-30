/**
 * This file is part of the hyk-proxy project.
 * Copyright (c) 2010 Yin QiWen <yinqiwen@gmail.com>
 *
 * Description: FetchServiceImpl.java 
 *
 * @author qiying.wang [ Jan 25, 2010 | 2:37:31 PM ]
 *
 */
package com.hyk.proxy.gae.server.core.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.appengine.api.urlfetch.HTTPRequest;
import com.google.appengine.api.urlfetch.HTTPResponse;
import com.google.appengine.api.urlfetch.URLFetchServiceFactory;
import com.hyk.proxy.gae.common.HttpRequestExchange;
import com.hyk.proxy.gae.common.HttpResponseExchange;
import com.hyk.proxy.gae.common.service.FetchService;
import com.hyk.proxy.gae.server.core.util.Util;

/**
 *
 */
public class FetchServiceImpl implements FetchService
{
	protected Logger	logger	= LoggerFactory.getLogger(getClass());
	public HttpResponseExchange fetch(HttpRequestExchange req)
	{
		try
		{
			HTTPRequest fetchReq = Util.toHTTPRequest(req);
			HTTPResponse fetchRes = URLFetchServiceFactory.getURLFetchService()
					.fetch(fetchReq);
			return Util.toHttpResponseExchange(fetchRes);
		}
		catch(IOException e)
		{
			logger.error("Faile to fetch", e);
			return null;
		}
	}

}
