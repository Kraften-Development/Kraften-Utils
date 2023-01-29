package dk.kraften.kraftenbande.Builders.MessageBuilder.Interfaces;

import dk.kraften.kraftenbande.Builders.MessageBuilder.Objects.ChatMessage;
import dk.kraften.kraftenbande.Builders.MessageBuilder.Objects.ReplacementContainer;

import java.util.Set;

public interface MessageContainer {

    /**
     * Get a specific message
     *
     * @param key message key
     * @return the {@link ChatMessage}
     */
    ChatMessage getMessage(String key);

    /**
     * Get a specific message
     *
     * @param key message key
     * @param container {@link ReplacementContainer} with replacements
     * @return the {@link ChatMessage}
     */
    ChatMessage getMessage(String key, ReplacementContainer container);

    /**
     * @return a {@link Set} of all messages
     */
    Set<ChatMessage> getMessages();

    /**
     * @return a {@link Set} of all message keys
     */
    Set<String> getMessageKeys();
}
