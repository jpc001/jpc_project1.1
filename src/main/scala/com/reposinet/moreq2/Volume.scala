package com.reposinet.moreq2

import com.reposinet.hierarchy.TreeNode

class Volume extends TreeNode with CoreAttributes with Container {

	// Supported child types are only Records
	supportedChildTypes(List(classOf[Record]))
	childTypes(supportedChildTypes)

}
