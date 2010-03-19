package com.fileplan.moreq2

import java.lang.{Class => JavaClass}
import com.fileplan.hierarchy.TreeNode

/**
 * A class defines part of a classification scheme.  It may only contain one type of
 * object: classes, files or records.  An exception is thrown if the specified child type
 * is not one of these.
 */
class Class(childType: JavaClass[_ <: TreeNode]) extends TreeNode with CoreAttributes with Container {
	
	// Supported child types are Classes, Files or Records
	supportedChildTypes(List(classOf[Class], classOf[File], classOf[Record]))

	// A Class may only contain one type of child
	childTypes(List(childType))
	
}
