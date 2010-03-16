package com.fileplan.moreq2

import com.fileplan.hierarchy.TreeNode

/**
 * 
 */
class Scheme() extends TreeNode(true) with CoreAttributes {

	// A scheme only contains classes
	supportedChildTypes(List(classOf[Class]))
	childTypes(supportedChildTypes)
	
}
