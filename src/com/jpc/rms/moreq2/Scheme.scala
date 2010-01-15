package com.jpc.rms.moreq2

import com.jpc.hierarchy.TreeNode

/**
 * 
 */
class Scheme() extends TreeNode(true) with CoreAttributes {

	// A scheme only contains classes
	supportedChildTypes(List(classOf[Class]))
	childTypes(supportedChildTypes)
	
}
