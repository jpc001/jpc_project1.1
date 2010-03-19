package com.fileplan.moreq2

import com.fileplan.hierarchy.TreeNode

class System extends TreeNode(true) with CoreAttributes {

	// A system only contains schemes
	supportedChildTypes(List(classOf[Scheme]))
	childTypes(supportedChildTypes)
}