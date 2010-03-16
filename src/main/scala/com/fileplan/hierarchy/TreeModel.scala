package com.fileplan.hierarchy

/**
 * A TreeModel manages nodes in a tree-like structure, which consists of
 * a single 'root' node with zero or more child nodes.
*/
class TreeModel(root: TreeNode) {

	protected var _root: TreeNode = root
	
	def newNode() = new TreeNode()
	
	def root() = _root
	
	//TODO decide if updating the root node is needed or not - could just create a new model
	//def root_(root: TreeNode) = {

		//val oldRoot = _root
        //_root = root
        //TODO
        /*
        if (root == null && oldRoot != null) {
            fireTreeStructureChanged(this, null);
        }
        else {
            nodeStructureChanged(root);
        }
        */
	//}
	
	def indexOf(parent: TreeNode, child: TreeNode): Int = {
		if (parent != null)
			parent.children().indexOf(child)
		else
			-1
    }

	def child(parent: TreeNode, index: Int): TreeNode = {
        parent.children()(index)
    }

	def addNode(parent: TreeNode, child: TreeNode) = {
		parent.add(child)
	}

	/**
	 * Remove a node from the tree.
	 * 
	 * Note that the root node of a tree cannot be removed.
	 */
	def removeNode(parent: TreeNode, child: TreeNode) = {
		parent.remove(child)
	}

	/**
	 * Remove a node from its parent (if any)
	 * @param node
	 */
	def removeNode(node: TreeNode) = {
		node.removeFromParent()
	}

	/**
	 * Move a node.
	 */
	def moveNode(newParent: TreeNode, child: TreeNode) = {
		// This will remove child from its previous parent
		newParent.add(child)
	}
}
