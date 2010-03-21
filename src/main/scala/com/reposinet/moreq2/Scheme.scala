package com.reposinet.moreq2

import com.reposinet.hierarchy.TreeNode

/**
 * 
 */
class Scheme(title: String) extends Node {

	def this() = this("New Classification Scheme")

	// A scheme only contains classes
	supportedChildTypes(List(classOf[Class]))
	childTypes(supportedChildTypes)
	
}
