// DO NOT EDIT.  Make changes to Person.java instead.
package your.app.model;

import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import java.math.*;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import er.extensions.eof.*;
import er.extensions.foundation.*;

@SuppressWarnings("all")
public abstract class _Person extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Person";

  // Attribute Keys
  public static final ERXKey<String> FIRST_NAME = new ERXKey<String>("firstName");
  public static final ERXKey<String> LAST_NAME = new ERXKey<String>("lastName");
  // Relationship Keys
  public static final ERXKey<er.attachment.model.ERAttachment> THEBIGPHOTO = new ERXKey<er.attachment.model.ERAttachment>("thebigphoto");

  // Attributes
  public static final String FIRST_NAME_KEY = FIRST_NAME.key();
  public static final String LAST_NAME_KEY = LAST_NAME.key();
  // Relationships
  public static final String THEBIGPHOTO_KEY = THEBIGPHOTO.key();

	private static final Logger LOG = LoggerFactory.getLogger(_Person.class);
	
  public Person localInstanceIn(EOEditingContext editingContext) {
    Person localInstance = (Person)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String firstName() {
    return (String) storedValueForKey(_Person.FIRST_NAME_KEY);
  }

  public void setFirstName(String value) {
	_Person.LOG.debug( "updating firstName from {} to {}", firstName(), value);
	takeStoredValueForKey(value, _Person.FIRST_NAME_KEY);
  }

  public String lastName() {
    return (String) storedValueForKey(_Person.LAST_NAME_KEY);
  }

  public void setLastName(String value) {
	_Person.LOG.debug( "updating lastName from {} to {}", lastName(), value);
	takeStoredValueForKey(value, _Person.LAST_NAME_KEY);
  }

  public er.attachment.model.ERAttachment thebigphoto() {
    return (er.attachment.model.ERAttachment)storedValueForKey(_Person.THEBIGPHOTO_KEY);
  }
  
  public void setThebigphoto(er.attachment.model.ERAttachment value) {
    takeStoredValueForKey(value, _Person.THEBIGPHOTO_KEY);
  }

  public void setThebigphotoRelationship(er.attachment.model.ERAttachment value) {

	  _Person.LOG.debug("updating thebigphoto from {} to {}", thebigphoto(), value);
   
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setThebigphoto(value);
    }
    else if (value == null) {
    	er.attachment.model.ERAttachment oldValue = thebigphoto();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _Person.THEBIGPHOTO_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _Person.THEBIGPHOTO_KEY);
    }
  }
  

  public static Person createPerson(EOEditingContext editingContext) {
    Person eo = (Person) EOUtilities.createAndInsertInstance(editingContext, _Person.ENTITY_NAME);    
    return eo;
  }

  public static ERXFetchSpecification<Person> fetchSpec() {
    return new ERXFetchSpecification<Person>(_Person.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Person> fetchAllPersons(EOEditingContext editingContext) {
    return _Person.fetchAllPersons(editingContext, null);
  }

  public static NSArray<Person> fetchAllPersons(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Person.fetchPersons(editingContext, null, sortOrderings);
  }

  public static NSArray<Person> fetchPersons(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Person> fetchSpec = new ERXFetchSpecification<Person>(_Person.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<Person> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static Person fetchPerson(EOEditingContext editingContext, String keyName, Object value) {
    return _Person.fetchPerson(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Person fetchPerson(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Person> eoObjects = _Person.fetchPersons(editingContext, qualifier, null);
    Person eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Person that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Person fetchRequiredPerson(EOEditingContext editingContext, String keyName, Object value) {
    return _Person.fetchRequiredPerson(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Person fetchRequiredPerson(EOEditingContext editingContext, EOQualifier qualifier) {
    Person eoObject = _Person.fetchPerson(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Person that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Person localInstanceIn(EOEditingContext editingContext, Person eo) {
    Person localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }

}
