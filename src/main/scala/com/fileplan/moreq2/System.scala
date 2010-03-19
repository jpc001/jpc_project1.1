package com.fileplan.moreq2

import com.fileplan.hierarchy.TreeNode

class System extends TreeNode with CoreAttributes {

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