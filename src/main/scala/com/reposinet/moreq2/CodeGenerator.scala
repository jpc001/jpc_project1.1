package com.reposinet.moreq2

/**
 * This is a definition of a classification code generator.  Every scheme must have a
 * code generator, and in addition, every container (class, file, subfile and volume)
 * can optionally have its own code generator, or it can be inherited from its parent or
 * other ancestor (back up to the scheme).  In terms of a tree hierarchy, the root node
 * and any branch nodes must have access to code generator.
 * 
 * Code generators do not store classification codes, they simply manipulate them by
 * accepting a definition and generating the next code.
 * 
 * Code generators are not intended to be object-specific.  It is expected that an
 * organisation will define a small set of code generators that will be used by multiple
 * objects (classes, files, etc...).  Each object will manage its own sequence number and
 * pass it to the code generator to obtain the next available code.
 * 
 * The current state of a code sequence is formatted as a JSON string and stored with
 * the parent node.
 * 
 * The default generator is:
 * 
 * <b>/OBJECT:{1}</b>
 * 
 *  - the leading '/' is the separator used between different levels in the hierarchy
 *    e.g. 1/1/1, 1/1/2, etc...;
 *  - OBJECT is a keyword that provides a default code for any object in the hierarchy
 *  - : separates the keyword from the code definition
 *  - {...} indicates a variable substitution
 *  - 1 indicates a numerical sequence starting at 1
 *  - Not increment is specified, so the default of '1' is assumed
 * 
 * However, generators can be defined for specific types of objects (which take
 * precedence over the OBJECT definition):
 * <b>CLASS:{1}
 *    FILE:{1}
 *    SUBFILE:{1}
 *    VOLUME:{1}
 *    RECORD:{1}
 *    COMPONENT:{1}</b>
 * 
 * e.g. 1/1/1/1/1/1 for component 1, assuming sub-files and volumes are used (if
 * not, it would just be 1/1/1/1).
 * 
 * A code generator can define partial sequences, which can act as a 'substitute' for
 * a particular part of a larger code generator.  For example, a scheme may use the default
 * generator (OBJECT:{1})but a specific class may define a code generator such as:
 * 
 *  FILE:FIN{001}
 *  
 *  For 'component 1', in files 1 and 2, this would generate the codes:
 *  	1/FIN001/1/1
 *  	1/FIN002/1/1
 *  
 *  In effect, the definition of 'FILE:1' in the scheme code generator is substituted with
 *  the specific code generator of a class to become 'FILE:FIN{001}'.
 *  
 *  Objects lower in the hierarchy cannot substitute a code for an entity higher in the hierarchy.
 *  For example, a file cannot define a generator such as 'CLASS:MGMT{0001}' as this would cause
 *  inconsistencies in the classification codes.  Files can only define codes for SUBFILE, VOLUME,
 *  RECORD and COMPONENT.  Similarly, SUBFILE can only define VOLUME, RECORD and COMPONENT and so on. 
 *  If a lower level object does define a higher level code, it will simply be ignored.
 * 
 * A sequence can be defined as follows:
 * 
 * <b>{START=00001, INCREMENT=1, RESTART=NONE}</b>
 * 
 * which means the code uses a unique 5-digit sequence number starting at 00001, incremented by 1
 * and has no restart event.  Note that the START setting also acts as the format definition.
 * 
 * Sequences:
 * 	- are defined as {START=start/format, INCREMENT=increment, RESTART=RESTART_EVENT}
 *  - the keywords START, INCREMENT and RESTART are optional - if they are not sepecified
 *    then the values are assumed to be in the order {START, INCREMENT, RESTART},
 *    e.g. {00001,1,NONE} is the same as {START=00001, INCREMENT=1, RESTART=NONE}
 *  - can be alphanumeric
 *  - default start is 1
 *  - default increment is 1
 *  - default restart event is NONE
 *  - can only be restarted if some other portion of the generator changes to a new value (e.g. a day/month/year changes)
 * 
 * Alphabetic sequences start at 'A' (or 'a') and end at 'Z' (or 'z').  For example:
 * 
 * <b>{FA001}</b>
 * 
 * defines a sequence starting at 'FA001' going to a maximum of 'ZZ999', in increments of 1.
 * 
 * Whenever an child object is added to the container, the code sequence is updated
 * to reflect the next available sequence number, e.g. {00002:1} after the first child
 * and {00003:1} after the second child and so on.
 * 
 * NOTE: To handle distributed systems, every top-level {parent} must be a unique
 * system identifier, otherwise the same code could be generated on different systems
 * within the same classification scheme.
 */
class CodeGenerator(definition: String) {
	
	private var _definition = definition
	private var _sequence = 0
	
	/**
	 * Generate and increment the next sequence number
	*/
	def next() {
		
	}
}