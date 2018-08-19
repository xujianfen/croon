package com.atguigu.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class FileUploadServlet
 */
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//瑙ｅ喅post璇锋眰鐨勪贡鐮�
		//request.setCharacterEncoding("utf-8");
		
	/*	//鑾峰彇涓�涓緭鍏ユ祦
		ServletInputStream in = request.getInputStream();
		
		//璇诲彇娴�
		String str = IOUtils.toString(in);
		
		System.out.println(str);*/
		
		
		//鑾峰彇宸ュ巶绫诲疄渚�
		DiskFileItemFactory factory = new DiskFileItemFactory();
		String filenamenew = null;
		
		//鍒涘缓瑙ｆ瀽鍣ㄧ被瀹炰緥
		ServletFileUpload fileUpload = new ServletFileUpload(factory);
		
		//fileUpload閫氳繃璇ュ璞℃潵闄愬埗鏂囦欢鐨勫ぇ灏�
		//璁剧疆褰撴枃浠剁殑澶у皬涓�50KB
		//fileUpload.setFileSizeMax(1024*50);
		
		//璁剧疆澶氫釜鏂囦欢鐨勬�诲ぇ灏忎负300mb
		fileUpload.setSizeMax(1024*1024*300);
		
		try {
			//瑙ｆ瀽request
			List<FileItem> fileItems = fileUpload.parseRequest(request);
			
			//閬嶅巻fileItems锛岃鍙栬〃鍗曠殑淇℃伅
			for (FileItem fileItem : fileItems) {
				
				//鍒ゆ柇褰撳墠琛ㄥ崟椤规槸鍚︽槸涓�涓櫘閫氳〃鍗曢」
				if(fileItem.isFormField()){
					//鑾峰彇灞炴�у悕
					String fieldName = fileItem.getFieldName();
					
					//鑾峰彇灞炴�у��
					String value = fileItem.getString("utf-8");
					
					System.out.println(fieldName+" = "+value);
				}else{
					//濡傛灉鏄枃浠惰〃鍗曢」
					//鑾峰彇鏂囦欢鐨勫ぇ灏�
					long size = fileItem.getSize();
					
					//鍒ゆ柇size鏄惁涓�0
					if(size==0){
						continue;
					}
					
					//鑾峰彇鏂囦欢鐨勭被鍨�
					String contentType = fileItem.getContentType();
					
					//鑾峰彇鏂囦欢鐨勫悕瀛�
					String name = fileItem.getName();
					//鍒ゆ柇name涓槸鍚﹀寘鍚湁璺緞淇℃伅
					if(name.contains("\\")){
						//濡傛灉鍖呭惈鍒欐埅鍙栧瓧绗︿覆
						name = name.substring(name.lastIndexOf("\\")+1);
					}
					
					//鐢熸垚涓�涓猆UID锛屼綔涓烘枃浠跺悕鐨勫墠缂�
					String prefix = UUID.randomUUID().toString().replace("-", "");
					name = prefix+"_"+name;
					
					
					//鑾峰彇琛ㄥ崟椤圭殑灞炴�у悕
					String fieldName = fileItem.getFieldName();
					
					System.out.println("鏂囦欢鐨勫ぇ灏�: "+size);
					System.out.println("鏂囦欢鐨勭被鍨�: "+contentType);
					System.out.println("鏂囦欢鐨勫悕瀛�: "+name);
					System.out.println("琛ㄥ崟椤筺ame灞炴�у悕: "+fieldName);
					
					//鑾峰彇ServletContext瀵硅薄
					ServletContext context = this.getServletContext();
					//鑾峰彇椤圭洰鐨勭湡瀹炶矾寰�
					String path = context.getRealPath("/upload");
					
					//鍒ゆ柇璺緞鏄惁瀛樺湪
					File file = new File(path);
					if(!file.exists()){
						//濡傛灉涓嶅瓨鍦ㄨ璺緞锛屽垯鍒涘缓涓�涓矾寰�
						file.mkdirs();
					}
					
					//灏嗘枃浠跺啓鍏ュ埌纾佺洏涓�
					fileItem.write(new File(path+"/"+name));
					filenamenew= name;
				}
			}
			
			System.out.println(filenamenew);
			//閲嶅畾鍚戝埌涓�涓〉闈�
			//response.sendRedirect(request.getContextPath()+"/success.jsp");
			response.getOutputStream().write(filenamenew.getBytes());
		}catch(FileSizeLimitExceededException e){
			//涓�浣嗘崟鑾峰埌璇ュ紓甯革紝鍒欒鏄庡崟涓枃浠跺ぇ灏忚秴杩囬檺鍒躲��
			//璁剧疆涓�涓敊璇秷鎭�
			response.getOutputStream().write("-1".getBytes());
			//杞彂鍒癷ndex.jsp
//			response.getOutputStream().write(filenamenew.getBytes());
		}catch(SizeLimitExceededException e){
			//涓�浣嗘崟鑾峰埌璇ュ紓甯革紝鍒欒鏄庡崟涓枃浠跺ぇ灏忚秴杩囬檺鍒躲��
			//璁剧疆涓�涓敊璇秷鎭�
			response.getOutputStream().write("-1".getBytes());
			//杞彂鍒癷ndex.jsp
//			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
		catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.getOutputStream().write("-1".getBytes());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.getOutputStream().write("-1".getBytes());
		}
		
		
		
	}

}
