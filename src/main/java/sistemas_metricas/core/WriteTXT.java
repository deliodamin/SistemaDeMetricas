package sistemas_metricas.core;
import java.io.FileWriter;
import java.io.PrintWriter;

public class WriteTXT {
	
public void WriteArchive (String valor) throws Throwable{
	
	    FileWriter arq = new FileWriter("c:\\TEMP\\Alertas.txt");
	    PrintWriter gravarArq = new PrintWriter(arq);
	    gravarArq.printf(valor);
	    arq.close();
}
	   
}
