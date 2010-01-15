package com.jpc.rms.moreq2

import java.util.Date
import com.eaio.uuid.UUID

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
	val id: String = new UUID().toString()
	
	var title: String = ""
	var description: String = ""
	//var parent: Option[RMObject] = None
	
	//TODO Automatically assign the current user
	//TODO I want this: val createdBy: RMUser (or RMPrincipal) = Context.currentUser()
	//var createdBy: Option[RMUser] = None

	//TODO Automatically assign the current date/time
	//TODO I want this: val createdOn: Date = Context.currentDate()
	var createdOn: Option[Date] = None

	// TODO - Allow a 'original' creator/creation date for imported objects?
	var originallyCreatedBy: Option[String] = None
	var originallyCreatedOn: Option[Date] = None

	// Allow object to be used as a template for creating other objects
	var isTemplate: Boolean = false

	//TODO hashcode/digest
	//byte[] digest = new byte[Whirlpool.DIGESTBYTES];

  	//TODO Cross-references
	//private List<RMCrossReference> crossReferencs;

}
