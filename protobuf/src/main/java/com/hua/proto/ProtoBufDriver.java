/**
 * 描述: 
 * ProtoBufDriver.java
 * @author	qye.zheng
 *  version 1.0
 */
package com.hua.proto;

import java.io.File;

import com.hua.util.CommandUtil;
import com.hua.util.ProjectUtil;
import com.hua.util.StringUtil;

/**
 * 描述: ProtoBuf - 驱动器
 * @author  qye.zheng
 * ProtoBufDriver
 */
public class ProtoBufDriver
{
	
	private static final String PROTO_PATH = "/src/main/resources/proto";
	
	/**
	 * 
	 * 环境: 本地安装了protoc
	 * 
	 * proto目录: src/main/resources/proto
	 * 
	 * 输出java原码目录: src/main/java
	 * 
	 */
	
	/**
	 * 构造方法
	 * 描述: 
	 * @author qye.zheng
	 */
	private ProtoBufDriver()
	{
	}
	
	/**
	 * 
	 * @description 
	 * @param filename 文件名，例如 Xx.proto
	 * @return
	 * @author qianye.zheng
	 */
	public static final boolean run(final String filename)
	{
		final StringBuilder command = StringUtil.getBuilder();
		boolean flag = false;
		try
		{
			String cmd = null;
			final String projectPath = ProjectUtil.getProjectRootPath();
			command.append("protoc");
			command.append(" -I=" + projectPath + PROTO_PATH);
			command.append(" --java_out=" + projectPath + "/src/main/java ");
			command.append(projectPath + PROTO_PATH + "/" + filename);
			command.append(" --experimental_allow_proto3_optional");
			cmd =  command.toString();
			cmd = uniform(cmd);
			System.out.println("执行指令: " + cmd);
			final String result = CommandUtil.execute(cmd);
			System.out.println("执行返回信息: " + result);
			flag = true;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return flag;
	}
	
	/**
	 * 
	 * @description 统一路径，本地化分隔符
	 * @param path
	 * @return
	 * @author qianye.zheng
	 */
	private static final String uniform(final String path) {
		if (path.contains("\\")) { // windows系统
			
			// 斜杆替换为反斜杠
			return path.replace("/", "\\");
		}
		
		return path;
	}
	
}
