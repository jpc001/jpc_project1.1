package com.reposinet.moreq2

import org.scalatest.FeatureSpec
import org.scalatest.GivenWhenThen

import com.reposinet.moreq2._

/** 
 *  This class tests the MoReq2 Class class.
 *  
 */
class ClassSpec extends FeatureSpec with GivenWhenThen {

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