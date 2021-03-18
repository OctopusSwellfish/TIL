import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

class Solution{
	public static void main(String[] args) throws IOException {
		File file = new File("word.txt");

		StringBuilder sb = new StringBuilder();
		FileReader reader = new FileReader(file);
		
		int cur = 0;
		while((cur = reader.read())!= -1) {
			sb.append((char)cur);
		}
		String title = sb.toString();
		
		String[] total = title.split(", ");
		sb = new StringBuilder();
		sb.append("insert into nouns (nouns) values ");
		for(int i=0; i<total.length; ++i) {
			if('ㄱ' <= total[i].charAt(0) && total[i].charAt(0) <='ㅎ') continue;
			sb.append("('").append(total[i]).append("')");
			if(i!=total.length-1) {
				sb.append(", ").append('\n');
			}
			else sb.append(';');
		}
		String finalString = sb.toString();
		
		
		OutputStream output = new FileOutputStream("nounsSql.sql");
		byte[] byteArr = finalString.getBytes();
		output.write(byteArr);
	}
	

}
