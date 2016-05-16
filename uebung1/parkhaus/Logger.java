package uebung1.parkhaus;

/**
 * Class Logger. For logging information and errors.
 * 
 * @author Saba Kues
 * 
 */
public class Logger {

	/**
	 * Static variable Logger.
	 */
	private static Logger instance;

	/**
	 * Constructor.
	 */
	Logger() {
	}

	/**
	 * Returns the static object variable Logger. 
	 * 
	 * @return Logger
	 */
	public static Logger getInstance() {
		if (Logger.instance == null)
			Logger.instance = new Logger();
		return instance;
	}

	/**
	 * Logs String handed over as parameter with log level 'info'.
	 * 
	 * @param to_log (String)
	 */
	public void info(String to_log) {
		log("Info", to_log);
	}

	/**
	 * Logs String handed over as parameter with log level 'error'.
	 * 
	 * @param to_log (String)
	 */
	public void error(String to_log) {
		log("Error", to_log);
	}

	/**
	 * 
	 * Private method to sysout a String with a certain level. 
	 * @param level (String), i.e. info/error
	 * @param to_log (String)
	 */
	private void log(String level, String to_log) {
		System.out.println(level + ": " + to_log);
	}

}
