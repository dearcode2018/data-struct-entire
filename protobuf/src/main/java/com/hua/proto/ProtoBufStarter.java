/**
 * 描述: 
 * ProtoBufStarter.java
 * @author	qye.zheng
 * 
 *  version 1.0
 */
package com.hua.proto;

import org.junit.Test;

/**
 * 描述: ProtoBuf编译-启动器
 * @author  qye.zheng
 * 
 * ProtoBufStarter
 */
public final class ProtoBufStarter
{

	/**
	 * 
	 * 环境: 本地安装了protoc
	 * 
	 * proto目录: src/main/resources/proto
	 * 
	 * 输出java原码目录: src/main/java
	 * 
	 */

	// 启动器模板
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void start()
	{
		/** ===== begin 驱动参数设置  ===== */
		// 设置例子
		String filename = null;
		filename = "Person.proto";
		/** ===== end of 驱动参数设置 ===== */

		// 启动驱动
		ProtoBufDriver.run(filename);
		
	}

}
