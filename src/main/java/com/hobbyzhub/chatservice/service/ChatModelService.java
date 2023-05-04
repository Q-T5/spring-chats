package com.hobbyzhub.chatservice.service;

import com.hobbyzhub.chatservice.entity.ChatModel;
import com.hobbyzhub.chatservice.repository.ChatModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.UpdateDefinition;
import org.springframework.stereotype.Service;

@Service
public class ChatModelService {
    @Autowired
    ChatModelRepository chatModelRepository;

    @Autowired
    MongoTemplate chatModelTemplate;

    public void createNewChatModel(ChatModel newChatModel) {
        chatModelRepository.save(newChatModel);
    }

    public void updateChatModelName(
        Query query, UpdateDefinition updateDefinition, FindAndModifyOptions options, Class entityClass) {
        chatModelTemplate.findAndModify(query, updateDefinition, options, entityClass);
    }

    public void addParticipantToChatModel(
        Query query, UpdateDefinition updateDefinition, FindAndModifyOptions options, Class entityClass) {
        chatModelTemplate.findAndModify(query, updateDefinition, options, entityClass);
    }

    public void makeParticipantAnAdmin(Query query, UpdateDefinition updateDefinition, Class entityClass) {
        chatModelTemplate.updateFirst(query, updateDefinition, entityClass);
    }

    public void deleteParticipantFromChatModel(Query query, UpdateDefinition updateDefinition, Class entityClass) {
        chatModelTemplate.updateFirst(query, updateDefinition, entityClass);
    }

    public void makeParticipantAdmin() {

    }

    public void deleteEntireChatModel(String chatModelId) {
        chatModelRepository.deleteById(chatModelId);
    }
}
