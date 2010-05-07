package com.reposinet.persistence

import java.lang.{Class => JavaClass}
import java.util.ArrayList
import org.restlet.resource.ClientResource
import org.restlet.resource.ResourceException
import com.reposinet.moreq2._

object Test {

	def main(args: Array[String]) {

	// Get a UUID from CouchDB
	//val uuidResource = new ClientResource("http://localhost:5984/_uuids")
	//val idHelper = uuidResource.get(classOf[CouchDbId])

	// Create a new scheme
	var scheme1 = new Scheme()
	scheme1.title = "Scheme 1"
	scheme1.description = "Scheme 1 description"

	// Persist it somewhere on the cloud
	val scheme1Resource = new ClientResource("http://localhost:5984/rms/" + scheme1.id)
	scheme1Resource.put(scheme1)

    // Retrieve the updated version
	// TODO - figure out how to deserialize Scala Option values
    //scheme1 = scheme1Resource.get(classOf[Scheme])
    //println(scheme1.id + ": " + scheme1.title)
    }

}