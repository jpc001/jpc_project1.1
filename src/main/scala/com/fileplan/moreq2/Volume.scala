package com.fileplan.moreq2

import com.fileplan.hierarchy.TreeNode

class Volume extends TreeNode with CoreAttributes with Container {

	// Supported child types are only Records
	supportedChildTypes(List(classOf[Record]))
	childTypes(supportedChildTypes)

}
