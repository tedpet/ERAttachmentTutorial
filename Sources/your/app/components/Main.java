package your.app.components;

import your.app.DirectAction;
import your.app.model.Person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.components.ERXComponent;
import er.extensions.eof.ERXEC;

public class Main extends ERXComponent {
  protected Person _aPerson;
  private NSArray<Person> _persons;
  private Person _personItem;
  public EOEditingContext ec = ERXEC.newEditingContext();
  
	private static final Logger LOG = LoggerFactory.getLogger(Main.class);


  public Main(WOContext context) {
    super(context);
  }

  public Person aPerson() {
    if (_aPerson == null) {
      _aPerson = Person.createPerson(ec);
    } 
    return _aPerson;
  }
  public void setAPerson(Person aPerson) {
    this._aPerson = aPerson;
  }

  public WOComponent saveChanges() {
    ec.saveChanges();
    PersonDetail nextPage = (PersonDetail)pageWithName(PersonDetail.class.getName());
    nextPage.setAPerson(_aPerson);
    return nextPage;
  }
  
  /**
   * @return the persons
   */
  public NSArray<Person> persons() {
	  LOG.debug("returning the persons array (fetchAllPersons)");
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
