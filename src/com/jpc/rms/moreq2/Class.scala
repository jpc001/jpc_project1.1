package com.jpc.rms.moreq2

import java.lang.{Class => JavaClass}
import com.jpc.hierarchy.TreeNode

/**
 * A class defines part of a classification scheme.  It may only contain one type of
 * object: classes, files or records.  An exception is thrown if the specified child type
 * is not one of these.
 */
class Class(childType: JavaClass[_ <: TreeNode]) extends TreeNode(true) with CoreAttributes with Container {
	
	supportedChildTypes(List(classOf[Class], classOf[File], classOf[Record]))
	childTypes(List(childType))
	
}
