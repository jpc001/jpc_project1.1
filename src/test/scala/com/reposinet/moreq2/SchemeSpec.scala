package com.reposinet.moreq2

import org.scalatest.FeatureSpec
import org.scalatest.GivenWhenThen

import com.reposinet.moreq2._

/** 
 *  This class tests the MoReq2 Classification Scheme class.
 *  
 *  ScalaTest using Scala 2.8 requires ScalaTest version 1.0.1
 *  Maven: org.scalatest:scalatest:jar:1.0.1-for-scala-2.8.0.Beta1-NQRFPT
 *  Download: http://www.scala-tools.org/repo-snapshots/org/scalatest/scalatest/1.0.1-for-scala-2.8.0.Beta1-RC1-SNAPSHOT/
 *  
 *  Note that running "buildr eclipse" from the command line will generate a .classpath and
 *  .project files that conform to the BuildR structure.  However, any artifacts, including
 *  ScalaTest, will be defined with a classpath of "M2_REPO/...".  This variable must be 
 *  defined in Eclipse under Configure Build Path -> Add Variable -> M2_REPO and set it to:
 *  
 *  	<user home directory>/.m2/repository
 *  
 * For example, "E:/Users/Ben/.m2/repository".  Failure to do this will mean Eclipse cannot
 * find the artifacts and report compile errors.
 */
class SchemeSpec extends FeatureSpec with GivenWhenThen {

	feature("3.1.3: The ERMS should allow administrative roles to label each classification scheme with a Title, and Description, and must automatically label each classification scheme with an Identifier.") {
		
		scenario("Create a new scheme") {
		    val title = "Scheme 1"
		    val description = "Sample Scheme #1"
			given("a title '" + title + "' and a description '" + description + "'")
				val scheme1 = new Scheme()
				scheme1.title = title
				scheme1.description = description
			when("the scheme has been created")
			then("the scheme title should be: " + title)
				assert(scheme1.title.compareTo(title) === 0)
			and("the scheme description should be: " + description)
				assert(scheme1.description.compareTo(description) === 0)
			and("the scheme should have a unique identitier")
				assert(Option(scheme1.id) != None)
		}
	}

	feature("3.1.4: The ERMS must be able to support a classification scheme which can represent files and records as being organised in a hierarchy of classes.") {
		scenario("") (pending)
			
		//TODO
		// Create a hierarchical structure of classes with at least two files and records
	}

	feature("3.1.5: The ERMS must allow management of the classification scheme by an administrative role only, subject to requirement 3.1.6.") {
		scenario("") (pending)
			
		//TODO
		// Attempt to 'manage' a scheme as an administrator and a non-administrator
		// Define what scenarios constitute 'manage' (MoReq2 sections 3.1 and 3.4)
	}

	feature("3.1.6: The ERMS should allow management of individual classes by specified user roles and/or by a specified group of users.") {
		scenario("") (pending)
			
		//TODO
		// This seems to be Class testing, not Scheme testing, but we could create the
		// scheme as an Administrator, create somes classes and give authority to a
		// non-admin user then attempt to manage the classes as the non-admin user
	}
	
	feature("3.1.7: The ERMS should not limit the number of levels in the classification scheme hierarchy.") {
		scenario("") (pending)
			
		//TODO
	}
	
	feature("3.1.8: The ERMS must support the creation of a classification scheme at configuration time in readiness for the capture and/or importation of electronic records.") {
		scenario("") (pending)
			
		//TODO
	}
	
	feature("3.1.9: The ERMS must allow the titling mechanism(s) to be defined at configuration time by an administrative role.") {
		scenario("") (pending)
			
		//TODO
	}
	
	feature("3.1.10: The ERMS should allow the input of textual scope notes (also known as descriptions) to all classes, files, sub-files and volumes.") {
		scenario("") (pending)
			
		//TODO
	}
	
	feature("3.1.11: If a formal MoReq2 XML schema has been published, the ERMS must be able to import and export records etc. in a form compliant with that schema.") {
		scenario("") (pending)
			
		//TODO
	}
	
	feature("3.1.12: The ERMS must support the importing of all or parts of a classification scheme, at configuration time or at any other time.") {
		scenario("") (pending)
			
		//TODO
	}
	
	feature("3.1.13: When the ERMS imports all or part of a classification scheme it must allow the import of the associated metadata, retention and disposition schedules and audit trails if these exist.") {
		scenario("") (pending)
			
		//TODO
	}
	
	feature("3.1.14: Where the ERMS imports the metadata of a classification scheme, it must reject any class that does not have a title, and create an exception report for an administrative role listing the classes that were rejected.") {
		scenario("") (pending)
			
		//TODO
	}
	
	feature("3.1.15: Where the ERMS imports the metadata of a classification scheme, the ERMS must assign to each imported class a hierarchical code in one of the following ways, according to an option set by an administrative role:") {
		scenario("") (pending)
			
		//TODO
	}
	
