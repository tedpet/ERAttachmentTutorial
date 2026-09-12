package your.app.model.migrations;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXMigrationTable;
import er.extensions.migration.ERXModelVersion;

public class Tutorial0 extends ERXMigrationDatabase.Migration {
  @Override
  public NSArray<ERXModelVersion> modelDependencies() {
    return null;
  }
  
  @Override
  public void downgrade(EOEditingContext editingContext, ERXMigrationDatabase database) throws Throwable {
    // DO NOTHING
  }

  @Override
  public void upgrade(EOEditingContext editingContext, ERXMigrationDatabase database) throws Throwable {
    ERXMigrationTable personTable = database.newTableNamed("Person");
    personTable.newIntegerColumn("erAttachmentID", true);
    personTable.newStringColumn("firstName", 255, true);
    personTable.newIntegerColumn("id", false);
    personTable.newStringColumn("lastName", 255, true);
    personTable.create();
    personTable.setPrimaryKey("id");

    personTable.addForeignKey("erAttachmentID", "ERAttachment", "id");
  }
}