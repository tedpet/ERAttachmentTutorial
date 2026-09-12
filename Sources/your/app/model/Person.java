package your.app.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.webobjects.eocontrol.EOEditingContext;

public class Person extends _Person {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(Person.class);

	public void init(EOEditingContext ec) {
		super.init(ec);

		LOG.debug("initializing a Person");
	}

}
