package com.reposinet.moreq2

import java.util.Date
import com.reposinet.hierarchy.TreeNode

trait Container extends TreeNode {

	var isClosed: Boolean = false

	var openedOn: Option[Date] = None  
	var closedOn: Option[Date] = None
	var reviewedOn: Option[Date] = None
	var disposeOn: Option[Date] = None

	var openedBy: String = "" // TODO Make a Principal
	var closedBy: String = ""
	var reviewedBy: String = ""

	var disposeReason: String  = "" // The reason why the particular disposal decision was made

	// Override TreeNode methods that manipulate child nodes to check if the container is closed
	override def insert(newChild: TreeNode, childIndex: Int) = {
		if (isClosed) throw new IllegalStateException("This object is closed")
		super.insert(newChild, childIndex)
	}

	override def add(newChild: TreeNode) = {
		if (isClosed) throw new IllegalStateException("This object is closed")
		super.insert(newChild, 0)
	}

	override def remove(childIndex: Int): Unit = {
		if (isClosed) throw new IllegalStateException("This object is closed")
		super.remove(childIndex)
	}

	override def remove(child: TreeNode) = {
		if (isClosed) throw new IllegalStateException("This object is closed")
		super.remove(child)
	}
	
    /**
     * Close a container, which prevents any new objects from being added.
     */
  	def close(): Unit = {
  		if (isClosed) throw new IllegalStateException("This object is already closed")
  		
  		//TODO Audit event
  		closedOn = Some(new Date())
  		closedBy = "currentUser"
  		isClosed = true
  	}

  	//TODO Support merge() method, which moves all children into another container and closes this container
  	
  	
    //TODO Allow delete only if contents is empty?

}
