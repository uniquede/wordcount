package zhr;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

public class User {
	//�û��������ʵĲ�ѯ
	public String[]  chaxun(TreeMap<String,Integer> word,String s) {
		TreeMap<String,Integer> map1 = new TreeMap<String, Integer>();
		String[] wording= s.split(";");//��ȡ�����û������ĵ���
		
        int i;
        for(i=0; i<wording.length; i++) {
        	for(Entry<String,Integer> entry : word.entrySet()) { 
        		if(wording[i].equals(entry.getKey()))
        		{
        			map1.put(entry.getKey(), entry.getValue());
        			System.out.println(entry.getKey() + "�ĸ�����" + entry.getValue()); 
        			break;
        		}
            } 
        }
		return wording;
		
		
	} 
	public void wuxiao(TreeMap<String,Integer> word   ) {

		//ͳ�Ƹ��ı����е�����������Ƶ�������ܽ����ʼ���Ƶ�����ֵ�˳��������ļ�result.txt
		BufferedWriter bw = null;
		try {
			File files = new File("src/zhr/result.txt"); //�����ļ�
			if (!files.exists()) {
				files.createNewFile();
			}
			FileWriter fw = new FileWriter(files.getAbsoluteFile()); //д���ļ�
			bw = new BufferedWriter(fw);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
        Iterator<String> it1 = word.keySet().iterator();  //������
        while(it1.hasNext())
        {
        	String key = (String) it1.next();
        	Integer value = word.get(key);
        	
        	try {
				bw.write(key+"="+value+"\n"); //д����ļ�
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	
		
		
		
		
	}

}
