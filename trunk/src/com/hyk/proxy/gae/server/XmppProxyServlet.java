package com.hyk.proxy.gae.server;

import java.io.IOException;
import java.io.NotSerializableException;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import javax.servlet.http.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.appengine.api.urlfetch.HTTPRequest;
import com.google.appengine.api.urlfetch.HTTPResponse;
import com.google.appengine.api.urlfetch.URLFetchServiceFactory;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.appengine.api.xmpp.JID;
import com.google.appengine.api.xmpp.Message;
import com.google.appengine.api.xmpp.MessageBuilder;
import com.google.appengine.api.xmpp.SendResponse;
import com.google.appengine.api.xmpp.XMPPService;
import com.google.appengine.api.xmpp.XMPPServiceFactory;
import com.hyk.compress.Compressor;
import com.hyk.compress.gz.GZipCompressor;
import com.hyk.compress.sevenzip.SevenZipCompressor;
import com.hyk.proxy.gae.common.HttpRequestExchange;
import com.hyk.proxy.gae.common.HttpResponseExchange;
import com.hyk.proxy.gae.common.XmppMeaageUtil;
import com.hyk.proxy.gae.common.XmppMeaageUtil.HykProxyXmppRequest;
import com.hyk.proxy.gae.server.core.Launcher;
import com.hyk.serializer.HykSerializer;
import com.hyk.serializer.Serializer;
import com.hyk.serializer.StandardSerializer;
import com.hyk.util.buffer.ByteArray;
import com.hyk.util.codec.Base64;

@SuppressWarnings("serial")
public class XmppProxyServlet extends HttpServlet {
	protected Logger								logger			= LoggerFactory.getLogger(getClass());

	
	private static final int MSG_SIZE = 10280;
	private static final int RETRY = 10;
	protected void sendMessage(JID fromJid, String body, int seq, int sessionID)
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("[").append(sessionID).append("]");
		buffer.append("[").append(seq).append("]").append(body);
		XMPPService xmpp = XMPPServiceFactory.getXMPPService();
		Message msg = new MessageBuilder().withRecipientJids(fromJid)
		.withBody(buffer.toString()).build();

		//if (xmpp.getPresence(fromJid).isAvailable()) 
		{
			int retry = RETRY;
			SendResponse status = xmpp.sendMessage(msg);
			while(status.getStatusMap().get(fromJid) != SendResponse.Status.SUCCESS && retry-- > 0);
			//messageSent = (status.getStatusMap().get(fromJid) == SendResponse.Status.SUCCESS);
		}
//		else
//		{
//			log.warning("%%%%From is not available!");
//		}
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		XMPPService xmpp = XMPPServiceFactory.getXMPPService();
		Message message = xmpp.parseMessage(req);
		
		if(logger.isInfoEnabled())
		{
			logger.info("Process message from " + message.getFromJid());
		}
		
		try
		{
			Launcher.channel.processXmppMessage(message);
		}
		catch(Throwable e)
		{
			logger.warn("Failed to process message", e);
		}
		
//		JID fromJid = message.getFromJid();
//		
//		String body = message.getBody();
//		try {
//			HykProxyXmppRequest xmppReq = XmppMeaageUtil.parseRequest(body);
//			ByteArray buffer = Base64.base64ToByteArrayBuffer(xmppReq.body);
//			ByteArray rawRes = FatchServiceWrapper.fetch(buffer);
//			String msgBody = Base64.byteArrayBufferToBase64(rawRes);
//			int size = msgBody.length();
//			String sent = null;
//			int seq = 1;
//			while(size > MSG_SIZE)
//			{
//				sent = msgBody.substring(0, MSG_SIZE);
//				sendMessage(fromJid,sent,seq, xmppReq.sessionId);  
//				msgBody = msgBody.substring(MSG_SIZE);
//				size = msgBody.length();
//				seq++;
//			}
//			if(msgBody.length() > 0)
//			{
//				sendMessage(fromJid,msgBody, seq, xmppReq.sessionId);
//			}
//			sendMessage(fromJid, "finish", 0-seq, xmppReq.sessionId);
//
//		} catch (Throwable e) {
//			log.log(Level.WARNING, "Exception:", e);
//			sendMessage(fromJid, Arrays.toString(e.getStackTrace()), 0, -1);
//
//		}

	}
}