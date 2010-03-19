package com.fileplan.moreq2

import com.fileplan.hierarchy.TreeNode

//TODO Decide whether to keep this class or not?  I suspect Bernard won't like it.
//TODO Can this constructor be used/overridden by subclasses?
// Basically, looking to define a TreeNode class with a title as a constructor
// so I don't have to repeat the same code in all the MoReq2 classes.
class Node(title: String) extends TreeNode with CoreAttributes {
	
	def this() = this("New Node")

}