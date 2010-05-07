package com.reposinet.persistence

import scala.reflect.BeanProperty

class CouchDbId() {
	
	@BeanProperty
	var uuids: Array[String] = new Array[String](0)
	
	def id() = uuids(0)
	
}
