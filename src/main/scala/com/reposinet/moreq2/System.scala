package com.reposinet.moreq2

import com.reposinet.hierarchy.TreeNode

class System(title: String) extends Node {

	def this() = this("New RMS")
	
	// A system only contains schemes
	supportedChildTypes(List(classOf[Scheme]))
	childTypes(supportedChildTypes)
	
	//TODO Override insert/add methods to prevent child nodes having the same title
	override def insert(newChild: TreeNode, childIndex: Int) {		
		super.insert(newChild, childIndex)
	}

	override def add(newChild: TreeNode) {
		insert(newChild, 0)
	}
}