package uk.co.umbaska.module.access;

import ch.njol.skript.Skript;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.spi.LoggingEvent;
import uk.co.umbaska.module.access.skript.mysql.ConnectionManager;
import uk.co.umbaska.modules.UmbaskaModule;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;

/**
 * @author Andrew Tran
 */
public class AccessModule extends UmbaskaModule{
    private static AccessModule instance;

    private ConnectionManager connectionManager = new ConnectionManager();

    public static AccessModule getInstance(){
        return instance;
    }

    @Override
    protected void onEnable() {
        instance = this;
        BasicConfigurator.configure(new ConsoleAppender(new Layout() {
            @Override
            public String format(LoggingEvent loggingEvent) {
                if (loggingEvent.getThrowableInformation() != null){
                    Throwable throwable = loggingEvent.getThrowableInformation().getThrowable();
                    throwable.printStackTrace();
                }
                if (loggingEvent.getLevel().isGreaterOrEqual(org.apache.log4j.Level.DEBUG)){
                    return null;
                }
                return String.format("[Umbaska] [Access] %s", loggingEvent.getLevel(), loggingEvent.getMessage());
            }

            @Override
            public boolean ignoresThrowable() {
                return false;
            }

            @Override
            public void activateOptions() {

            }
        }));
        registerSyntaxes();
    }

    public void error(String error, Object... arguments){
        getLogger().warning(String.format(error, arguments));
    }

    public void error(Exception exception, String error, Object... arguments){
        error(error, arguments);
        exception.printStackTrace();
    }

    public void skriptError(String error, Object... arguments){
        Skript.error(String.format("[Umbaska] [AccessModule] " + error, arguments));
    }

    public void skriptError(Exception exception, String error, Object... arguments){
        Skript.error(String.format("[Umbaska] [AccessModule] " + error, arguments));
        exception.printStackTrace();
    }

    public ConnectionManager getConnectionManager() {
        return connectionManager;
    }
}
