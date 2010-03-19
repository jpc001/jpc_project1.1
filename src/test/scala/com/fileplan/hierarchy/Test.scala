package com.fileplan.hierarchy

import com.fileplan.moreq2._

object Test {

	def main(args: Array[String]) {

		//val root = new TreeNode(None, true)
		val root1 = new TreeNode()
		val model = new TreeModel(root1)
		
		// Method 1 for adding a new node
		val node1 = new TreeNode()
		model.addNode(root1, node1)
		 
		// Method 2 for adding a new node
		val node2 = new TreeNode(true)
		root1.add(node2)

		println("root1:" + root1 + ", size=" + root1.children.size)
		root1.children.foreach(println)
		println("node1:" + node1.isLeaf + ", " + root1.children.contains(node1))
		println("node2:" + node2.isLeaf)
		println(root1.children.indexOf(node2))
		//println("common ancestor=" + node1.commonAncestor(node2))
		println("siblings? " + node1.isSibling(node2))
		node1.path.foreach(println)
		
		root1.remove(1) // node1
		println("root1:" + root1.children.size)
		println("node1: isChild of root1? " + root1.children.contains(node1))
		root1.children.foreach(println)
		root1.insert(node1, 1)
		println("root1:" + root1.children.size)
		println("node1: isChild of root1? " + root1.children.contains(node1))
		root1.children.foreach(println)
		
		val root2 = new TreeNode
		model.moveNode(root2, node1)
		println("node1: isChild of root1? " + root1.children.contains(node1))
		println("root1:" + root1.children.size)
		root1.children.foreach(println)
		println("root2:" + root1.children.size)
		root2.children.foreach(println)
		//println("common ancestor=" + node1.commonAncestor(node2))
		println("siblings? " + root1.isSibling(root2))
		println("siblings? " + node1.isSibling(node2))

		// Not a child
		println(root1.children.indexOf(root2))
		println(root1.isDescendant(root2))
		println(root2.isDescendant(node1))
		println(node1.isAncestor(root2))
		println(root2 + ", " + node1.root)
		println(root2.level + ", " + node1.level)
		
		root1.removeAll()
		println("root1:" + root1.children.size)
		
		// Nulls
		//model.moveNode(null, node1)
		//println(node1.parent)
		
		// IndexOutOfBoundsException - index 2 does not exist
		//println(root2.childAt(2))
		
		// InvalidStateException - child nodes not allowed
		//node2.insert(node1)
		
		// scheme1 allows only RMClass
		val scheme1 = new Scheme
		val moreq2 = new System
		moreq2.add(scheme1)
		//scheme1.allowsChildren = true
		val class1 = new Class(classOf[Class])
		scheme1.add(class1) 
		println("moreq2 model:" + moreq2.root)
		println("scheme1: " + scheme1.children.size)
		scheme1.childTypes.foreach(println)
		
		// scheme2 allows any TreeNode object
		val scheme2 = new Scheme
		//scheme2.add(node1) 
		//scheme2.add(scheme1) 
		println("scheme2: " + scheme2.id + ", " + scheme2.children.size)
		
		// This should throw an exception because Class cannot contain a Scheme
		//val class3 = new Class(classOf[Scheme])
	}
}
