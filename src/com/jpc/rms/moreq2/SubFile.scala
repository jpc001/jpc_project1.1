package com.jpc.rms.moreq2

import java.lang.{Class => JavaClass}
import com.jpc.hierarchy.TreeNode

class SubFile(childType: JavaClass[_ <: TreeNode]) extends TreeNode(true) with CoreAttributes with Container {

	supportedChildTypes(List(classOf[Volume], classOf[Record]))
	childTypes(List(childType))
	
}
