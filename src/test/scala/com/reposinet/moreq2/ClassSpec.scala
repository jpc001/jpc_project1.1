package com.reposinet.moreq2

import org.scalatest.FeatureSpec
import org.scalatest.GivenWhenThen

import com.reposinet.moreq2._

/** 
 *  This class tests the MoReq2 Class class.
 *  
 */
class ClassSpec extends FeatureSpec with GivenWhenThen {

	feature("3.2.1: The ERMS must support the capture, maintenance and presentation of metadata for files and classes in the classification scheme, compliant with the MoReq2 metadata model.") {
		scenario("") (pending)
			
		//TODO
	}
	
	feature("3.2.2: The ERMS must restrict the ability to add to file and class metadata as set out in the MoReq2 metadata model.") {
		scenario("") (pending)
			
		//TODO
	}
	
	feature("3.2.3: The ERMS must provide a mechanism for allocating automatically a hierarchical classification code (where such a code does not already exist – see 3.1.15) to each class, file, sub-file and volume in the classification scheme.") {
		scenario("") (pending)
			
		//TODO
	}
	
	feature("3.2.4: The ERMS must allow user roles to allocate a title for each electronic class, file, sub-file and volume.") {
		scenario("") (pending)
			
		//TODO
	}
	
	feature("3.2.5: It must be possible to use both the classification code and textual file title separately or together.") {
		scenario("") (pending)
			
		//TODO
	}
	
	feature("3.2.6: The ERMS must allow an administrative role to configure the classification code at configuration time or later.") {
		scenario("") (pending)
			
		//TODO
	}
	
	feature("3.2.7: The ERMS should allow configuration of the classification code") {
		scenario("") (pending)
			
		//TODO
		/* This includes:
		 * the format of the identifier associated with each level of the hierarchy, e.g. numeric, alphabetic;
		 * the first value of this identifier at each class, e.g. 1, 1000;
		 * the interval to be used between successive classes, e.g. 1, 10;
		 * the presence or absence of leading zeroes;
		 * any global prefix, e.g. "corporate/";
		 * any global extension, e.g. country suffix;
		 * the separator between each identifier, e.g. "/", "-".
		*/
	}
	
	feature("3.2.8: The ERMS must store the date of opening and the date of closing of a class or file within the class or file metadata.") {
		scenario("") (pending)
			
		//TODO
	}
	
	feature("3.2.9: The ERMS must store the date of creation of a new class, file, sub-file or volume in the metadata of the class or file.") {
		scenario("") (pending)
			
		//TODO
		// Note that this does not mean "store the creation date of each child object within the parent";
		// it means the creation date must be stored in the RMS and that the creation date is not necessarily
		// the date it was created in the RMS (e.g. could be imported from another system, or it could be
		// a physical file created in the past.  We should also record the date objects were created in the
		// RMS, but this is a different field (see the CoreAttributes trait).
	}
	
	feature("3.2.10: Whenever a new class or file is opened, the ERMS must automatically include in its metadata those attributes which are inherited due to its position in the classification scheme.") {
		scenario("") (pending)
			
		//TODO
	}
	
	feature("3.2.11: The ERMS must allow an administrative role to modify inherited metadata values, to the extent permitted by the MoReq2 metadata model.") {
		scenario("") (pending)
			
		//TODO
	}
	
	feature("3.2.12: Any addition to the inherited metadata of a class should be inherited by default by all its child classes and files.") {
		scenario("") (pending)
			
		//TODO
	}
	
	feature("3.2.13: The ERMS should support the allocation of controlled vocabulary terms compliant to ISO 2788 as descriptive class or file metadata subject terms, in addition to the other requirements in this section.") {
		scenario("") (pending)
			
		//TODO
	}
	
	feature("3.2.14: The ERMS should support the allocation of controlled vocabulary terms compliant to ISO 5964 as descriptive class or file metadata subject terms, in addition to the other requirements in this section.") {
		scenario("") (pending)
			
		//TODO
	}
	
	feature("3.2.15: The ERMS must not impose any practical limit on the number of classes or files which can be defined.") {
		scenario("") (pending)
			
		//TODO
	}
	
	feature("3.2.16: The ERMS should be able to export a list, or repertory, of all files or of files classified against a specific class (and its child classes) in XML format and/or in a human-readable format.") {
		scenario("") (pending)
			
		//TODO
	}
	
	feature("3.2.17: The ERMS must allow an administrative role to configure a class so that it can, or so that it cannot, store records directly.") {
		scenario("") (pending)
			
		//TODO
	}
	
	feature("Administrator can add a new Class to a Scheme") {

		scenario("A top-level Class is added to a Scheme that has no classes") {
			given("a Scheme with no Classes")
			when("a new Class called 'Class 1' is added")
			then("the Scheme should have one Class")
			and("the Class should be called 'Class 1'")
				pending
		}

		scenario("A top-level Class is added to a Scheme already containing one or more top-level Classes") {
			given("a Scheme with one or more top-level Classes, none of which are called 'Class 2'")
			when("a new Class called 'Class 2' is added")
			then("the Scheme should have one more top-level Class")
			and("the Scheme should have a top-level Class called 'Class 2'")
			and("all other top-level Classes should not change in any way")
				pending
		}

	}

	//TODO Review MoReq2 specification and add additional Class features
}