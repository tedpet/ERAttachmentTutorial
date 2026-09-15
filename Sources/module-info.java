module your.app.ERAttachmentTutorial_W8 {
	exports your.app.components;
	exports your.app;
	exports your.app.model.migrations;
	exports your.app.model;

	requires java.sql;
	requires org.slf4j;
	requires org.wocommunity.webobjects.eoaccess;
	requires org.wocommunity.webobjects.eocontrol;
	requires org.wocommunity.webobjects.foundation;
	requires org.wocommunity.webobjects.webobjects;
	requires org.wocommunity.wonder.erattachment;
	requires org.wocommunity.wonder.erextensions;
}