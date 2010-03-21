package com.reposinet.moreq2

import java.lang.{Class => JavaClass}
import com.reposinet.hierarchy.TreeNode

class SubFile(childType: JavaClass[_ <: TreeNode]) extends TreeNode(true) with CoreAttributes with Container {

	// Supported child types are Volumes or Records
	supportedChildTypes(List(classOf[Volume], classOf[Record]))
	childTypes(List(childType))
	
}
