package sistemas_metricas.core;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


public class WriteTXT {
	
public void WriteArchive (String valor) throws Throwable{
	
		File file = new File("c:\\TEMP\\Alertas.txt");
	
		BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
		writer.write(valor);
		writer.flush();
		writer.close();

}
	   
}
