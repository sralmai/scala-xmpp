package org.xmpp
{
	package protocol.message
	{
		import scala.collection._
		import scala.xml._
		
		import org.xmpp.protocol._
		import org.xmpp.protocol.extensions._
		
		import org.xmpp.protocol.Protocol._
		
		object MessageFactory //extends StanzaFactory[Message]
		{
			def create(xml:Node):Message = 
			{		
				require("message" == xml.label)
				
				(xml \ "@type").text match
				{
					// FIXME, use the enum values (attribute stanzaType) instead of messageTypeName, getting compilation error even with implicict cast
					case Normal.messageTypeName => Normal(xml) 
					case Chat.messageTypeName => Chat(xml) 
					case GroupChat.messageTypeName => GroupChat(xml) 
					case Headline.messageTypeName => Headline(xml) 
					case Error.messageTypeName => Error(xml) 
					case _ => throw new Exception("unknown message stanza") // TODO, give a more detailed error message here
				}
			}
		}
	}
}