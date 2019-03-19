package zhr;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

public class User {
	//用户单个单词的查询
	public String[]  chaxun(TreeMap<String,Integer> word,String s) {
		TreeMap<String,Integer> map1 = new TreeMap<String, Integer>();
		String[] wording= s.split(";");//截取的是用户传来的单词
		
        int i;
        for(i=0; i<wording.length; i++) {
        	for(Entry<String,Integer> entry : word.entrySet()) { 
        		if(wording[i].equals(entry.getKey()))
        		{
        			map1.put(entry.getKey(), entry.getValue());
        			System.out.println(entry.getKey() + "的个数是" + entry.getValue()); 
        			break;
        		}
            } 
        }
		return wording;
		
		
	} 
	public void wuxiao(TreeMap<String,Integer> word   ) {

		//统计该文本所有单词数量及词频数，并能将单词及词频数按字典顺序输出到文件result.txt
		BufferedWriter bw = null;
		try {
			File files = new File("src/zhr/result.txt"); //创建文件
			if (!files.exists()) {
				files.createNewFile();
			}
			FileWriter fw = new FileWriter(files.getAbsoluteFile()); //写入文件
			bw = new BufferedWriter(fw);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
        Iterator<String> it1 = word.keySet().iterator();  //迭代器
        while(it1.hasNext())
        {
        	String key = (String) it1.next();
        	Integer value = word.get(key);
        	
        	try {
				bw.write(key+"="+value+"\n"); //写入的文件
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	
		
		
		
		
	}

}
