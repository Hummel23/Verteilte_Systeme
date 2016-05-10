package uebung1.parkhaus;

/**
 * Klasse Logger. Loggt alle Exceptions. 
 * @author Saba Kues

 */
public class Logger {
	
	/**
	 * Statische Variable Logger. Kann von allen Klassen angesprochen werden
	 * ohne Objektinstanziierung. 
	 */
	private static Logger instance;


	/**
	 * Parameterloser Konstruktor
	 */
	private Logger() {
	}

	/**
	 * Gibt die statische Logger-Variable zurück, bzw. 
	 * erstellt sie falls sie noch nicht existiert. 
	 * 
	 * @return Logger
	 */
	public static Logger getInstance() {
		if (Logger.instance == null)
			Logger.instance = new Logger();
		return instance;
	}

	/**	
	 * Loggt die im Parameter mitgegebene Information, mit dem Loglevel info.
	 * 
	 * @param to_log Information (String)
	 */
	public void info(String to_log) {
		log("Info", to_log);
	}

	/**
	 * Loggt den im Parameter mitgegebenen Fehler, mit dem Loglevel error.
	 * @param to_log Fehlermeldung (String)
	 */
	public void error(String to_log) {
		log("Error", to_log);
	}

	/**
	 * @param level der Exception (z.b. "error", "info") (String)
	 * @param to_log info über die Exception (String)
	 */
	private void log(String level, String to_log) {
		System.out.println(level + ": " + to_log);
	}

}
