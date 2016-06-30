package sistemas_metricas.core;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class WriteTXT {
	
	
	
public void WriteArchive (String valor) throws Throwable{
	
		File file = new File("c:\\TEMP\\Alertas.txt");
	
		BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
		writer.write(valor);
		writer.flush();
		writer.close();

}

	public String ReadArchive () throws Throwable{
	
	File file = new File("c:\\TEMP\\Alertas.txt");

	BufferedReader br = new BufferedReader(new FileReader(file));
	String sCurrentLine = "";
	String acc = "";
	while ((sCurrentLine = br.readLine()) != null) {
		System.out.println(sCurrentLine);
		acc =acc + sCurrentLine+";";
	}
	
	return acc;

}


}
