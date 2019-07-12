/**
 * 版权声明：XXX公司
 * 
 */
package 刘文杰homework_old.hmk_0626_prj1;

import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class ImgDownloadThread implements Runnable{
	
	private Teacher teacher;
	
	public ImgDownloadThread(Teacher teacher) {
		this.teacher=teacher;
	}

	@Override
	public void run() {
		File path=new File("./pic");
		if(!path.exists()) {
			path.mkdir();
		}
		String name=String.format("%s.jpg", teacher.getName());
		try {
			BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(new File(path,name)));
			byte[] data=new OkHttpClient.Builder().readTimeout(120, TimeUnit.SECONDS).build()
					.newCall(new Request.Builder().url(teacher.getPicUrl()).build()).execute().body().bytes();
			bos.write(data);			
			bos.close();
			System.out.println("Thread:"+Thread.currentThread().getName()+" Download "+name+" Finished");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
