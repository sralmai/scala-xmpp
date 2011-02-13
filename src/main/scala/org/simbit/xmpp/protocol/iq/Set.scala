package org.simbit.xmpp
{
	package protocol.iq
	{
		import scala.collection._
		import scala.xml._
		
		import org.simbit.xmpp.protocol._
		import org.simbit.xmpp.protocol.Protocol._
		
		object Set
		{
			val iqType = IQTypeEnumeration.Set
			val iqTypeName = iqType.toString // FIXME, this should be done automatically via implicit def, but does not work for enum values for some reason
			
			def apply(id:Option[String], to:Option[JID], from:Option[JID], extension:Option[Extension]=None):Set = apply(build(id, to, from, extension)) 
			
			def apply(xml:Node):Set = new Set(xml)
					
			def build(id:Option[String], to:Option[JID], from:Option[JID], extension:Option[Extension]=None):Node = IQ.build(iqType, id, to, from, extension)
			
			def unapply(set:Set):Option[(Option[String], Option[JID], Option[JID], Option[Extension])] = Some(set.id, set.to, set.from, set.extension)
		}
		
		class Set(xml:Node) extends IQ(xml, Set.iqType)
		{
			def result(extension:Option[Extension]=None):Result = Result(this.id, this.from, this.to, extension)
		}
		
	}
}
