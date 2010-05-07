package com.reposinet.moreq2

import java.util.Date
import java.util.UUID
import scala.reflect.BeanProperty

/**
	Every object within MoReq2 has the following attributes:<p/>
	<ul>
	<li>A unique ID (automatically generated)</li>
	<li>A title (name)</li>
	<li>A description</li>
	<li>A parent object (optional)</li>
	</ul>
*/
trait CoreAttributes {

	// Every object
	@BeanProperty
	val id: String = UUID.randomUUID.toString()

	@BeanProperty
	var title: String = ""
		
	@BeanProperty
	var description: String = ""
		
	//var parent: Option[Container] = None
	
	//TODO Automatically assign the current user
	//TODO I want this: val createdBy: RMUser (or RMPrincipal) = Context.currentUser()
	//var createdBy: Option[RMUser] = None

	//TODO Automatically assign the current date/time
	//TODO I want this: val createdOn: Date = Context.currentDate()
	@BeanProperty
	var createdOn: Option[Date] = None

	// TODO - Allow a 'original' creator/creation date for imported objects?
	@BeanProperty
	var originallyCreatedBy: Option[String] = None

	@BeanProperty
	var originallyCreatedOn: Option[Date] = None

	// Allow object to be used as a template for creating other objects
	@BeanProperty
	var isTemplate: Boolean = false

	//TODO hashcode/digest
	//byte[] digest = new byte[Whirlpool.DIGESTBYTES];

  	//TODO Cross-references
	//private List<RMCrossReference> crossReferencs;

}
