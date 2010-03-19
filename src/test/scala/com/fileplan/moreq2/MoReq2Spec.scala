package com.fileplan.moreq2

import org.scalatest.FeatureSpec

/** ScalaTest using Scala 2.8 requires ScalaTest version 1.0.1
 *  http://www.scala-tools.org/repo-snapshots/org/scalatest/scalatest/1.0.1-for-scala-2.8.0.Beta1-RC1-SNAPSHOT/
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
class MoReq2Spec extends FeatureSpec {

	feature("Administrator can create one or more classification schemes") {

		scenario("No classification schemes exist") (pending)

		scenario("At least one classification scheme exists") (pending)

		scenario("Attempt to create a classification scheme with the same name") (pending)
	}

}