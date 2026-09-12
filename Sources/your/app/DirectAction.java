package your.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WORequest;

import er.extensions.appserver.ERXDirectAction;

import your.app.components.Main;
import your.app.model.Person;

public class DirectAction extends ERXDirectAction {
	
	private static final Logger LOG = LoggerFactory.getLogger(DirectAction.class);

	public DirectAction(WORequest request) {
		super(request);
	}

	@Override
	public WOActionResults defaultAction() {
		return pageWithName(Main.class.getName());
	}
}