	feature("3.1.16: Where the ERMS imports the metadata and retention and disposition schedules of a classification scheme, it must validate them using the same rules as would be used for the manual creation of the classification scheme (see chapter 12). Where this validation process finds errors (for example the absence of mandatory metadata, or format errors) it must bring these to the attention of the administrative role performing the importation, identifying the metadata involved.") {
		scenario("") (pending)
			
		//TODO
	}
	
	feature("3.1.17: The ERMS should support the export of all or part of a classification scheme.") {
		scenario("") (pending)
			
		//TODO
	}
	
	feature("3.1.18: Where the ERMS supports the export of all or part of a classification scheme this must include associated metadata, an administrative role being able to select which metadata is exported.") {
		scenario("") (pending)
			
		//TODO
	}
	
	feature("3.1.19: Where the ERMS supports the export of all or part of a classification scheme this must include all associated retention and disposition schedules at the option of an administrative role.") {
		scenario("") (pending)
			
		//TODO
	}
	
	feature("3.1.20: Where the ERMS supports the export of all or part of a classification scheme, this must include all or selected audit trail data, the selection to be made by an administrative role.") {
		scenario("") (pending)
			
		//TODO
	}
	
	feature("3.1.21: Where the ERMS supports export (for any of the above requirements) it must use a fully-documented method to relate the entities to each other.") {
		scenario("") (pending)
			
		//TODO
	}
	
	feature("3.1.22: Where the ERMS supports export (for any of the above requirements) it should export the information in XML or equivalent open standardised format.") {
		scenario("") (pending)
			
		//TODO
	}
	
	feature("3.1.23: Where the ERMS supports the copying of all or part of a classification scheme this must include all associated metadata.") {
		scenario("") (pending)
			
		//TODO
	}
	
	feature("3.1.24: Where the ERMS supports the copying of all or part of a classification scheme this must include all associated retention and disposition schedules.") {
		scenario("") (pending)
			
		//TODO
	}
	
	feature("3.1.25: The ERMS must allow administrative roles to add new classes at any point within any class, so long as files or records are not stored at that point.") {
		scenario("") (pending)
			
		//TODO
	}
	
	feature("3.1.26: The ERMS should support the definition and simultaneous use of multiple classification schemes.") {
		scenario("") (pending)
			
		//TODO
		// Define 3 schemes and illustrate simultaneous use of all 3
	}
	
	feature("Administrator can create one or more schemes") {

		scenario("A scheme can be added to a system with no schemes") {
			given("a system with no schemes")
				val rms1 = new System("RMS 1")
			when("a new scheme is added")
				val scheme1 = new Scheme()
				scheme1.title = "Scheme 1"
				rms1.add(scheme1)
			then("the system should have one scheme")
				assert(rms1.children().size === 1)
		}

		scenario("A scheme can be added to a system with one more existing schemes") {
			given("a system with one or more schemes")
				val rms1 = new System("RMS 1")
				val scheme1 = new Scheme()
				scheme1.title = "Scheme 1"
				rms1.add(scheme1)
				val scheme2 = new Scheme()
				scheme2.title = "Scheme 2"
				rms1.add(scheme2)
				val previousCount = rms1.children().size
			when("a new scheme is added")
				val scheme3 = new Scheme()
				scheme3.title = "Scheme 3"
				rms1.add(scheme3)
			then("the system should have one more scheme")
				assert(rms1.children().size === previousCount + 1)
		}

		scenario("Attempt to add a new scheme with the same name as an existing scheme") {
			given("a system with one or more schemes")
				val rms1 = new System()
				rms1.title = "RMS 1"
				val scheme1 = new Scheme()
				scheme1.title = "Scheme 1"
				rms1.add(scheme1)
				val previousCount = rms1.children().size
			when("a new scheme is added with the same name as an existing scheme")
				val scheme2 = new Scheme()
				scheme2.title = "Scheme 1"
			then("the system should throw an IllegalArgumentException")
				//TODO
				assert(true)
				/*
				intercept[IllegalArgumentException] {
					rms1.add(scheme2)
				}
				*/
			and("the system should not have added the scheme")
				assert(rms1.children().contains(scheme2) === false)
			and("the system should have the same number of schemes as before")
				assert(rms1.children().size === previousCount)
		}
	}

	feature("Administrator can rename a scheme") {

		scenario("Administrator renames an existing scheme") {
			given("a system with a scheme called 'Scheme 1'")
				val rms1 = new System("RMS 1")
				val scheme1 = new Scheme()
				scheme1.title = "Scheme 1"
				rms1.add(scheme1)
			when("the scheme is renamed to 'Scheme 2'")
				scheme1.title = "Scheme 2"
			then("the system should have a scheme named 'Scheme 2'")
				//TODO
			and("the system should not have a scheme named 'Scheme 1'")
				//TODO
				pending
		}
	}

	feature("Administrator can delete a scheme") {
		//TODO
		// Can only delete an empty scheme
	}

	feature("Administrator can combine (merge) two schemes into a single scheme") {
		//TODO
	}
}