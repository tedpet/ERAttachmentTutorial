package your.app.components;

import your.app.DirectAction;
import your.app.model.Person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.eof.ERXEC;

public class PersonDetail extends WOComponent {
	private static final long serialVersionUID = 1L;
	protected Person _aPerson;
	private NSArray<Person> _persons;
	private Person _personItem;
	public EOEditingContext ec = ERXEC.newEditingContext();
	
	private static final Logger LOG = LoggerFactory.getLogger(DirectAction.class);

	public PersonDetail(WOContext context) {
		super(context);
	}

	public Person _aPerson() {
		return _aPerson;
	}

	public void setAPerson(Person aPerson) {
		_aPerson = aPerson;

	}

	@SuppressWarnings("exports")
	public WOComponent toMain() {
		Main nextPage = (Main) pageWithName(Main.class.getName());
		nextPage.setAPerson(null);
		return nextPage;
	}

	/**
	 * @return the personsa
	 */
	public NSArray<Person> persons() {
		return Person.fetchAllPersons(ec);
	}

	/**
	 * @param persons the persons to set
	 */
	public void setPersons(NSArray<Person> persons) {
		_persons = persons;
	}

	/**
	 * @return the personItem
	 */
	public Person personItem() {
		return _personItem;
	}

	/**
	 * @param personItem the personItem to set
	 */
	public void setPersonItem(Person personItem) {
		_personItem = personItem;
	}
}