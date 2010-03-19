package com.fileplan.moreq2

import org.scalatest.FeatureSpec
import org.scalatest.GivenWhenThen

import com.fileplan.moreq2._

/** ScalaTest using Scala 2.8 requires ScalaTest version 1.0.1
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
class MoReq2Spec extends FeatureSpec with GivenWhenThen {

	feature("Administrator can create one or more classification schemes") {

		scenario("No classification schemes exist") {
			given("A system with no classification schemes")
				val rms1 = new System()
				rms1.title = "RMS 1"
			when("a new classification scheme is added")
				val scheme1 = new Scheme()
				scheme1.title = "Scheme 1"
				rms1.add(scheme1)
			then("the system should have one classifaction scheme")
				assert(rms1.children().size === 1)
		}

		scenario("At least one classification scheme exists") {
			given("A system with one or more classification schemes")
				val rms1 = new System()
				rms1.title = "RMS 1"
				val scheme1 = new Scheme()
				scheme1.title = "Scheme 1"
				rms1.add(scheme1)
				val scheme2 = new Scheme()
				scheme2.title = "Scheme 2"
				rms1.add(scheme2)
				val previousCount = rms1.children().size
			when("a new classification scheme is added")
				val scheme3 = new Scheme()
				scheme3.title = "Scheme 3"
				rms1.add(scheme3)
			then("the system should have one more classifaction scheme")
				assert(rms1.children().size === previousCount + 1)
		}

		scenario("Attempt to add a new classification scheme with the same name as an existing classification scheme") {
			given("A system with one or more classification schemes")
				val rms1 = new System()
				rms1.title = "RMS 1"
				val scheme1 = new Scheme()
				scheme1.title = "Scheme 1"
				rms1.add(scheme1)
				val previousCount = rms1.children().size
			when("a new classification scheme is added with the same name as an existing classification scheme")
				val scheme2 = new Scheme()
				scheme2.title = "Scheme 1"
			then("the system should throw an IllegalArgumentException")
				pending
				/*
				intercept[IllegalArgumentException] {
					rms1.add(scheme2)
				}
				*/
			and("the system should not have added the classifaction scheme")
				assert(rms1.children().contains(scheme2) === false)
			and("the system should have the same number of classification schemes as before")
				assert(rms1.children().size === previousCount)
		}
	}

}