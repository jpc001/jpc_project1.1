package com.fileplan.moreq2

import java.lang.{Class => JavaClass}
import com.fileplan.hierarchy.TreeNode

class File(childType: java.lang.Class[_ <: TreeNode]) extends TreeNode(true) with CoreAttributes with Container {

	// Supported child types are SubFiles, Volumes or Records
	supportedChildTypes(List(classOf[SubFile], classOf[Volume], classOf[Record]))
	childTypes(List(childType))
}
