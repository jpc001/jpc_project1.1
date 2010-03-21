package com.reposinet.hierarchy

import java.lang.{Class => JavaClass}
import scala.collection.immutable.List

/**
 * A node within a tree.  There are three distinct node types:
 *
 * <code>Root Node</code> has no parent node and can have child nodes (possibly none)
 * <code>Branch Node</code> can have child nodes (possibly none)
 * <code>Leaf Node</code> does not allow child nodes
 * 
 * A root node is also a branch node, since it allows child nodes.
 *
 * Child nodes are held in a List to ensure immutability.
 **/
class TreeNode(val allowsChildren: Boolean) {

	def this() = this(true)

	private var _parent: Option[TreeNode] = None
	private var _children: List[TreeNode] = Nil
	private var _supportedChildTypes: List[JavaClass[_ <: TreeNode]] = Nil
	private var _actualChildTypes: List[JavaClass[_ <: TreeNode]] = Nil

	/**
	 * @return The parent of this node.
	 */
	def parent() = _parent
	def supportedChildTypes() = _supportedChildTypes
	def supportedChildTypes(supportedChildTypes: List[JavaClass[_ <: TreeNode]]) = {
		_supportedChildTypes = supportedChildTypes
	}
	def isSupportedChildType(childType: JavaClass[_ <: TreeNode]) = {
		// childType is supported if there are no restrictions (supported child types is Nil)
		// or if the specified child type is one of the supported child types (or a subclass
		// of them)
		_supportedChildTypes == Nil || _supportedChildTypes.foldLeft(false)((r,c) => r || c.isAssignableFrom(childType))
	}
	def childTypes(): List[JavaClass[_ <: TreeNode]] = _actualChildTypes
	def childTypes(childTypes: List[JavaClass[_ <: TreeNode]]) = {
		
		// Check that each specified child type is supported
		for (childType <- childTypes) {
			if (!isSupportedChildType(childType))
				throw new IllegalArgumentException("Unsupported child type:" + childType.getCanonicalName)
		}
		_actualChildTypes = childTypes
	}

	
	/**
	 * Assign a node to a new parent.  Note that this function does not automatically
	 * add itself to the parent's list of child nodes, as that responsibility lies
	 * with the parent node to manage its children.
	 */
	protected def parent(newParent: Option[TreeNode]) = _parent = newParent

	/**
	 * @return A list containing the child nodes.
	 */
	def children() = _children
	
	/**
	 * @return True only if this is a root node.  A root node is any node that has no parent node.
	 */
	def isRoot(): Boolean = _parent == None
	
	/**
	 * @return True only if this node is a branch.  A branch node is any node that allows children.
	 */
	def isBranch(): Boolean = allowsChildren
	
	/**
	 * @return True only if this node is a leaf.  A leaf node is any node that does not allow children.
	 */
	def isLeaf(): Boolean = !allowsChildren

	/**
	 * Inserts a new child node into the list of children nodes at the specified
	 * index.
	 * 
	 * @throws IllegalStateException if this node does not allow children
	 * @throws IllegalArgumentException if the child node is null or is an ancestor of this node
	 */
	def insert(newChild: TreeNode, childIndex: Int) = {
		if (!allowsChildren)
			throw new IllegalStateException("node does not allow children")
		else if (isAncestor(newChild))
			throw new IllegalArgumentException("new child is an ancestor")
		else if (childTypes != Nil && !childTypes.contains(newChild.getClass))
			throw new IllegalArgumentException(newChild.getClass().getCanonicalName + " is not allowed; only " + childTypes.toString)

		// Remove child from its old parent, if any
        val oldParent = newChild.parent
        if (oldParent.isDefined) oldParent.get.remove(newChild)
        
        // Set the child's parent to this node
        newChild.parent(Some(this))
		
        if (childIndex == 0)
        	// Prepend new child node to children for best performance.  See:
        	// http://stackoverflow.com/questions/1241166/preferred-way-to-create-a-scala-list 
        	_children = newChild :: _children
        else
        	// Insert child at the specified index
        	_children = _children.splitAt(childIndex) match {
				case (pre, post) => pre ::: newChild :: post
			}
	}

