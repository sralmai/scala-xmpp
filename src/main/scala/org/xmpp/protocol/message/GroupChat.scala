package org.xmpp
{
	package protocol.message
	{
		import scala.collection._
		import scala.xml._
		
		import org.xmpp.protocol._
		import org.xmpp.protocol.Protocol._
		
		object GroupChat
		{
			def apply(to:Option[JID], from:Option[JID], body:Option[String]):GroupChat = apply(None, to, from, None, body, None, None)
			
			def apply(id:Option[String], to:Option[JID], from:Option[JID], body:Option[String]):GroupChat = apply(id, to, from, None, body, None, None)
				
			def apply(id:Option[String], to:Option[JID], from:Option[JID], subject:Option[String], body:Option[String]):GroupChat = apply(id, to, from, subject, body, None, None)
					
			def apply(id:Option[String], to:Option[JID], from:Option[JID], subject:Option[String], body:Option[String], thread:Option[String], extensions:Option[Seq[Extension]]):GroupChat =
			{
				val xml = Message.build(MessageTypeEnumeration.GroupChat, id, to, from, subject, body, thread, extensions)
				return apply(xml)
			}
			
			def apply(xml:Node):GroupChat = new GroupChat(xml)
		}
		
		class GroupChat(xml:Node) extends Message(xml, MessageTypeEnumeration.GroupChat)
		{
		}
	}
}