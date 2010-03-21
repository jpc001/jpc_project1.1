package com.reposinet.moreq2

import com.reposinet.hierarchy.TreeNode

class Record extends TreeNode with CoreAttributes {

	//TODO A record only contains components
	//TODO Determine how to handle classification codes:
	// Ben prefers an intermediate class called RecordComponent to hold the classification code;
	// Bernard prefers an internal list within Record that allocates classification codes to each Component
	supportedChildTypes(List(classOf[Component]))
	childTypes(supportedChildTypes)
}
