package com.fileplan.moreq2

import com.fileplan.hierarchy.TreeNode

/**
 * 
 */
class Scheme(title: String) extends Node {

	def this() = this("New Classification Scheme")

	// A scheme only contains classes
	supportedChildTypes(List(classOf[Class]))
	childTypes(supportedChildTypes)
	
}
