package com.reposinet.moreq2

import java.lang.{Class => JavaClass}
import com.reposinet.hierarchy.TreeNode

class File(childType: java.lang.Class[_ <: TreeNode]) extends TreeNode with CoreAttributes with Container {

	// Supported child types are SubFiles, Volumes or Records
	supportedChildTypes(List(classOf[SubFile], classOf[Volume], classOf[Record]))
	childTypes(List(childType))
}
