package com.jpc.rms.moreq2

import java.lang.{Class => JavaClass}
import com.jpc.hierarchy.TreeNode

class File(childType: java.lang.Class[_ <: TreeNode]) extends TreeNode(true) with CoreAttributes with Container {

	supportedChildTypes(List(classOf[SubFile], classOf[Volume], classOf[Record]))
	childTypes(List(childType))
}
