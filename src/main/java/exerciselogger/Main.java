package exerciselogger;

import java.util.HashMap;
import java.util.Map;

import exerciselogger.JobLogger.TypesLogs;
import exerciselogger.model.OptionsLogger;

public class Main {
	
	public static void main(String[] args) {
		
		Map<String, String> param = new HashMap<>();

		param.put("userName", "acselx");
		param.put("password", "ac666ac");
		param.put("url", "jdbc:sqlite:C:\\BaseDatos\\sqllite\\util.db");
		param.put("logFile", "C:/proyectos/logFile.txt");
		String resultado;
		try {
			OptionsLogger optionsLogger = new OptionsLogger();
			optionsLogger.setOptionLogToDatabase(false);
			optionsLogger.setOptionLogToFile(true);
			optionsLogger.setOptionLogToConsole(false);
			JobLogger jobLogger = new JobLogger(optionsLogger, param);
			jobLogger.init();
			jobLogger.logMessage("hola", TypesLogs.TYPE_MESSAGE);
			jobLogger.logMessage("    s", TypesLogs.TYPE_ERROR);
			jobLogger.logMessage("yo", TypesLogs.TYPE_WARNING);
			jobLogger.logMessage(null, TypesLogs.TYPE_ERROR);
			resultado = "OK";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}