	/**
	 * Adds a new child node to the beginning of the list of children nodes.
	 */
	def add(newChild: TreeNode) = this.insert(newChild, 0)

	/**
	 * Removes the child node at the specified index.
	 */
	def remove(childIndex: Int): Unit = removeKnownChild(_children(childIndex))

	/**
	 * Removes the specified child node from this node.
	 */
 	def remove(child: TreeNode) = {
		if (_children.contains(child))
			removeKnownChild(child)
 	}
	
	/**
	 * Removes a child without checking to see if the child exists, as it expects the caller to have
	 * first verified the specified node is really a child.  The child's parent is set to None.
	 */
	private def removeKnownChild(child: TreeNode) {
		// Remove child
		_children = _children.filter(_ != child)
		
		// Ensure child now has no parent
		child.parent(None)
	}
	
 	/**
 	 * Removes this node from its parent, if any.
 	 */
 	def removeFromParent() = {
 		if (parent.isDefined)
 			parent.get.removeKnownChild(this)
 	}

 	/**
 	 * Removes all children from this node.
 	 */
 	def removeAll() = _children.foreach(removeKnownChild)

 	/**
 	 * @return The root node of the tree that contains this node.
 	 */
	def root(): TreeNode = path()(0)
		
 	/**
 	 * @param node A non-null tree node.
 	 * 
 	 * @return True only if the specified node is an ancestor of this node. A node is an ancestor of itself.
 	 */
	def isAncestor(node: TreeNode): Boolean = {
        var ancestor: Option[TreeNode] = Some(this)

       	do {
       		if (ancestor.get == node) return true
       		ancestor = ancestor.get.parent
       	} while(ancestor.isDefined)
        
       	false
	}

 	/**
 	 * @param node A non-null tree node.
 	 * 
 	 * @return True only if the specified node is a descendant of this node.
 	 */
	def isDescendant(node: TreeNode) = node.isAncestor(this)

 	/**
 	 * @param node A non-null tree node.
 	 * 
 	 * @return True only if the specified node has the same parent node as this node.  A node is a sibling of itself.
 	 */
	def isSibling(node: TreeNode) = {
		node.parent != None && node.parent == this.parent
	}

 	/**
 	 * @param node A non-null tree node.
 	 * 
 	 * @return True only if the specified node is in the same tree as this node (i.e.
 	 * they have the same root node).
 	 */
	def isRelated(node: TreeNode) = {
		node.root == this.root
	}
	
	/* The following code has been commented out pending further development.  There are
	 * potential uses for it, but no definite use-cases.
	 */
	
	/*
 	 * @param node A non-null tree node.
 	 * 
	 * @return The closest common ancestor of this node and the specified node, or None 
	 * if there is no common ancestor.  A node is an ancestor of itself.
	 */
	/*
	def commonAncestor(node: TreeNode): Option[TreeNode] = {
		
		if (node == this) return Some(this)
		
		// Get the path to the root for both this node and the
		// specified node, then take the intersection of both lists;
		// the last item in the intersected list will be the common
		// ancestor.
		val thisPath: List[TreeNode] = this.path 
		val nodePath: List[TreeNode] = node.path
		
		val commonPath: List[TreeNode] = thisPath.intersect(nodePath)
		if (commonPath.size > 0) 
			Some(commonPath(commonPath.size - 1))
		else
			None
	}
	*/

	/**
	 * @return A list of tree nodes from the root to this node.
	 */
	def path(): List[TreeNode] = {
		var path: List[TreeNode] = Nil
        var ancestor: Option[TreeNode] = Some(this)

        do {
            path = ancestor.get :: path
            ancestor = ancestor.get.parent
        } while (ancestor.isDefined)

        path
	}
	
	/**
     * @return The number of nodes from this node to the root node.
     * If this node is the root, returns 0.
     */
    def level(): Int = {
        var ancestor: Option[TreeNode] = Some(this)
        var levels = 0

        while(ancestor.get.parent.isDefined) {
            levels += 1
        	ancestor = ancestor.get.parent
        }

        levels
    }
}
