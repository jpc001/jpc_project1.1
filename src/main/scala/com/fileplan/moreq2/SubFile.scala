package com.fileplan.moreq2

import java.lang.{Class => JavaClass}
import com.fileplan.hierarchy.TreeNode

class SubFile(childType: JavaClass[_ <: TreeNode]) extends TreeNode(true) with CoreAttributes with Container {

	// Supported child types are Volumes or Records
	supportedChildTypes(List(classOf[Volume], classOf[Record]))
	childTypes(List(childType))
	
}
