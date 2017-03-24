package cn.com.na.bean;

import java.text.MessageFormat;
import org.apache.log4j.Level;
import org.apache.log4j.spi.LoggingEvent;

/**
 * SNNA logger 类(写文件日志类)
 *@author LIUYONG
 */
public final class SnnaLogger {

	private final org.apache.log4j.Logger logger;

	private SnnaLogger(Class<?> clazz) {
		logger = org.apache.log4j.Logger.getLogger(clazz);
	}

	private SnnaLogger() {
		logger = org.apache.log4j.Logger.getRootLogger();
	}

	public static SnnaLogger getLogger(Class<?> clazz) {
		return new SnnaLogger(clazz);
	}

	public static SnnaLogger getRootLogger() {
		return new SnnaLogger();
	}

	public void trace(Object message) {
		if (logger.isTraceEnabled()) {
			forcedLog(logger, Level.TRACE, message);
		}
	}

	public void trace(Object message, Throwable t) {
		if (logger.isTraceEnabled()) {
			forcedLog(logger, Level.TRACE, message, t);
		}
	}

	public void trace(String pattern, Object... arguments) {
		if (logger.isTraceEnabled()) {
			forcedLog(logger, Level.TRACE, format(pattern, arguments));
		}
	}
	public void trace(String pattern, Throwable t, Object... arguments) {
		if (logger.isTraceEnabled()) {
			forcedLog(logger, Level.TRACE, format(pattern, arguments), t);
		}
	}
	
	public boolean isTraceEnabled(){
		return logger.isTraceEnabled();
	}
	
	public boolean isDebugEnabled() {
	    return logger.isDebugEnabled();
	}
	
	public boolean isInfoEnabled(){
		return logger.isInfoEnabled();
	}
	
	public boolean isWarnEnabled() {
	    return logger.isEnabledFor(Level.WARN);
	}
	
	public boolean isErrorEnabled() {
		return logger.isEnabledFor(Level.ERROR);
    }
	public void debug(Object message) {
		if (logger.isDebugEnabled()) {
			forcedLog(logger, Level.DEBUG, message);
		}
	}

	public void debug(Object message, Throwable t) {
		if (logger.isDebugEnabled()) {
			forcedLog(logger, Level.DEBUG, message, t);
		}
	}

	public void debug(String pattern, Object... arguments) {
		if (logger.isDebugEnabled()) {
			forcedLog(logger, Level.DEBUG, format(pattern, arguments));
		}
	}
	public void debug(String pattern, Throwable t, Object... arguments) {
		if (logger.isDebugEnabled()) {
			forcedLog(logger, Level.DEBUG, format(pattern, arguments), t);
		}
	}

	public void info(Object message) {
		if (logger.isInfoEnabled()) {
			forcedLog(logger, Level.INFO, message);
		}
	}

	public void info(Object message, Throwable t) {
		if (logger.isInfoEnabled()) {
			forcedLog(logger, Level.INFO, message, t);
		}
	}

	public void info(String pattern, Object... arguments) {
		if (logger.isInfoEnabled()) {
			forcedLog(logger, Level.INFO, format(pattern, arguments));
		}
	}
	public void info(String pattern, Throwable t, Object... arguments) {
		if (logger.isInfoEnabled()) {
			forcedLog(logger, Level.INFO, format(pattern, arguments), t);
		}
	}
	public void warn(Object message) {
		if (logger.isEnabledFor(Level.WARN)) {
			forcedLog(logger, Level.WARN, message);
		}
	}

	public void warn(Object message, Throwable t) {
		if (logger.isEnabledFor(Level.WARN)) {
			forcedLog(logger, Level.WARN, message, t);
		}
	}

	public void warn(String pattern, Object... arguments) {
		if (logger.isEnabledFor(Level.WARN)) {
			forcedLog(logger, Level.WARN, format(pattern, arguments));
		}
	}
	public void warn(String pattern, Throwable t, Object... arguments) {
		if (logger.isEnabledFor(Level.WARN)) {
			forcedLog(logger, Level.WARN, format(pattern, arguments), t);
		}
	}

	public void error(Object message) {
		if (logger.isEnabledFor(Level.ERROR)) {
			forcedLog(logger, Level.ERROR, message);
		}
	}

	public void error(Object message, Throwable t) {
		if (logger.isEnabledFor(Level.ERROR)) {
			forcedLog(logger, Level.ERROR, message, t);
		}
	}

	public void error(String pattern, Object... arguments) {
		if (logger.isEnabledFor(Level.ERROR)) {
			forcedLog(logger, Level.ERROR, format(pattern, arguments));
		}
	}
	public void error(String pattern, Throwable t, Object... arguments) {
		if (logger.isEnabledFor(Level.ERROR)) {
			forcedLog(logger, Level.ERROR, format(pattern, arguments), t);
		}
	}

	public void fatal(Object message) {
		if (logger.isEnabledFor(Level.FATAL)) {
			forcedLog(logger, Level.FATAL, message);
		}
	}

	public void fatal(Object message, Throwable t) {
		if (logger.isEnabledFor(Level.FATAL)) {
			forcedLog(logger, Level.FATAL, message, t);
		}
	}

	public void fatal(String pattern, Object... arguments) {
		if (logger.isEnabledFor(Level.FATAL)) {
			forcedLog(logger, Level.FATAL, format(pattern, arguments));
		}
	}
	public void fatal(String pattern, Throwable t, Object... arguments) {
		if (logger.isEnabledFor(Level.FATAL)) {
			forcedLog(logger, Level.FATAL, format(pattern, arguments), t);
		}
	}

	public void assertLog(boolean assertion, String message) {
		if (!assertion) {
			forcedLog(logger, Level.ERROR, message);
		}
	}

	private static void forcedLog(org.apache.log4j.Logger logger, Level level, Object message) {
		logger.callAppenders(new LoggingEvent(FQCN, logger, level, message, null));
	}

	private static void forcedLog(org.apache.log4j.Logger logger, Level level, Object message, Throwable t) {
		logger.callAppenders(new LoggingEvent(FQCN, logger, level, message, t));
	}

	private static String format(String pattern, Object... arguments) {
		return MessageFormat.format(pattern, arguments);
	}

	private static final String FQCN;

	static {
		FQCN = SnnaLogger.class.getName();
	}
}
