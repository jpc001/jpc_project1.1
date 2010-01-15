package com.jpc.rms.moreq2

import com.jpc.hierarchy.TreeNode

class Volume extends TreeNode with CoreAttributes with Container {

	supportedChildTypes(List(classOf[Record]))
	childTypes(supportedChildTypes)

}
