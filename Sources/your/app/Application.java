package your.app;

import java.util.TimeZone;

import com.webobjects.foundation.NSTimeZone;

import er.extensions.appserver.ERXApplication;

public class Application extends ERXApplication {
	
	static {
		// Set default time zones
		TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
		NSTimeZone.setDefaultTimeZone(NSTimeZone.getGMT());
	}
	
	public static void main(String[] argv) {
		ERXApplication.main(argv, Application.class);
	}

	public Application() {
		ERXApplication.log.info("Welcome to " + name() + " !");
		/* ** put your initialization code in here ** */
	}
	
	
	
}
