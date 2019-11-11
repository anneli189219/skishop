package com.skishop.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 使用监听器HttpSessionListener接口统计在线人数
 * @author anneli
 * @date 2019年10月21日 下午2:52:13 
 *
 */
@WebListener
public class listener implements HttpSessionListener {
	/* Session创建事件 */
	public void sessionCreated(HttpSessionEvent se) {
		ServletContext ctx = se.getSession().getServletContext();
		Integer num = (Integer) ctx.getAttribute("num");
		if (num == null) {
			num = new Integer(1);
		} else {
			int count = num.intValue();
			num = new Integer(count + 1);
		}
		ctx.setAttribute("num", num);
		System.out.println("在线人数："+ctx.getAttribute("num"));
	}

	/* Session失效事件 */
	public void sessionDestroyed(HttpSessionEvent se) {
		ServletContext ctx = se.getSession().getServletContext();
		Integer num = (Integer) ctx.getAttribute("num");
		if (num == null) {
			num = new Integer(0);
		} else {
			int count = num.intValue();
			num = new Integer(count - 1);
		}
		ctx.setAttribute("num", num);
		System.out.println("在线人数："+ctx.getAttribute("num"));
	}
}